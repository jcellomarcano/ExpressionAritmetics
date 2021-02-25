class PreOrderFormat {

    private val operatorList = arrayListOf("*","/","+","-")

    fun extractFromPreOrder(expression: ArrayList<String>): String{

        when {
            (expression[0] !in operatorList) && expression.size == 1 -> {
                return expression[0]
            }
            expression.size == 3 -> {
                return Node(expression[0],expression[1],expression[2]).toString()
            }
            else -> {
                loop@ for (i in 1 .. expression.size - 2){
                    when {
                        expression[i] in operatorList -> {
                            var hasOper = false
                            loop1@ for (j in i .. expression.size + 1){
                                when {
                                    expression[j] in operatorList -> {
                                        hasOper = true
                                        break@loop1
                                    }
                                }
                            }
                            when {
                                (i+3 < expression.size) && (expression[i+3] !in operatorList) && !(i-2 > 0 &&  expression[i-2] !in operatorList) && !hasOper -> {
                                    continue@loop
                                }
                                else -> {
                                    if (expression[i + 1] !in operatorList && expression.size == i+2){
                                        val aux = expression[i]
                                        expression[i]=Node(aux, expression[i+1], "").toString()
                                        println(expression[i])
                                        expression.removeAt(i+1)
                                        break
                                    }
                                    else if (expression[i + 1] !in operatorList && expression[i+2] !in operatorList) {
                                        val aux = expression[i]
                                        expression[i]=Node(aux, expression[i+1], expression[i+2]).toString()
//                                        println(expression[i])
                                        expression.removeAt(i+1)
                                        expression.removeAt(i+1)
                                        break
                                    }

                                }
                            }
                        }
                    }
                }
                return extractFromPreOrder(expression)
            }
        }

    }
}