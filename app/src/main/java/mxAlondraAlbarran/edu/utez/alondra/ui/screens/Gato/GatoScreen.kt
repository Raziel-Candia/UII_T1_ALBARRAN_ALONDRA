package mxAlondraAlbarran.edu.utez.alondra.ui.screens.Gato

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GatoScreen(
    onBackClick: () -> Unit,
    viewModel: GatoViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Juego del Gato") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Estado del turno o ganador
            Text(
                text = state.ganador ?: "Turno de: ${state.turnoActual}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = if (state.ganador != null) MaterialTheme.colorScheme.primary else Color.Unspecified
            )

            // Tablero 3x3 de casillas
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color.DarkGray, RoundedCornerShape(12.dp))
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (row in 0..2) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        for (col in 0..2) {
                            val index = row * 3 + col
                            val simbolo = state.tablero[index]

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(
                                        color = MaterialTheme.colorScheme.surfaceVariant,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable { viewModel.onCasillaSeleccionada(index) },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = simbolo,
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = when (simbolo) {
                                        "X" -> Color.Blue
                                        "O" -> Color.Red
                                        else -> Color.Transparent
                                    }
                                )
                            }
                        }
                    }
                }
            }

            // Botón para reiniciar
            Button(
                onClick = { viewModel.reiniciarJuego() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Reiniciar Juego", fontSize = 18.sp)
            }
        }
    }
}
