package mxAlondraAlbarran.edu.utez.alondra.ui.screens.MejoresAmigos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemTarjeta(
    item: MejoresAmigos,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                // 1. Nombre completo
                Text(
                    text = item.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium
                )
                // 2. Edad
                Text(
                    text = "Edad: ${item.edad} años",
                    style = MaterialTheme.typography.bodyMedium
                )
                // 3. Fecha de nacimiento
                Text(
                    text = "Fecha de nac.: ${item.fechaNacimiento}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // 4. Indicador de mejor amigo (Corazón)
            Icon(
                imageVector = if (item.esMejorAmigo) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (item.esMejorAmigo) "Es mejor amigo" else "No es mejor amigo",
                tint = if (item.esMejorAmigo) Color.Red else Color.Gray,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}