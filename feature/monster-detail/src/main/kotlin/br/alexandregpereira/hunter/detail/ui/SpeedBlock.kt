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

package br.alexandregpereira.hunter.detail.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.alexandregpereira.hunter.detail.R
import br.alexandregpereira.hunter.ui.compose.Window
import br.alexandregpereira.hunter.ui.theme.HunterTheme

@Composable
fun SpeedBlock(
    speed: SpeedState,
    modifier: Modifier = Modifier,
    contentPaddingBottom: Dp = 0.dp,
) {
    val prefixTitle = stringResource(R.string.monster_detail_speed_title)
    val title = if (speed.hover) {
        "$prefixTitle (${stringResource(R.string.monster_detail_speed_hover)})"
    } else prefixTitle
    Block(title = title, modifier = modifier, contentPaddingBottom = contentPaddingBottom) {

        SpeedGrid(speed)
    }
}

@Composable
private fun SpeedGrid(
    speed: SpeedState,
) = Grid {

    speed.values.forEach { speedValue ->
        val iconRes = speedValue.type.iconRes
        IconInfo(title = speedValue.valueFormatted, painter = painterResource(iconRes))
    }
}

@Preview
@Composable
private fun SpeedGridPreview() = Window {
    SpeedGrid(
        speed = SpeedState(
            hover = false, values = (0..6).map {
                SpeedValueState(
                    type = SpeedTypeState.WALK,
                    valueFormatted = "10m"
                )
            }
        )
    )
}

@Preview
@Composable
private fun SpeedBlockPreview() = HunterTheme {
    SpeedBlock(
        speed = SpeedState(
            hover = true, values = listOf(
                SpeedValueState(
                    type = SpeedTypeState.WALK,
                    valueFormatted = "10m"
                )
            )
        )
    )
}
