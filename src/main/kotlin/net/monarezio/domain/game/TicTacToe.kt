package net.monarezio.domain.game

import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 04/05/2017.
 */
interface TicTacToe : AiTicTacToe{

    /**
     * returns the winner of the game and the position of the end scene, if there is no winner Field.ANON is returned
     */
    fun getWinner(): Pair<Field, List<Coordinate>>

    /**
     * returns true if the game is over, false if it is not
     */
    fun isGameOver(): Boolean
}