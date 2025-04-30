package kb.ehsan.barook.presentation.component.item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kb.ehsan.barook.ui.theme.BarookTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun ItemComponent(
    data: ItemUiModel
) = Card(
    modifier = Modifier.fillMaxWidth()
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = data.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .aspectRatio(1f)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            // shows an image with a circular revealed animation.
            transition = CrossFade
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            text = data.name
        )
    }
}

@Preview
@Composable
private fun ItemComponentPreview() {
    BarookTheme {
        ItemComponent(ItemUiModel("name", "image url"))
    }
}