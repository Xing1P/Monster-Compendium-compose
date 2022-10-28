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

package br.alexandregpereira.hunter.ui.compendium.monster

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.alexandregpereira.hunter.ui.compendium.Compendium
import br.alexandregpereira.hunter.ui.compendium.CompendiumRow
import br.alexandregpereira.hunter.ui.compendium.SectionState
import br.alexandregpereira.hunter.ui.compose.MonsterCard
import br.alexandregpereira.hunter.ui.compose.Window

@Composable
fun MonsterCompendium(
    monstersBySection: Map<SectionState, List<MonsterRowState>>,
    listState: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onItemCLick: (index: String) -> Unit = {},
    onItemLongCLick: (index: String) -> Unit = {},
) = Compendium(
    monstersBySection = monstersBySection,
    listState = listState,
    contentPadding = contentPadding,
    key = { it.leftCardState.index },
    cardContent = { monsterCardState ->
        MonsterCard(
            name = monsterCardState.name,
            url = monsterCardState.imageState.url,
            iconRes = monsterCardState.imageState.type.iconRes,
            backgroundColor = monsterCardState.imageState.backgroundColor.getColor(
                isSystemInDarkTheme()
            ),
            challengeRating = monsterCardState.imageState.challengeRating,
            modifier = Modifier,
            onCLick = { onItemCLick(monsterCardState.index) },
            onLongCLick = { onItemLongCLick(monsterCardState.index) }
        )
    }
)

@Preview
@Composable
fun MonsterCompendiumPreview() = Window {
    val imageState = MonsterImageState(
        url = "",
        type = MonsterTypeState.ABERRATION,
        challengeRating = 8.0f,
        backgroundColor = ColorState(
            light = "#ffe0e0",
            dark = "#ffe0e0"
        )
    )
    MonsterCompendium(
        monstersBySection = mapOf(
            SectionState(title = "Any") to (0..10).map {
                val leftMonster = MonsterCardState(
                    index = "asdasdasd",
                    name = "Monster of monsters",
                    imageState = imageState,
                )
                val rightMonster = if (it == 1) {
                    MonsterCardState(
                        index = "asdasdasd",
                        name = "Monster of monsters",
                        imageState = imageState,
                    )
                } else {
                    null
                }
                leftMonster and rightMonster
            }
        )
    )
}

@Preview
@Composable
fun MonsterCompendiumWithSectionTitlePreview() = Window {
    val imageState = MonsterImageState(
        url = "",
        type = MonsterTypeState.ABERRATION,
        challengeRating = 8.0f,
        backgroundColor = ColorState(
            light = "#ffe0e0",
            dark = "#ffe0e0"
        )
    )
    MonsterCompendium(
        monstersBySection = mapOf(
            SectionState(title = "Title") to (0..10).map {
                val leftMonster = MonsterCardState(
                    index = "asdasdasd",
                    name = "Monster of monsters",
                    imageState = imageState,
                )
                val rightMonster = if (it == 1) {
                    MonsterCardState(
                        index = "asdasdasd",
                        name = "Monster of monsters",
                        imageState = imageState,
                    )
                } else {
                    null
                }
                leftMonster and rightMonster
            }
        )
    )
}

@Preview
@Composable
fun MonsterSection2ItemsPreview() = Window {
    val imageState = MonsterImageState(
        url = "",
        type = MonsterTypeState.ABERRATION,
        challengeRating = 8.0f,
        backgroundColor = ColorState(
            light = "#ffe0e0",
            dark = "#ffe0e0"
        )
    )
    CompendiumRow(
        leftCard = MonsterCardState(
            index = "asdasdasd",
            name = "Monster of monsters",
            imageState = imageState
        ),
        rightCard = MonsterCardState(
            index = "asdasdasd",
            name = "Monster of monsters",
            imageState = imageState
        )
    ) { monsterCardState ->
        MonsterCard(
            name = monsterCardState.name,
            url = monsterCardState.imageState.url,
            iconRes = monsterCardState.imageState.type.iconRes,
            backgroundColor = monsterCardState.imageState.backgroundColor.getColor(
                isSystemInDarkTheme()
            ),
            challengeRating = monsterCardState.imageState.challengeRating,
            modifier = Modifier,
        )
    }
}

@Preview
@Composable
fun MonsterSection1ItemPreview() = Window {
    val imageState = MonsterImageState(
        url = "",
        type = MonsterTypeState.ABERRATION,
        challengeRating = 8.0f,
        backgroundColor = ColorState(
            light = "#ffe0e0",
            dark = "#ffe0e0"
        )
    )
    CompendiumRow(
        leftCard = MonsterCardState(
            index = "asdasdasd",
            name = "Monster of monsters",
            imageState = imageState
        )
    ) { monsterCardState ->
        MonsterCard(
            name = monsterCardState.name,
            url = monsterCardState.imageState.url,
            iconRes = monsterCardState.imageState.type.iconRes,
            backgroundColor = monsterCardState.imageState.backgroundColor.getColor(
                isSystemInDarkTheme()
            ),
            challengeRating = monsterCardState.imageState.challengeRating,
            modifier = Modifier,
        )
    }
}
