package net.monarezio.domain

import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Field

/**
 * Created by monarezio on 04/05/2017.
 */
interface TicTacToe {

    /**
     * returns a new game state with the modified values
     */
    fun onMoveMade(x: Int, y: Int): TicTacToe

    /**
     * returns the winner of the game, if there is no winner Field.ANON is returned
     */
    fun isGameOver(): Field

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
}