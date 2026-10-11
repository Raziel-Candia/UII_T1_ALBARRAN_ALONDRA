package mx.edu.utez.alondra.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.edu.utez.alondra.R

@Composable
fun MenuScreen(
    onNavigateToConversor: () -> Unit,
    onNavigateToPropinas: () -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToCalculadora: () -> Unit,
    onNavigateToGaleria: () -> Unit,
    onNavigateToMejoresAmigos: () -> Unit,
    onNavigateToJuegoGato: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.tools), // Reemplazar con tu imagen (ej. R.drawable.logo_herramientas)
            contentDescription = "Logo de Herramientas",
            contentScale = ContentScale.Crop, // Escala y recorta para llenar la forma
            modifier = Modifier
                .size(120.dp)                 // Tamaño de la imagen
                .clip(CircleShape)            // Recorte en forma de círculo
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Mis Herramientas",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Botón hacia Conversor
        Button(
            onClick = onNavigateToConversor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Conversor de Divisas")
        }

        // Botón hacia Propinas
        Button(
            onClick = onNavigateToPropinas,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Calculadora de Propinas")
        }
        //calculadora
        Button(
            onClick = onNavigateToCalculadora,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Calculadora")
        }
        //galeria de fotos de mi hija
        Button(
            onClick = onNavigateToGaleria,
            modifier = Modifier
                .fillMaxWidth()
                .padding( vertical = 8.dp)
        ) {
            Text("Galeria")
        }
        //Boton para mejores amigos
        Button(
            onClick = onNavigateToMejoresAmigos,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Mis mejores amigos")
        }
        //boton para jugar gato
        Button(
            onClick = onNavigateToJuegoGato,
            modifier = Modifier
                .fillMaxWidth()
                .padding( vertical = 8.dp)
        ) {
            Text("Juego Gato")
        }

    }
}
