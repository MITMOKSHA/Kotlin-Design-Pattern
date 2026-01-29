package structure

class Amplifier {
    fun on() = println("功放打开")
    fun off() = println("功放关闭")
}
class DVDPlayer {
    fun play() = println("DVD播放")
    fun stop() = println("DVD播放结束")
}
class Projector {
    fun down() = println("投影仪放下")
    fun up() = println("投影仪收起")
}

class TheaterFacade {
    private val projector = Projector()
    private val dvd = DVDPlayer()
    private val amplifier = Amplifier()

    fun watchMove() {
        println("===开始播放电影")
        projector.down()
        amplifier.on()
        dvd.play()
    }

    fun endMove() {
        println("===结束播放电影")
        dvd.stop()
        amplifier.off()
        projector.up()
    }
}

fun main() {
    val theater = TheaterFacade()
    theater.watchMove()
    println("===观影...")
    theater.endMove()
}