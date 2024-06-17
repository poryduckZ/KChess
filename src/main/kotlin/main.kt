fun main() {
    val board = Board()
    val gameEngine = GameEngine()

    gameEngine.displayBoard(board)

    while (true) {
        val input = gameEngine.getInput()
        println(input)
    }
}