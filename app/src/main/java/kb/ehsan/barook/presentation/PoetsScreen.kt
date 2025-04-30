package kb.ehsan.barook.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kb.ehsan.barook.presentation.component.PoetsDataLayout
import kb.ehsan.barook.presentation.component.PoetsFailedLayout
import kb.ehsan.barook.presentation.component.PoetsLoadingLayout

@Composable
fun PoetsScreen(
    viewModel: PoetsViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()
    PoetsLayout(viewState, viewModel::onEvent)
}

@Composable
private fun PoetsLayout(viewState: PoetsViewState, onEvent: (PoetsViewEvent) -> Unit) {
    when (viewState) {
        is PoetsViewState.Failed -> PoetsFailedLayout(viewState.message) { onEvent(PoetsViewEvent.Retry) }
        PoetsViewState.Loading -> PoetsLoadingLayout()
        is PoetsViewState.ShowData -> PoetsDataLayout(items = viewState.items)
    }
}

@Preview
@Composable
private fun PoetsLoadingLayout() {

}