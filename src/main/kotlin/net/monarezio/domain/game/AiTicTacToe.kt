package net.monarezio.domain.game

import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 12/06/2017.
 */
interface AiTicTacToe {

    /**
     * returns if the move on the current position is available
     */
    fun isMoveAvailable(x: Int, y: Int): Boolean

    /**
     * returns the player, who's move it is
     */
    fun getPlayerOnMove(): Field

    /**
     * returns the board
     */
    fun getBoard(): Board

    /**
     * returns a new game state with the modified values
     */
    fun makeMove(x: Int, y: Int): TicTacToe

    /**
     * returns true if the game is over, false if it is not
     */
    fun isGameOver(): Boolean
}