package kb.ehsan.barook.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kb.ehsan.barook.ui.theme.BarookTheme

@Composable
internal fun PoetsLoadingLayout() = Box(modifier = Modifier.fillMaxSize()) {
    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
}

@Preview
@Composable
private fun PoetsLoadingLayoutPreview() {
    BarookTheme {
        PoetsLoadingLayout()
    }
}