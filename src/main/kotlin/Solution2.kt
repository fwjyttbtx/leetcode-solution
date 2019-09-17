/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution2 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val topNode = ListNode(0)
        var l1Next = l1
        var l2Next = l2
        var curr: ListNode? = topNode
        var carry = 0
        while(l1Next != null || l2Next != null) {
            val l1Val = l1Next?.`val` ?: 0
            val l2Val = l2Next?.`val` ?: 0
            val sum = l1Val.plus(l2Val).plus(carry)
            carry = sum.div(10)
            curr?.next = ListNode(sum.rem(10))
            curr = curr?.next
            l1Next?.let { l1n -> l1Next = l1n.next }
            l2Next?.let { l2n -> l2Next = l2n.next }
        }
        if (carry > 0) {
            curr?.next = ListNode(carry)
        }
        return topNode.next
    }
}