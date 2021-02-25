import org.junit.Test
import kotlin.test.assertEquals

class PostOrderFormatValidate {
    private val postOrder = PostOrderFormat()
    @Test
    fun validatePreOrderSingle() {
        val firstTest = arrayListOf("9")
        val result = "9"
        assertEquals(result, postOrder.extractFromPostOrder(firstTest))
    }

    @Test
    fun uniqueOperator(){
        val secondTest = arrayListOf("8","9","+")
        val result = "(8 + 9)"
        assertEquals((result), postOrder.extractFromPostOrder(secondTest))
    }

    @Test
    fun completeExpression(){
        val testExpression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = "(7 + (5 * (4 + 3)))"
        assertEquals((result), postOrder.extractFromPostOrder(testExpression))
    }

    @Test
    fun continuesNumberExpression(){
        val testExpression = arrayListOf("5","4","3","+","2","+","+")
        val result = "(5 + ((4 + 3) + 2))"
        assertEquals((result), postOrder.extractFromPostOrder(testExpression))
    }
    @Test
    fun mixedNumberExpression(){
        val testExpression = arrayListOf("5","4","+","3","+","2","+")
        val result = "(((5 + 4) + 3) + 2)"
        assertEquals((result), postOrder.extractFromPostOrder(testExpression))
    }
    @Test
    fun exampleExamNumberExpression(){
        val testExpression = arrayListOf("8", "3", "-", "8", "4", "4", "+", "*", "+")
        val result = "((8 - 3) + (8 * (4 + 4)))"
        assertEquals((result), postOrder.extractFromPostOrder(testExpression))
    }
}