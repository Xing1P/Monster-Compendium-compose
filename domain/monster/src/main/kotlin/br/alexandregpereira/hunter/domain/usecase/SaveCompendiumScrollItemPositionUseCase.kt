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

package br.alexandregpereira.hunter.domain.usecase

import br.alexandregpereira.hunter.domain.repository.CompendiumRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveCompendiumScrollItemPositionUseCase @Inject internal constructor(
    private val repository: CompendiumRepository
) {

    operator fun invoke(position: Int): Flow<Unit> {
        return repository.saveCompendiumScrollItemPosition(position)
    }
}