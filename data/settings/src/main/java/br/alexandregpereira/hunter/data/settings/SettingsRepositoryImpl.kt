/*
 * Copyright 2022 Alexandre Gomes Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.alexandregpereira.hunter.data.settings

import android.content.SharedPreferences
import br.alexandregpereira.hunter.domain.settings.SettingsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class SettingsRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SettingsRepository {

    override fun saveSettings(values: Map<String, String>): Flow<Unit> {
        return flow {
            val editor = sharedPreferences.edit()
            values.forEach { entry ->
                editor.putString(entry.key, entry.value).apply()
            }
            emit(Unit)
        }
    }

    override fun getSettingsValue(key: String, defaultValue: String): Flow<String> {
        return flow {
            emit(sharedPreferences.getString(key, defaultValue) ?: defaultValue)
        }
    }
}
