package com.example.whatsapp_clone.newCompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.whatsapp_clone.HomeTab
import com.example.whatsapp_clone.ui.theme.myColour


@Composable
fun AppTabBar(
    modifier: Modifier = Modifier,
    children: @Composable (Modifier) -> Unit
){
    Row(){
        children(
            Modifier
                .weight(2f)
                .align(Alignment.CenterVertically)

        )
}}
@Composable
fun AppTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    TabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        indicator = { tabIndicator ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabIndicator[tabSelected.ordinal])
            )
        },
        divider = {}
    ) {
        titles.forEachIndexed {index, title ->
            val selected = index == tabSelected.ordinal
            Tab(
                modifier = Modifier.background(color = myColour),
                text = { Text(text = title)},
                selected = selected,
                onClick = { onTabSelected(HomeTab.values()[index]) }

            )
        }
    }
}