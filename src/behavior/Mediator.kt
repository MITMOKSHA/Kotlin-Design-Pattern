package behavior

interface Mediator {
    fun sendMessage(message: String, sender: User)
}

class ChatRoom: Mediator {
    private val userList = mutableListOf<User>()

    fun addUser(user: User) {
        userList.add(user)
    }

    override fun sendMessage(message: String, sender: User) {
        for (user in userList) {
            if (user === sender) {
                continue
            }
            user.receiveMessage(message)
        }
    }
}

abstract class User {
    abstract fun sendMessage(message: String)
    abstract fun receiveMessage(message: String)
}

class ChatUser(
    private val name: String,
    private val mediator: ChatRoom
): User() {
    init {
        mediator.addUser(this)
    }

    override fun sendMessage(message: String) {
        println("$name 发送 $message")
        mediator.sendMessage(message, this)
    }

    override fun receiveMessage(message: String) {
        println("$name 收到了 $message")
    }
}

fun main() {
    val chatRoom = ChatRoom()
    val user1 = ChatUser("张三", chatRoom)
    val user2 = ChatUser("李四", chatRoom)
    val user3 = ChatUser("王五", chatRoom)
    user1.sendMessage("hi 各位")
    println("=====")
    user2.sendMessage("大家好")
}