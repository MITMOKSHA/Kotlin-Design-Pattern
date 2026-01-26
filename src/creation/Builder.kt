package creation

class Computer(
    private val cpu: String?,
    private val ram: String?,
    private val ssd: String?,
    private val disk: String?
) {
    class Builder {
        private var cpu: String? = null
        private var ram: String? = null
        private var ssd: String? = null
        private var disk: String? = null

        fun cpu(cpu: String): Builder {  // 可以用apply简化
            this.cpu = cpu
            return this
        }

        fun ram(ram: String) = apply {
            this.ram = ram
        }

        fun ssd(ssd: String) = apply {
            this.ssd = ssd
        }

        fun disk(disk: String) = apply {
            this.disk = disk
        }

        fun build(): Computer {
            return Computer(cpu, ram, ssd, disk)
        }
    }

    override fun toString(): String {
        return this.cpu + " " + this.ram + " " + this.ssd + " " + this.disk
    }
}

fun main() {
    val computer = Computer.Builder().cpu("英特尔").ram("金士顿").ssd("ssd").disk("disk").build()
    println(computer)
}