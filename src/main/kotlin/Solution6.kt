object Solution6 {

//    fun convert(s: String, numRows: Int): String {
//        if (s.length < numRows) return s
//        val sLen = s.length
//        // 计算一个z字的7字形需要的字符数量
//        val zpart = numRows * 2 - 2
//        val midLen = numRows - 2
//        // 计算二维数组的列长度 如果超出默认构造一个稍大的数组
//        val cols = if (numRows == 1) sLen else Math.ceil(sLen.div(zpart.toDouble())).toInt().times(numRows.minus(1))
//
//        // 构造一个二维数组
//        val arr = Array(numRows) {CharArray(cols) { ' ' } }
//        // 字符串重排 按照z字形状 添加空格
//        val schs = s.toCharArray().toMutableList()
//        val newChs = mutableListOf<Char>()
//        kotlin.run constructLoop@ {
//            while(schs.isNotEmpty()) {
//                repeat(numRows) {
//                    if (schs.isEmpty()) return@constructLoop
//                    newChs.add(schs.removeAt(0))
//                }
//                repeat(midLen) {
//                    if (schs.isEmpty()) return@constructLoop
//                    repeat(midLen) { newChs.add(' ') }
//                    newChs.add(schs.removeAt(0))
//                }
//                repeat(midLen) { newChs.add(' ') }
//            }
//        }
//        newChs.forEachIndexed { i, ch ->
//            val r = i.rem(numRows)
//            val c = i.div(numRows)
//            arr[r][c] = ch
//        }
//        var target = ""
//        arr.forEach { a ->
//            a.forEach { b ->
//                if (b != ' ') {
//                    target += b
//                }
//            }
//        }
//        return arr.joinToString(separator = "") { it.filter { i -> i != ' ' }.joinToString(separator = "") }
//    }

    fun convert(s: String, row: Int): String {
        if (row == 1) return s
        var step = row * 2 - 2
        val sLen = s.length
        val sz = Array(row) { mutableListOf<Char>() }
        repeat(sLen / step + 1) { g ->
            val baseIdx = step * g
            repeat(row) rowRepeat@ { r ->
                val rBaseIdx = baseIdx + r
                if (rBaseIdx >= sLen) {
                    step -= 2
                    return@rowRepeat
                }
                sz[r].add(s[rBaseIdx])
                if (r != 0 && r != row - 1) {
                    val rBaseIdx2 = rBaseIdx + step
                    if (rBaseIdx2 >= sLen) {
                        step -= 2
                        return@rowRepeat
                    }
                    sz[r].add(s[rBaseIdx2])
                }
                step -= 2
            }
            step = row * 2 - 2
        }
        return sz.joinToString(separator = "") { it.joinToString(separator = "") }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(convert("PAYPALISHIRING", 4))
        println(convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")

        println(convert("PAYPALISHIRING", 3))
        println(convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    }

}
// PINALLIIGYAAIIHPPP
// PINALSIGYAHRPI
//  P    I  N
//  A L  S IG
//  YA   HR
//  P    I

// P A H N
// APLSIIG
// Y I R
