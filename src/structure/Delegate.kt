package structure

interface Leader {
    fun signDocument(name: String) // 签署文件
}

// 老板(委托者)
class Boss: Leader {
    override fun signDocument(name: String) {
       println("老板签署了文件：$name")
    }
}

// 秘书(代理人)
class Secret(
    private val boss: Boss,
): Leader {
    override fun signDocument(name: String) {
        println("秘书收到文件: $name")
        boss.signDocument(name)
    }
}

fun main() {
    val secret = Secret(Boss())
    secret.signDocument("项目合同")
}