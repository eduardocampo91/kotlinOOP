package cats

fun main () {
    val cat = Cats("Garuda")
    println(cat.legsCount)
    println(cat.name)
    cat.playWithMouse()

    val lion = Lion(25)
    println(lion.countInPride)

}