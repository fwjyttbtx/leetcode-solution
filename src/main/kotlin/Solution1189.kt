import kotlinx.coroutines.experimental.launch
import java.util.*
import kotlin.system.measureTimeMillis

object Solution1189 {
    /** 比较丑陋 */
    fun maxNumberOfBalloons(text: String): Int {
        val charCounts = mutableMapOf(
            Pair('a', 0),
            Pair('b', 0),
            Pair('l', 0),
            Pair('n', 0),
            Pair('o', 0)
        )
        var switcho = false
        var switchl = false
        text.forEach { ch ->
            charCounts.computeIfPresent(ch) { _, oldVal ->
                return@computeIfPresent when (ch) {
                    'l' -> {
                        if (switchl) {
                            switchl = false
                            oldVal.inc()
                        } else {
                            switchl = true
                            oldVal
                        }
                    }
                    'o' -> {
                        if (switcho) {
                            switcho = false
                            oldVal.inc()
                        } else {
                            switcho = true
                            oldVal
                        }
                    }
                    else -> oldVal.inc()
                }
            }
        }
        return charCounts.values.min() ?: 0
    }

    /** 更灵活 */
    fun maxNumberOfBalloons2(text: String): Int {
        val charCounts = mutableMapOf(
            Pair('a', 0),
            Pair('b', 0),
            Pair('l', 0),
            Pair('n', 0),
            Pair('o', 0)
        )
        text.forEach { ch ->
            charCounts.computeIfPresent(ch) { _, oldVal -> oldVal.inc() }
        }
        return charCounts.mapValues { me ->
            if (me.key == 'l' || me.key == 'o') me.value.div(2)
            else me.value
        }.values.min() ?: 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        repeat(50) { time ->
            val randomCharacters = mutableListOf<Char>()
            val letters = (97..122).map { it.toChar() }
            repeat(10000) {
                randomCharacters.add(letters[Random().nextInt(26)])
            }
            launch {
                println(" ${measureTimeMillis { print("f2[$time] -> ${maxNumberOfBalloons2(randomCharacters.joinToString())}") }}ms")
            }
            launch {
                println(" ${measureTimeMillis { print("f1[$time] -> ${maxNumberOfBalloons(randomCharacters.joinToString())}") }}ms")
            }
        }
    }
}