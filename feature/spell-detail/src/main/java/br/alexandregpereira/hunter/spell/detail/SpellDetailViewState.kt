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

package br.alexandregpereira.hunter.spell.detail

import androidx.lifecycle.SavedStateHandle
import br.alexandregpereira.hunter.spell.detail.ui.SpellState

internal data class SpellDetailViewState(
    val spell: SpellState? = null,
    val showDetail: Boolean = false,
)

internal fun SavedStateHandle.getState(): SpellDetailViewState {
    return SpellDetailViewState(
        showDetail = this["showDetail"] ?: false
    )
}

internal fun SpellDetailViewState.saveState(
    savedStateHandle: SavedStateHandle
): SpellDetailViewState {
    savedStateHandle["showDetail"] = showDetail
    return this
}

internal fun SpellDetailViewState.changeSpell(spellState: SpellState): SpellDetailViewState {
    return copy(spell = spellState, showDetail = true)
}

internal fun SpellDetailViewState.hideDetail(): SpellDetailViewState {
    return copy(showDetail = false)
}
