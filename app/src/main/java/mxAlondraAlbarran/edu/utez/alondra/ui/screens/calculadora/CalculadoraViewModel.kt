package mx.edu.utez.alondra.ui.screens.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel : ViewModel() {

    var displayText by mutableStateOf("")
        private set

    private var firstNumber: Double? = null
    private var pendingOperation: String? = null
    private var isNewInput = false

    fun onNumberClick(digit: String) {
        if (isNewInput) {
            displayText = digit
            isNewInput = false
        } else {
            displayText += digit
        }
    }

    fun onDotClick() {
        if (isNewInput) {
            displayText = "0."
            isNewInput = false
        } else if (!displayText.contains(".")) {
            displayText = if (displayText.isEmpty()) "0." else "$displayText."
        }
    }

    fun onOperationClick(op: String) {
        val currentVal = displayText.toDoubleOrNull()
        if (currentVal != null) {
            firstNumber = currentVal
            pendingOperation = op
            isNewInput = true
        }
    }

    fun onEqualsClick() {
        val secondVal = displayText.toDoubleOrNull()
        val firstVal = firstNumber

        if (firstVal != null && secondVal != null && pendingOperation != null) {
            val result = when (pendingOperation) {
                "+" -> firstVal + secondVal
                "-" -> firstVal - secondVal
                "*" -> firstVal * secondVal
                "/" -> if (secondVal != 0.0) firstVal / secondVal else Double.NaN
                else -> 0.0
            }

            displayText = if (result.isNaN()) {
                "Error"
            } else if (result % 1.0 == 0.0) {
                result.toLong().toString()
            } else {
                result.toString()
            }

            firstNumber = null
            pendingOperation = null
            isNewInput = true
        }
    }
}