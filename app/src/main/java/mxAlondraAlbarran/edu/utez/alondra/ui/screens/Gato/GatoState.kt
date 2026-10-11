package mxAlondraAlbarran.edu.utez.alondra.ui.screens.Gato

data class GatoState(
    val tablero: List<String> = List(9) { "" },
    val turnoActual: String = "X",
    val ganador: String? = null,
    val juegoTerminado: Boolean = false
)
