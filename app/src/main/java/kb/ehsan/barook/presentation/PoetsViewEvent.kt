package kb.ehsan.barook.presentation

sealed interface PoetsViewEvent {
    data object Retry : PoetsViewEvent
}