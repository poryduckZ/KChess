class GameEngine {
    fun displayBoard(board: Board) {
        for (row in board.board) {
            for (piece in row) {
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
            println()
        }
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