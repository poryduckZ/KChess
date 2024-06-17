fun main() {
    val gameEngine = GameEngine()

    gameEngine.start()

    while (true) {
        val input = gameEngine.getInput()
        println(input)
    }
}