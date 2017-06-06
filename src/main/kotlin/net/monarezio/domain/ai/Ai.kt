package net.monarezio.domain.ai

import net.monarezio.domain.game.TicTacToe
import net.monarezio.domain.game.models.Coordinate

/**
 * Created by monarezio on 17/05/2017.
 */
interface Ai{

    fun nextCoordinates(game: TicTacToe): Coordinate

}