
package udg.cuvalles.mynavigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data object ProfileRoute

@Serializable
data class ProductoRoute(
    val id: String,
    val nombre: String,
    val precio: String
)
