package mxAlondraAlbarran.edu.utez.alondra.ui.screens.Gato

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GatoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GatoState())
    val uiState: StateFlow<GatoState> = _uiState.asStateFlow()

    private val jugadasGanadoras = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
        listOf(0, 4, 8), listOf(2, 4, 6)
    )

    fun onCasillaSeleccionada(index: Int) {
        val estActual = _uiState.value

        if (estActual.tablero[index].isNotEmpty() || estActual.juegoTerminado) {
            return
        }

        val nuevoTablero = estActual.tablero.toMutableList()
        nuevoTablero[index] = estActual.turnoActual

        val ganador = verificarGanador(nuevoTablero)
        val empate = ganador == null && nuevoTablero.none { it.isEmpty() }
        val terminado = ganador != null || empate

        _uiState.update { estado ->
            estado.copy(
                tablero = nuevoTablero,
                turnoActual = if (estado.turnoActual == "X") "O" else "X",
                ganador = when {
                    ganador != null -> "¡Ganó $ganador!"
                    empate -> "Es un empate"
                    else -> null
                },
                juegoTerminado = terminado
            )
        }
    }

    private fun verificarGanador(tablero: List<String>): String? {
        for (combo in jugadasGanadoras) {
            val (a, b, c) = combo
            if (tablero[a].isNotEmpty() && tablero[a] == tablero[b] && tablero[a] == tablero[c]) {
                return tablero[a]
            }
        }
        return null
    }

    fun reiniciarJuego() {
        _uiState.value = GatoState()
    }
}
