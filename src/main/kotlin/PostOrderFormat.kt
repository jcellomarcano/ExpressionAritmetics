class PostOrderFormat {

    private val operatorList = arrayListOf("*","/","+","-")
    fun extractFromPostOrder(expression: ArrayList<String>): String{
        when {
            expression[0] !in operatorList && expression.size == 1 -> {
                return expression[0]
            }
            expression.size == 3 -> {
                return Node(expression[2],expression[0],expression[1]).toString()
            }
            else -> {
                loop@ for (i in 0 .. expression.size -2){
                    when {
                        expression[i+2] in operatorList -> {
                            var hasOper = false
                            loop1@ for (j in 0..i+2){
                                when {
                                    expression[j] in operatorList -> {
                                        hasOper = true
                                        break@loop1
                                    }
                                }
                            }
                            when {
                                i-1 > 0 && expression[i-1] !in operatorList && !(i>0 && expression[i] in operatorList)&& !hasOper -> {
                                    continue@loop
                                }
                                else -> {
                                    if( expression[i] !in operatorList && expression[i+1] !in operatorList){
                                        var aux = expression[i]
                                        expression[i] = Node(expression[i+2], aux, expression[i+1]).toString()
                                        expression.removeAt(i+1)
                                        expression.removeAt(i+1)
                                        break@loop
                                    }
                                }
                            }
                        }
                    }
                }
                return extractFromPostOrder(expression)
            }
        }
    }
}