
package udg.cuvalles.mynavigation

import androidx.compose.runtime.*
import androidx.navigation.toRoute
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
                    navController.navigate(
                        ProductoRoute(id, nombre, precio)
                    ) {
                        popUpTo<HomeRoute>()
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<ProductoRoute> { backStackEntry ->

            val args = backStackEntry.toRoute<ProductoRoute>()

            LaunchedEffect(backStackEntry) {
                productos.add(
                    Triple(args.id, args.nombre, args.precio)
                )
            }

            Home(
                productos = productos,
                onNavigationProfile = {
                    navController.navigate(ProfileRoute)
                }
            )
        }
    }
}
