package creation

abstract class ComputerFactory {
    abstract fun createRam(): RamComponent
    abstract fun createCpu(): CpuComponent
}

class WindowsFactory: ComputerFactory() {
    override fun createRam() = KinstonRam("金士顿", 10)
    override fun createCpu() = IntelCpu("英特尔", "x86")
}

class MacFactory: ComputerFactory() {
    override fun createRam() = SumsungRam("三星", 3)
    override fun createCpu() = AMDCpu("AMD", "ARM")
}

abstract class RamComponent {
    abstract val brand: String
    abstract val capacity: Int
    fun spec() {
        println("$brand 容量：${capacity}G")
    }
}

abstract class CpuComponent {
    abstract val brand: String
    abstract val arch: String
    fun spec() {
        println("$brand 指令集结构：$arch")
    }
}

class KinstonRam(override val brand: String, override val capacity: Int) : RamComponent()
class SumsungRam(override val brand: String, override val capacity: Int) : RamComponent()

class IntelCpu(override val brand: String, override val arch: String) : CpuComponent()
class AMDCpu(override val brand: String, override val arch: String) : CpuComponent()

fun main() {
    val windowsPC = WindowsFactory()
    windowsPC.createCpu().spec()
    windowsPC.createRam().spec()
    val macPC = MacFactory()
    macPC.createCpu().spec()
    macPC.createRam().spec()
}