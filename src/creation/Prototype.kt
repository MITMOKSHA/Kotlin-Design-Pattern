package creation

data class Person(
    val name: String,
    val hobbies: MutableList<String>,
): Cloneable {

    override fun clone(): Person {
        return super.clone() as Person
    }

    fun deepCopy(): Person {
        return Person(
            name = this.name,
            hobbies = ArrayList(this.hobbies)
        )
    }
}

fun main() {
    val p = Person("Dmitry", mutableListOf("读书，跑步"))
    // copy方法是kt data class自动生成的函数，默认是浅拷贝；clone方法也是浅拷贝
    println("====深拷贝====")

    val dcp = p.deepCopy()
    dcp.hobbies.add("下棋")
    println(p.hobbies)
    println(dcp.hobbies)

    println("====浅拷贝====")

    // copy之后的引用类型字段还是指向同一个地址
    val cp = p.copy()
    cp.hobbies.add("游泳")
    println(p.hobbies)
    println(cp.hobbies)
}