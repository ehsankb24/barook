package kb.ehsan.barook.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kb.ehsan.barook.presentation.component.item.ItemComponent
import kb.ehsan.barook.presentation.component.item.ItemUiModel
import kb.ehsan.barook.ui.theme.BarookTheme

@Composable
internal fun PoetsDataLayout(
    modifier: Modifier = Modifier,
    items: List<ItemUiModel>
) = LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    items(items) {
        ItemComponent(it)
    }
}

@Preview
@Composable
private fun PoetsDataLayoutPreview() {
    BarookTheme {
        PoetsDataLayout(
            items = listOf(
                ItemUiModel("item 1", ""),
                ItemUiModel("item 2", ""),
                ItemUiModel("item 3", ""),
                ItemUiModel("item 4", "")
            )
        )
    }
}