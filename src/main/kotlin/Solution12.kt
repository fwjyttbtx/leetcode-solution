object Solution12 {

    fun intToRoman(num: Int): String {
        var remain = num
        var ret = ""
        val symbols = Array(4){CharArray(3)}
        symbols[0] = charArrayOf('I','V','X')
        symbols[1] = charArrayOf('X','L','C')
        symbols[2] = charArrayOf('C','D','M')
        symbols[3] = charArrayOf('M')
        var level = 0
        while(remain > 0) {
            val reset = remain % 10
            when (reset) {
                1 -> ret = "${symbols[level][0]}$ret"
                2 -> ret = "${symbols[level][0]}${symbols[level][0]}$ret"
                3 -> ret = "${symbols[level][0]}${symbols[level][0]}${symbols[level][0]}$ret"
                4 -> ret = "${symbols[level][0]}${symbols[level][1]}$ret"
                5 -> ret = "${symbols[level][1]}$ret"
                6 -> ret = "${symbols[level][1]}${symbols[level][0]}$ret"
                7 -> ret = "${symbols[level][1]}${symbols[level][0]}${symbols[level][0]}$ret"
                8 -> ret = "${symbols[level][1]}${symbols[level][0]}${symbols[level][0]}${symbols[level][0]}$ret"
                9 -> ret = "${symbols[level][0]}${symbols[level][2]}$ret"
            }
            remain /= 10
            level++
        }
        return ret
    }

    fun intToRoman2(num: Int): String {
        var remain = num
        var target = ""
        repeat(times = remain / 1000) { target += "M" }
        remain %= 1000
        if (remain == 0) return target
        repeat(times = remain / 900) { target += "CM" }
        remain %= 900
        if (remain == 0) return target
        repeat(times = remain / 500) { target += "D" }
        remain %= 500
        if (remain == 0) return target
        repeat(times = remain / 400) { target += "CD" }
        remain %= 400
        if (remain == 0) return target
        repeat(times = remain / 100) { target += "C" }
        remain %= 100
        if (remain == 0) return target
        repeat(times = remain / 90) { target += "XC" }
        remain %= 90
        if (remain == 0) return target
        repeat(times = remain / 50) { target += "L" }
        remain %= 50
        if (remain == 0) return target
        repeat(times = remain / 40) { target += "XL" }
        remain %= 40
        if (remain == 0) return target
        repeat(times = remain / 10) { target += "X" }
        remain %= 10
        if (remain == 0) return target
        repeat(times = remain / 9) { target += "IX" }
        remain %= 9
        if (remain == 0) return target
        repeat(times = remain / 5) { target += "V" }
        remain %= 5
        if (remain == 0) return target
        repeat(times = remain / 4) { target += "IV" }
        remain %= 4
        if (remain == 0) return target
        repeat(times = remain) { target += "I" }
        return target
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(intToRoman(101))
    }

}