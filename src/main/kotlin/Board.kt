class Board {

    val board: Array<Array<Piece>> = Array(8) { Array(8) { Piece(PieceType.EMPTY, ColorType.NONE) } }

    init {
        setupPieces()
    }

    private fun setupPieces() {
        for (i in 0..7) {
            board[1][i] = Piece(PieceType.PAWN, ColorType.WHITE)
            board[6][i] = Piece(PieceType.PAWN, ColorType.BLACK)
        }

        board[0][0] = Piece(PieceType.ROOK, ColorType.WHITE)
        board[0][7] = Piece(PieceType.ROOK, ColorType.WHITE)
        board[7][0] = Piece(PieceType.ROOK, ColorType.BLACK)
        board[7][7] = Piece(PieceType.ROOK, ColorType.BLACK)

        board[0][1] = Piece(PieceType.KNIGHT, ColorType.WHITE)
        board[0][6] = Piece(PieceType.KNIGHT, ColorType.WHITE)
        board[7][1] = Piece(PieceType.KNIGHT, ColorType.BLACK)
        board[7][6] = Piece(PieceType.KNIGHT, ColorType.BLACK)

        board[0][2] = Piece(PieceType.BISHOP, ColorType.WHITE)
        board[0][5] = Piece(PieceType.BISHOP, ColorType.WHITE)
        board[7][2] = Piece(PieceType.BISHOP, ColorType.BLACK)
        board[7][5] = Piece(PieceType.BISHOP, ColorType.BLACK)

        board[0][3] = Piece(PieceType.QUEEN, ColorType.WHITE)
        board[0][4] = Piece(PieceType.KING, ColorType.WHITE)
        board[7][3] = Piece(PieceType.QUEEN, ColorType.BLACK)
        board[7][4] = Piece(PieceType.KING, ColorType.BLACK)
    }
}