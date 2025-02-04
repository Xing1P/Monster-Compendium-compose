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

package br.alexandregpereira.hunter.folder.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import br.alexandregpereira.hunter.folder.detail.ui.FolderDetailScreen

@Composable
fun FolderDetailFeature(
    contentPadding: PaddingValues = PaddingValues()
) {
    val viewModel: FolderDetailViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    FolderDetailScreen(
        state = state,
        contentPadding = contentPadding,
        onItemCLick = viewModel::onItemClick,
        onItemLongCLick = viewModel::onItemLongClick,
        onClose = viewModel::onClose,
    )
}
