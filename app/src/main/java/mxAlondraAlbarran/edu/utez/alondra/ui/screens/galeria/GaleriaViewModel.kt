package mxAlondraAlbarran.edu.utez.alondra.ui.screens.galeria

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.edu.utez.alondra.R

class GaleriaViewModel : ViewModel() {

    // Lista de imágenes
    val images = listOf(
        R.drawable.emma,
        R.drawable.emma2,
        R.drawable.emma3
    )

    // Estado del índice actual
    var currentIndex by mutableIntStateOf(0)
        private set

    // Función para ir a la siguiente imagen
    fun onNextImage() {
        if (currentIndex < images.size - 1) {
            currentIndex++
        } else {
            currentIndex = 0 // Regresa al inicio
        }
    }

    // Función para ir a la imagen anterior
    fun onPreviousImage() {
        if (currentIndex > 0) {
            currentIndex--
        } else {
            currentIndex = images.size - 1 // Va a la última
        }
    }
}