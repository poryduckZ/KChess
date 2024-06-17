class GameEngine {
    private val board = Board()
    private var currentPlayer = ColorType.WHITE
    fun start() {
        while (true) {
            displayBoard()
            println("${currentPlayer}'s turn. Enter your move (e.g., knight,e6): ")
            val (pieceType, position) = getInput()

            if (movePiece(board, pieceType, currentPlayer, position)) {
                currentPlayer = if (currentPlayer == ColorType.WHITE) ColorType.BLACK else ColorType.WHITE
            } else {
                println("Invalid move. Try again.")
            }
        }
    }

    private fun displayBoard() {
        val board = board.board
        println("  a b c d e f g h")
        for (i in board.indices) {
            print("${8 - i} ")
            for (piece in board[i]) {
                print(
                    when (piece.color) {
                        ColorType.WHITE -> when (piece.type) {
                            PieceType.KING -> "♔ "
                            PieceType.QUEEN -> "♕ "
                            PieceType.ROOK -> "♖ "
                            PieceType.BISHOP -> "♗ "
                            PieceType.KNIGHT -> "♘ "
                            PieceType.PAWN -> "♙ "
                            PieceType.EMPTY -> ". "
                        }
                        ColorType.BLACK -> when (piece.type) {
                            PieceType.KING -> "♚ "
                            PieceType.QUEEN -> "♛ "
                            PieceType.ROOK -> "♜ "
                            PieceType.BISHOP -> "♝ "
                            PieceType.KNIGHT -> "♞ "
                            PieceType.PAWN -> "♟ "
                            PieceType.EMPTY -> ". "
                        }
                        ColorType.NONE -> ". "
                    }
                )
            }
            println(" ${8 - i}")
        }
        println("  a b c d e f g h")
    }

    fun getInput(): Pair<PieceType, Pair<Int, Int>> {
        println("Enter your move in this format, (piece,position, e.g. knight,e6): ")
        val input = readLine() ?: ""
        val parts = input.split(",")
        val pieceType = parsePieceType(parts[0])
        val position = parsePosition(parts[1])
        return Pair(pieceType, position)
    }

    private fun parsePieceType(pieceType: String): PieceType {
        return when (pieceType.lowercase()) {
            "king" -> PieceType.KING
            "queen" -> PieceType.QUEEN
            "rook" -> PieceType.ROOK
            "bishop" -> PieceType.BISHOP
            "knight" -> PieceType.KNIGHT
            "pawn" -> PieceType.PAWN
            else -> PieceType.EMPTY
        }
    }

    private fun parsePosition(position: String): Pair<Int, Int> {
        val column = position[0] - 'a'
        val row = 8 - (position[1] - '0')
        return Pair(column, row)
    }

    private fun movePiece(board: Board, pieceType: PieceType, color: ColorType, to: Pair<Int, Int>): Boolean {
        var from: Pair<Int, Int>? = null

        for (i in board.board.indices) {
            for (j in board.board[i].indices) {
                val piece = board.board[i][j]
                if (piece.type == pieceType && piece.color == color) {
                    from = Pair(j, i)
                    break
                }
            }
            if (from != null) break
        }

        return if (from != null) {
            board.board[to.second][to.first] = board.board[from.second][from.first]
            board.board[from.second][from.first] = Piece(PieceType.EMPTY, ColorType.NONE)
            true
        } else {
            println("Invalid move.")
            false
        }
    }
}