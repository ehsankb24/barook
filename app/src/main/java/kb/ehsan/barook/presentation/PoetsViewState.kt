package kb.ehsan.barook.presentation

import kb.ehsan.barook.presentation.component.item.ItemUiModel

sealed interface PoetsViewState {
    data object Loading : PoetsViewState
    data class Failed(val message: String) : PoetsViewState
    data class ShowData(val items: List<ItemUiModel>) : PoetsViewState
}