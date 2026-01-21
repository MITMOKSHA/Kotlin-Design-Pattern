package behavior

interface Command {
    fun execute()
}

interface Receiver {
    fun turnOn()
    fun turnOff()
}

class Light: Receiver {
    override fun turnOn() {
        println("打开电灯")
    }

    override fun turnOff() {
        println("关闭电灯")
    }
}

class Tv: Receiver {
    override fun turnOn() {
        println("打开电视")
    }

    override fun turnOff() {
        println("关闭电视")
    }
}

/**
 * 针对接收者抽象编程，不是必须的，因为接受者并不一定是高度一致的
 */
class TurnOnCommand(
    private val receiver: Receiver
): Command {
    override fun execute() {
        receiver.turnOn()
    }
}

class TurnOffCommand(
    private val receiver: Receiver
): Command {
    override fun execute() {
        receiver.turnOff()
    }
}


class RemoteControl {
    private var command: Command? = null
    fun setCommand(command: Command) {
        this.command = command
    }
    fun pressBtn() {
        command?.execute()
    }
}

fun main() {
    val remoteCommand = RemoteControl()
    val tv = Tv()
    val light = Light()
    remoteCommand.setCommand(TurnOnCommand(tv))
    remoteCommand.pressBtn()
    remoteCommand.setCommand(TurnOffCommand(tv))
    remoteCommand.pressBtn()
    remoteCommand.setCommand(TurnOnCommand(light))
    remoteCommand.pressBtn()
    remoteCommand.setCommand(TurnOffCommand(light))
    remoteCommand.pressBtn()
}