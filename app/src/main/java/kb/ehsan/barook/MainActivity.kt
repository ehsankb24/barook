package kb.ehsan.barook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kb.ehsan.barook.presentation.PoetsRout
import kb.ehsan.barook.presentation.PoetsScreen
import kb.ehsan.barook.ui.theme.BarookTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarookTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
                    MainLayout()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainLayout() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    modifier = Modifier,
                    title = {
                        Text(text = "")
                    }
                )
            }
        ) { innerPadding ->
            val navController = rememberNavController()
            NavHost(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                navController = navController,
                startDestination = PoetsRout
            ) {
                composable<PoetsRout> {
                    PoetsScreen()
                }
            }
        }
    }
}