import org.junit.Test
import kotlin.test.assertEquals

class MainTest {

    @Test
    fun goodCommand() {
        val expression: String = "MOSTRAR"
        val result = true
        assertEquals(result, checkCommand(expression))
    }

    @Test
    fun badCommand() {
        val expression: String = "MOSTeeRAR"
        val result = false
        assertEquals(result, checkCommand(expression))
    }
    @Test
    fun badType() {
        val expression: String = "EVaR"
        val result = false
        assertEquals(result, checkTypeFormat(expression))
    }
    @Test
    fun goodType() {
        val expression: String = "PRE"
        val result = true
        assertEquals(result, checkTypeFormat(expression))
    }

    @Test
    private fun badExpression() {
        val expression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = false
        assertEquals(result, checkExpresion(expression, "PRE"))
    }
    @Test
    private fun goodExpression() {
        val expression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = true
        assertEquals(result, checkExpresion(expression, "POST"))
    }
    @Test
    fun goodExpressionFormatted() {
        val expression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = "(7 + (5 * (4 + 3)))"
        assertEquals(result, reformatExpresion("POST", expression))
    }
    @Test
    fun badExpressionFormatted() {
        val expression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = ""
        assertEquals(result, reformatExpresion("PRE", expression))
    }
    @Test
    fun badOrderTypeExpressionFormatted() {
        val expression = arrayListOf("7" ,"5" ,"4" ,"3" ,"+" ,"*" ,"+")
        val result = ""
        assertEquals(result, reformatExpresion("PR", expression))
    }
    @Test
    fun goodEvaluation() {
        val expression = "(((3 + 4) * 5) + 7)"
        val result = 42
        assertEquals(result, eval(expression))
    }
    @Test
    fun badEvaluation() {
        val expression = "(((3 + 4) ## 5) + 7)"
        val result: Double = Double.NaN
        assertEquals(result, eval(expression))
    }


}