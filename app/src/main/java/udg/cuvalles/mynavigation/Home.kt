
package udg.cuvalles.mynavigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    productos: List<Triple<String, String, String>>,
    onNavigationProfile: () -> Unit
) {
    var buscar by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App Reg") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigationProfile
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Buscar")

            OutlinedTextField(
                value = buscar,
                onValueChange = { buscar = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Lista de productos")

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(
                    productos.filter {
                        it.second.contains(buscar, ignoreCase = true)
                    }
                ) { producto ->

                    Text("ID: ${producto.first}")
                    Text("Nombre: ${producto.second}")
                    Text("Precio: $${producto.third}")

                    HorizontalDivider()

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
