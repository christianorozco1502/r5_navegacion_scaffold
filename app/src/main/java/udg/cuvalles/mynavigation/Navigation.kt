
package udg.cuvalles.mynavigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    val productos = remember {
        mutableStateListOf<Triple<String, String, String>>()
    }

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {


        composable<HomeRoute> {
            Home(
                productos = productos,
                onNavigationProfile = {
                    navController.navigate(ProfileRoute)
                }
            )
        }


        composable<ProfileRoute> {
            Profile(
                onRegistrar = { id, nombre, precio ->
                    productos.add(Triple(id, nombre, precio))
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
