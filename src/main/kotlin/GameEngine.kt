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
}