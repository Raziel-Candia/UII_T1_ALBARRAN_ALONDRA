package mxAlondraAlbarran.edu.utez.alondra.ui.screens.MejoresAmigos


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.alondra.ui.theme.ProyectoTheme

// Composable de contenido (Sin que use el view model, ES UI pura)
@Composable
fun ListaContenido(
    elementos: List<MejoresAmigos>,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = elementos,
            key = { item -> item.id }
        ) { item ->
            ItemTarjeta(item = item, onClick = { onItemClick(item.id) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaContenidoPreview() {
    ProyectoTheme {
        // Se agregan las fechas de nacimiento requeridas por el modelo
        val v1 = MejoresAmigos(1, "Alan", 18, "05/11/2007", true)
        val v2 = MejoresAmigos(2, "Jairo", 19, "14/03/2007", true)
        val v3 = MejoresAmigos(3, "Yara", 20, "03/11/2006", true)

        val lista = listOf(v1, v2, v3)
        ListaContenido(elementos = lista, onItemClick = {})
    }
}