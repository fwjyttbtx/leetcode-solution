
object Solution7 {
    fun reverse(x: Int): Int {
        var mx = x
        var target = 0
        var digit = 1
        while(mx != 0) {
//            if (digit == 10 && mx < 10 && (
//                    target > 214748364 || target < -214748364 ||
//                        (mx > 7 && target == 214748364) ||
//                        (mx < -8 && target == -214748364)
//            )) {
//                // 判断target是否是一直大于Int上限或小于Int下限的相同位数值
//                return 0
//            }
            val test = target
            target = target * 10 + mx % 10
            if (digit == 10 && target / 10 != test) return 0
            mx /= 10
            digit++
        }
        return target
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(reverse(1534236469))
    }

}