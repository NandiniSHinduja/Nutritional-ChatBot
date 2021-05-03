package com.example.nutribot.utils

import com.example.nutribot.utils.Constants.OPEN_GOOGLE
import com.example.nutribot.utils.Constants.OPEN_SEARCH
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {
    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }
            message.contains("calculate") && message.contains("bmi")-> {
                when (random) {
                    0 -> "Please enter your weight and height seperated by a comma"
                    1 -> "Enter your weight, height"
                    2 -> "Sure, enter your weight, height!"
                    else -> "error"
                }
            }
            //Math calculations
            message.contains("calculate") -> {
                val equation: String? = message.substringAfterLast("calculate")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "Your BMI is $answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }
            message.contains("how") && message.contains("calories")-> {
                when (random) {
                    0 -> "What is your gender?"
                    1 -> "Enter your gender"
                    2 -> "Which gender do you identify with?"
                    else -> "error"
                }
            }
            message.contains("female") -> {
                when (random) {
                    0 -> "Do you want to reduce, maintain or increase your weight?"
                    1 -> "Would you like to be skinny, bulky or maintain your current weight?"
                    2 -> "Do you prefer gaining, maintaining, or losing your weight?"
                    else -> "error"
                }
            }
            message.contains("male") -> {
                when (random) {
                    0 -> "Do you want to decrease, maintain or increase your weight?"
                    1 -> "Would you like to be skinny, bulky or maintain your current weight?"
                    2 -> "Do you prefer gaining, maintaining, or losing your weight?"
                    else -> "error"
                }
            }
            message.contains("maintain") -> {
                when (random) {
                    0 -> "You should have 1600 calories to maintain your weight."
                    1 -> "To maintain your weight, consume 1600 calories."
                    2 -> "In order to maintain your current weight, consume 1600 calories."
                    else -> "error"
                }
            }
            message.contains("maintaining") -> {
                when (random) {
                    0 -> "You should have 1600 calories to maintain your weight."
                    1 -> "To maintain your weight, consume 1600 calories."
                    2 -> "In order to maintain your current weight, consume 1600 calories."
                    else -> "error"
                }
            }
            message.contains("skinny") -> {
                when (random) {
                    0 -> "To reduce your weight, eat 1200 calories per day."
                    1 -> "Eat 1200 calories to reduce your weight."
                    2 -> "In order to decrease your weight, consume 1200 calories."
                    else -> "error"
                }
            }
            message.contains("losing") -> {
                when (random) {
                    0 -> "To reduce your weight, eat 1200 calories per day."
                    1 -> "Eat 1200 calories to reduce your weight."
                    2 -> "In order to decrease your weight, consume 1200 calories."
                    else -> "error"
                }
            }
            message.contains("bulky") -> {
                when (random) {
                    0 -> "Consume 2000 calories to increase your weight."
                    1 -> "In order to increase your weight, eat 2000 calories."
                    2 -> "Eat 2000 calories to increase your weight."
                    else -> "error"
                }
            }
            message.contains("gaining") -> {
                when (random) {
                    0 -> "Consume 2000 calories to increase your weight."
                    1 -> "In order to increase your weight, eat 2000 calories."
                    2 -> "Eat 2000 calories to increase your weight."
                    else -> "error"
                }
            }
            message.contains("increase") -> {
                when (random) {
                    0 -> "Consume 2000 calories to increase your weight."
                    1 -> "In order to increase your weight, eat 2000 calories."
                    2 -> "Eat 2000 calories to increase your weight."
                    else -> "error"
                }
            }
            message.contains("decrease") -> {
                when (random) {
                    0 -> "To reduce your weight, eat 1200 calories per day."
                    1 -> "Eat 1200 calories to reduce your weight."
                    2 -> "In order to decrease your weight, consume 1200 calories."
                    else -> "error"
                }
            }
            message.contains("reduce") -> {
                when (random) {
                    0 -> "To reduce your weight, eat 1200 calories per day."
                    1 -> "Eat 1200 calories to reduce your weight."
                    2 -> "In order to decrease your weight, consume 1200 calories."
                    else -> "error"
                }
            }
            message.contains("how")&& message.contains("much")&& message.contains("water") -> {
                when (random) {
                    0 -> "Drink 1600ml per day."
                    1 -> "Drink 8 glasses of water per day."
                    2 -> "Drink 1.6 litres of water per day."
                    else -> "error"
                }
            }
            message.contains("diet")&& message.contains("plan") -> {
                when (random) {
                    0 -> "Enter the country in which you live"
                    1 -> "What country do you live in?"
                    2 -> "Enter your nationality"
                    else -> "error"
                }
            }
            message.contains("india") -> {
                when (random) {
                    0 -> "Which state of India do you reside in?"
                    1 -> "in what region of India are you currently residing in?"
                    2 -> "Which state of India do you live in?"
                    else -> "error"
                }
            }
            message.contains("indian") -> {
                when (random) {
                    0 -> "Which state of India do you reside in?"
                    1 -> "in what region of India are you currently residing in?"
                    2 -> "Which state of India do you live in?"
                    else -> "error"
                }
            }
            message.contains("tamil") -> {
                when (random) {
                    0 -> "Well, in that case, this should be your diet plan- Breakfast: 4 idlis/2 dosas along with sambar, Lunch: a bowl of rice or 2 chappathis with vegetables, Dinner: fruit salad, soup and grilled chicken."
                    1 -> "Your diet plan is-Breakfast: 4 idlis/2 dosas along with sambar, Lunch: a bowl of rice or 2 chappathis with vegetables, Dinner: fruit salad, soup and grilled chicken. "
                    2 -> "Your customized diet plan includes-Breakfast: 4 idlis/2 dosas along with sambar, Lunch: a bowl of rice or 2 chappathis with vegetables, Dinner: fruit salad, soup and grilled chicken. "
                    else -> "error"
                }
            }

            //Hello
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}
