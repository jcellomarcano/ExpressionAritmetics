import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PreOrderFormatTest {
    private val preOrder = PreOrderFormat()

    @Test
    fun validatePreOrderSingle() {
        val firstTest = arrayListOf("9")
        val result = "9"
        assertEquals(result,preOrder.extractFromPreOrder(firstTest))
    }

    @Test
    fun uniqueOperator(){
        val secondTest = arrayListOf("+","9","8")
        val result = "(9 + 8)"
        assertEquals((result), preOrder.extractFromPreOrder(secondTest))
    }

    @Test
    fun completeExpression(){
        val testExpression = arrayListOf("+", "*", "+", "3", "4", "5", "7")
        val result = "(((3 + 4) * 5) + 7)"
        assertEquals((result), preOrder.extractFromPreOrder(testExpression))
    }

    @Test
    fun continuesNumberExpression(){
        val testExpression = arrayListOf("+","+","2","+","3","4","5")
        val result = "((2 + (3 + 4)) + 5)"
        assertEquals((result), preOrder.extractFromPreOrder(testExpression))
    }
    @Test
    fun mixedNumberExpression(){
        val testExpression = arrayListOf("+","2","+","3","+","4","5")
        val result = "(2 + (3 + (4 + 5)))"
        assertEquals((result), preOrder.extractFromPreOrder(testExpression))
    }


}