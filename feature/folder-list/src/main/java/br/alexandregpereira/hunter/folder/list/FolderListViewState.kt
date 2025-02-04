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

package br.alexandregpereira.hunter.folder.list

import androidx.lifecycle.SavedStateHandle
import br.alexandregpereira.hunter.folder.list.ui.FolderCardState

internal data class FolderListViewState(
    val folders: List<FolderCardState> = emptyList(),
    val itemSelection: Set<String> = emptySet(),
    val isItemSelectionOpen: Boolean = false
) {
    val itemSelectionCount = itemSelection.size
    val itemSelectionEnabled = isItemSelectionOpen
}

internal fun SavedStateHandle.getState(): FolderListViewState {
    return FolderListViewState(
        itemSelection = this["itemSelection"] ?: emptySet(),
        isItemSelectionOpen = this["isItemSelectionOpen"] ?: false
    )
}

internal fun FolderListViewState.saveState(savedStateHandle: SavedStateHandle): FolderListViewState {
    savedStateHandle["itemSelection"] = itemSelection
    savedStateHandle["isItemSelectionOpen"] = isItemSelectionOpen
    return this
}

internal fun FolderListViewState.changeSelectedFolders(
    folders: List<FolderCardState>
): FolderListViewState {
    return copy(
        folders = folders.map {
            it.copy(
                selected = isItemSelectionOpen && itemSelection.contains(it.folderName)
            )
        }
    )
}
