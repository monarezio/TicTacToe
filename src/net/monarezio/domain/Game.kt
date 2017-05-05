package net.monarezio.domain

import net.monarezio.domain.common.extensions.diagonalLeft
import net.monarezio.domain.common.extensions.diagonalRight
import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Field
import net.monarezio.domain.models.GameBoard

/**
 * Created by monarezio on 04/05/2017.
 */
class Game private constructor(private val board: Board, private val playerOnMove: Field, private val winNumber: Int): TicTacToe {

    override fun makeMove(x: Int, y: Int): TicTacToe {
        if(isMoveAvailable(x, y) && !isGameOver())
            return createGame(board.setField(x, y, playerOnMove), playerOnMove.toggle(), winNumber)
        return this
    }

    override fun getWinner(): Field { //TODO diagonals

        val fields = board.getFields()

        for(i in 0..board.getRows() - winNumber) {
            for(j in 0..board.getColumns() - winNumber) {
                val rows = i.rangeTo(i + winNumber - 1).map { index -> fields[index][j] }
                if(rows.all { item -> item == Field.CROSS })
                    return Field.CROSS
                else if(rows.all { item -> item == Field.CIRCLE })
                    return Field.CIRCLE

                val columns = j.rangeTo(j + winNumber - 1).map { index -> fields[i][index] }
                if(columns.all { item -> item == Field.CROSS })
                    return Field.CROSS
                else if(columns.all { item -> item == Field.CIRCLE })
                    return Field.CIRCLE

                val diagonalRight = fields.diagonalRight(i, j, winNumber)
                if(diagonalRight.all { item -> item == Field.CROSS })
                    return Field.CROSS
                else if(diagonalRight.all { item -> item == Field.CIRCLE })
                    return Field.CIRCLE

                val diagonalLeft = fields.diagonalLeft(i, j + winNumber - 1, winNumber)
                if(diagonalLeft.all { item -> item == Field.CROSS })
                    return Field.CROSS
                else if(diagonalLeft.all { item -> item == Field.CIRCLE })
                    return Field.CIRCLE
            }
        }

        return Field.ANON
    }

    override fun isGameOver(): Boolean = false //TODO: according to isGameOver

    override fun isMoveAvailable(x: Int, y: Int): Boolean = board.getField(x, y) == Field.ANON

    override fun getPlayerOnMove(): Field = playerOnMove

    override fun getBoard(): Board = board

    companion object {

        /**
         * creates a new game with an empty gameboard
         */
        fun createNewGame(rows: Int , columns: Int, winNumber: Int = 5): TicTacToe =  Game(GameBoard.createNewBoard(rows, columns), Field.CROSS, winNumber)

        /**
         * create a game with the presets
         */
        fun createGame(board: Board, playerOnMove: Field, winNumber: Int) = Game(board, playerOnMove, winNumber)
    }
}