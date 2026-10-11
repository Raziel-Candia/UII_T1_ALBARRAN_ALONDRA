package mx.edu.utez.alondra.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utez.alondra.ui.screens.calculadora.CalculadoraScreen
import mx.edu.utez.alondra.ui.screens.conversor.ConversorScreen
import mx.edu.utez.alondra.ui.screens.menu.MenuScreen
import mx.edu.utez.alondra.ui.screens.propinas.PropinasScreen
import mxAlondraAlbarran.edu.utez.alondra.ui.screens.Gato.GatoScreen
import mxAlondraAlbarran.edu.utez.alondra.ui.screens.MejoresAmigos.MejoresAmigosScreen
import mxAlondraAlbarran.edu.utez.alondra.ui.screens.MejoresAmigos.MejoresAmigosViewModel
import mxAlondraAlbarran.edu.utez.alondra.ui.screens.galeria.GaleriaScreen

sealed class Route(val path: String) {
    object Menu : Route("menu")
    object Conversor : Route("conversor")
    object Propinas : Route("propinas")

    object Calculadora : Route("calculadora")

    object Galeria : Route("galeria")

    object MejoresAmigos : Route("Mejores Amigos")

    object JuegoGato : Route("juego Gato ")

}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Menu.path,
        modifier = modifier
    ) {
        // 1. Pantalla Menú Principal
        composable(Route.Menu.path) {
            MenuScreen(
                onNavigateToConversor = { navController.navigate(Route.Conversor.path) },
                onNavigateToPropinas = { navController.navigate(Route.Propinas.path) },
                onNavigateToCalculadora = { navController.navigate(Route.Calculadora.path) },
                onNavigateToGaleria = { navController.navigate(Route.Galeria.path) },
                onNavigateToMejoresAmigos = { navController.navigate(Route.MejoresAmigos.path) },
                onNavigateToJuegoGato = { navController.navigate(Route.JuegoGato.path) }


            )
        }

        // 2. Pantalla Conversor de Divisas
        composable(Route.Conversor.path) {
            ConversorScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Pantalla Calculadora de Propinas
        composable(Route.Propinas.path) {
            PropinasScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        //Calculadora
        composable(Route.Calculadora.path) {
            CalculadoraScreen(
                onBackClick = { navController.popBackStack() },
                )
        }
        //Pantalla Galería
        composable(Route.Galeria.path) {
            GaleriaScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Route.MejoresAmigos.path) {
            MejoresAmigosScreen(
                MejoresAmigosViewModel()
            )
        }
        composable(Route.JuegoGato.path) {
            GatoScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}