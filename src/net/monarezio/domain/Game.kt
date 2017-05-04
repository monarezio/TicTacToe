package net.monarezio.domain

import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Field
import net.monarezio.domain.models.GameBoard

/**
 * Created by monarezio on 04/05/2017.
 */
class Game private constructor(private val board: Board, private val playerOnMove: Field): TicTacToe {

    override fun makeMove(x: Int, y: Int): TicTacToe {
        if(isMoveAvailable(x, y) && !isGameOver())
            return createGame(board.setField(x, y, playerOnMove), playerOnMove.toggle())
        return this
    }

    override fun getWinner(): Field { //TODO get the winner
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isGameOver(): Boolean = false //TODO: according to isGameOver

    override fun isMoveAvailable(x: Int, y: Int): Boolean = board.getField(x, y) == Field.ANON

    override fun getPlayerOnMove(): Field = playerOnMove

    override fun getBoard(): Board = board

    companion object {

        /**
         * creates a new game with an empty gameboard
         */
        fun createNewGame(rows: Int , columns: Int): TicTacToe =  Game(GameBoard.createNewBoard(rows, columns), Field.CROSS)

        fun createGame(board: Board, playerOnMove: Field) = Game(board, playerOnMove)
    }
}