package structure

class Chess(
    private val color: String,  // 内部状态(可共享)
) {
    fun move(x: Int, y: Int) {  // 外部状态(不可共享)
        println("$color 移动到($x,$y)")
    }
}

class ChessCreator {
    private val chessPool = mutableMapOf<String, Chess>()

    fun createChess(color: String): Chess {
        // ps: getOrPut不是线程安全的
        return chessPool.getOrPut(color) {
            Chess(color)
        }
    }
}

fun main() {
    ChessCreator().apply {
        val cb1 = createChess("黑色").move(1,2)
        createChess("白色").move(0, 1)
        val cb2 = createChess("黑色").move(2, 3)
        // 共用同一个对象
        println(cb1 === cb2)
    }
}