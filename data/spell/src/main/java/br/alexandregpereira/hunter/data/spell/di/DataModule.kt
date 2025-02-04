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

package br.alexandregpereira.hunter.data.spell.di

import br.alexandregpereira.hunter.data.spell.SettingsSpellDataRepositoryImpl
import br.alexandregpereira.hunter.data.spell.SpellRepositoryImpl
import br.alexandregpereira.hunter.data.spell.SpellSettingsRepositoryImpl
import br.alexandregpereira.hunter.data.spell.local.SpellLocalDataSource
import br.alexandregpereira.hunter.data.spell.local.SpellLocalDataSourceImpl
import br.alexandregpereira.hunter.data.spell.remote.SpellRemoteDataSource
import br.alexandregpereira.hunter.data.spell.remote.SpellRemoteDataSourceImpl
import br.alexandregpereira.hunter.domain.settings.SettingsSpellDataRepository
import br.alexandregpereira.hunter.domain.spell.SpellRepository
import br.alexandregpereira.hunter.domain.spell.SpellSettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataModule {

    @ViewModelScoped
    @Binds
    internal abstract fun bindMonsterFolderRepository(
        spellRepositoryImpl: SpellRepositoryImpl
    ): SpellRepository

    @Binds
    internal abstract fun bindSpellLocalDataSource(
        spellLocalDataSourceImpl: SpellLocalDataSourceImpl
    ): SpellLocalDataSource

    @Binds
    internal abstract fun bindSpellRemoteDataSource(
        spellRemoteDataSourceImpl: SpellRemoteDataSourceImpl
    ): SpellRemoteDataSource

    @Binds
    internal abstract fun bindSettingsSpellDataRepository(
        repository: SettingsSpellDataRepositoryImpl
    ): SettingsSpellDataRepository

    @Binds
    internal abstract fun bindSpellSettingsRepository(
        repository: SpellSettingsRepositoryImpl
    ): SpellSettingsRepository
}
