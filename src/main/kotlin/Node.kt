class Node(
    var value: String,
    var left: String,
    var right: String,

    ) {
    override fun toString(): String {
        return when {
            right == "" && left == "" && value == "" -> {
                "($left$value$right)"
            }
            else -> {
                "($left $value $right)"
            }
        }

    }
}