class GameEngine {
    fun displayBoard(currBoard: Board) {
        val board = currBoard.board;
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

    fun getInput(): Triple<PieceType, ColorType, Pair<Int, Int>> {
        println("Enter your move in this format, (piece,position, e.g.: knight,e6): ")
        val input = readLine() ?: ""
        val parts = input.split(",")
        val pieceType = parsePieceType(parts[0])
        val position = parsePosition(parts[1])
        val color = if (parts[0].startsWith("black")) ColorType.BLACK else ColorType.WHITE
        return Triple(pieceType, color, position)
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
}