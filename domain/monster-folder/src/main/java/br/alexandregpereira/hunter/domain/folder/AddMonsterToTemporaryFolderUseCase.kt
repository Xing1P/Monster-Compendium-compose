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

package br.alexandregpereira.hunter.domain.folder

import br.alexandregpereira.hunter.domain.folder.GetMonstersByTemporaryFolderUseCase.Companion.TEMPORARY_FOLDER_NAME
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class AddMonsterToTemporaryFolderUseCase @Inject constructor(
    private val addMonstersToFolder: AddMonstersToFolderUseCase,
) {

    operator fun invoke(index: String): Flow<Unit> {
        return addMonstersToFolder(
            folderName = TEMPORARY_FOLDER_NAME,
            indexes = listOf(index)
        )
    }
}
