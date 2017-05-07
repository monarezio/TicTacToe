package net.monarezio.domain

import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Coordinate
import net.monarezio.domain.models.Field

/**
 * Created by monarezio on 04/05/2017.
 */
interface TicTacToe {

    /**
     * returns a new game state with the modified values
     */
    fun makeMove(x: Int, y: Int): TicTacToe

    /**
     * returns the winner of the game and the position of the end scene, if there is no winner Field.ANON is returned
     */
    fun getWinner(): Pair<Field, List<Coordinate>>

    /**
     * returns true if the game is over, false if it is not
     */
    fun isGameOver(): Boolean

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