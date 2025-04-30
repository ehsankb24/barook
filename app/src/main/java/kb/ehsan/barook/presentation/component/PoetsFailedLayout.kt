package kb.ehsan.barook.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kb.ehsan.barook.R
import kb.ehsan.barook.ui.theme.BarookTheme

@Composable
internal fun PoetsFailedLayout(
    message: String,
    onRetry: () -> Unit
) = Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Text(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        text = message,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.error
    )
    Button(onClick = onRetry) {
        Text(stringResource(R.string.retry))
    }
}

@Preview
@Composable
private fun ListFailedLayoutPreview() {
    BarookTheme {
        PoetsFailedLayout("error message") { }
    }
}