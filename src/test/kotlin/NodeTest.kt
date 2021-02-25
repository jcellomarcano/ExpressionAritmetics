import org.junit.Test
import kotlin.test.assertEquals

class NodeTest {


    @Test
    fun nullNode() {
        val node: String = Node("","","").toString()
        val result = "()"
        assertEquals(result, node)


    }

    @Test
    fun uniquePreNode(){
        val node: String = Node("%","5","6").toString()
        val result = "(5 % 6)"
        assertEquals(result, node)
    }

}