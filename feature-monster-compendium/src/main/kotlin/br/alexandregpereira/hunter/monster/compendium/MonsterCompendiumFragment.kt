/*
 * Copyright (c) 2021 Alexandre Gomes Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.alexandregpereira.hunter.monster.compendium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import br.alexandregpereira.hunter.domain.Navigator
import br.alexandregpereira.hunter.monster.compendium.ui.MonsterCompendium
import br.alexandregpereira.hunter.ui.compose.CircularLoading
import br.alexandregpereira.hunter.ui.compose.Window
import br.alexandregpereira.hunter.ui.util.createComposeView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MonsterCompendiumFragment : Fragment() {

    private val viewModel: MonsterCompendiumViewModel by viewModel()
    private val navigator: Navigator by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return requireContext().createComposeView { padding ->
            MonsterCompendium(
                viewModel = viewModel,
                navigator = navigator,
                contentPadding = padding
            )
        }
    }
}

@Composable
internal fun MonsterCompendium(
    viewModel: MonsterCompendiumViewModel,
    navigator: Navigator,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) = Window {
    val viewState = viewModel.stateLiveData.observeAsState().value ?: return@Window

    CircularLoading(viewState.isLoading) {
        MonsterCompendium(
            monstersBySection = viewState.monstersBySection,
            contentPadding = contentPadding
        ) {
            viewModel.navigateToDetail(index = it)
        }

        Action(viewModel, navigator)
    }
}

@Composable
internal fun Action(
    viewModel: MonsterCompendiumViewModel,
    navigator: Navigator
) {
    val action = viewModel.actionLiveData.observeAsState().value?.getContentIfNotHandled() ?: return
    when (action) {
        is MonsterCompendiumAction.NavigateToDetail -> navigator.navigateToDetail(action.index)
    }
}