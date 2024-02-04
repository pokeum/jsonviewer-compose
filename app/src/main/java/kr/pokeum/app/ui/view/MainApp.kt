package kr.pokeum.app.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.pokeum.app.ui.view.screen.JsonViewerScreen
import kr.pokeum.app.ui.view.screen.MainScreen

@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    // Navigation Predefined Actions
    val onNavigationButtonClicked: (String) -> Unit = { navController.navigate(it) }
    val navigateBack: () -> Unit = { navController.popBackStack() }

    NavHost(
        navController = navController,
        startDestination = Screen.Main.name,
        modifier = Modifier
    ) {
        composable(route = Screen.Main.name) {
            MainScreen(
                onNavigationButtonClicked = onNavigationButtonClicked
            )
        }
        composable(route = Screen.JsonViewer.name) { JsonViewerScreen() }
    }
}