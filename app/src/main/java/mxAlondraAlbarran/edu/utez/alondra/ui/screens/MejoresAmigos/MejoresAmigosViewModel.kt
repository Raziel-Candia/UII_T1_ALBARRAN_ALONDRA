package mxAlondraAlbarran.edu.utez.alondra.ui.screens.MejoresAmigos

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.map

//es posible definir una clase de datos
data class MejoresAmigos(
    val id: Int,
    val nombreCompleto: String,
    val edad: Int,
    val fechaNacimiento: String,
    val esMejorAmigo: Boolean = false
)

class MejoresAmigosViewModel: ViewModel() {
    //Codigo de logica
    //Estado Interno
    private val _elementos = MutableStateFlow<List<MejoresAmigos>>(emptyList())
    //estado publico
    val elementos: StateFlow<List<MejoresAmigos>> = _elementos.asStateFlow()

    init{
        val MejorAmigo1 = MejoresAmigos(1,"Alan", 18, "05/11/2007",true)
        val MejorAmigo2 = MejoresAmigos(2,"Jairo", 19, "14/03/2007",true)
        val MejorAmigo3 = MejoresAmigos(3,"Yara", 20, "03/11/2006",true)
            _elementos.value = listOf(MejorAmigo1,MejorAmigo2,MejorAmigo3)
    }

    fun actualizarFavorito(id: Int){
        _elementos.update { listaActual ->
            listaActual.map { item ->
                if (item.id == id){
                    item.copy(esMejorAmigo = !item.esMejorAmigo)
                } else {
                    item
                }
            }
        }
    }

}