package net.monarezio.domain.game

import models.GameBoard
import net.monarezio.domain.ai.Ai
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 17/05/2017.
 */
class GameBuilder private constructor(private val board: Board, private val playerOnMove: Field = Field.CIRCLE, private val winNumber: Int = 5,
                  private val circle: Ai? = null, private val cross: Ai? = null) {


    fun setCircleAi(ai: Ai): GameBuilder {
        return GameBuilder(board, playerOnMove, winNumber, ai, cross)
    }

    fun setCrossAi(ai: Ai): GameBuilder {
        return GameBuilder(board, playerOnMove, winNumber, circle, ai)
    }

    fun setPlayerOnMove(playerOnMove: Field): GameBuilder {
        return GameBuilder(board, playerOnMove, winNumber, circle, cross)
    }

    fun setWinNumber(winNumber: Int): GameBuilder {
        return GameBuilder(board, playerOnMove, winNumber, circle, cross)
    }

    fun build(): TicTacToe = Game.createGame(board, playerOnMove, winNumber, circle, cross)

    companion object {
        fun createBuilder(board: Board) = GameBuilder(board)

        fun createBuilder(rows: Int, columns: Int) = GameBuilder(GameBoard.createNewBoard(rows, columns))
    }
}