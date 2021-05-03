package com.example.nutribot.utils

import android.util.Log

object SolveMath {
    fun solveMath(equation: String) : Double {

        val newEquation = equation.replace(" ", "")
        Log.d("Math", newEquation)

        return when {
            newEquation.contains(",") -> {
                val split = newEquation.split(",")
                val result = split[0].toDouble() / ((split[1].toDouble()*split[1].toDouble())/10000)
                result
            }
            else -> {
                100.0
            }
        }
    }
}
