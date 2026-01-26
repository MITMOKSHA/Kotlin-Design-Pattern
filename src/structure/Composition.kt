package structure

interface Component {
    fun display()
}

class Composite: Component {
    private val children: MutableList<Component> = mutableListOf()
    override fun display() {
        children.forEach { it.display() }
    }

    fun addChild(component: Component) {
        children.add(component)
    }

    fun removeChild(component: Component) {
        children.remove(component)
    }

}

class Leaf(
    private val name: String,
): Component {
    override fun display() {
        println(name)
    }
}

fun main() {
    val leaf1 = Leaf("节点1")
    val leaf2 = Leaf("节点2")
    val leaf3 = Leaf("节点3")
    val leaf4 = Leaf("节点4")
    val leaf5 = Leaf("节点5")
    val composite = Composite().apply {
        addChild(leaf1)
        addChild(leaf2)
        addChild(leaf3)
        addChild(leaf4)
    }
    val composite2 = Composite().apply {
        addChild(composite)
        addChild(leaf5)
    }
    composite2.display()
}