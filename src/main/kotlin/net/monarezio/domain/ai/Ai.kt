package net.monarezio.domain.ai

import net.monarezio.domain.game.AiTicTacToe
import net.monarezio.domain.game.TicTacToe
import net.monarezio.domain.game.models.Coordinate
import tornadofx.*

/**
 * Created by monarezio on 17/05/2017.
 */

/**
 * Created by monarezio on 06/06/2017.
 */
interface Ai {

    fun nextCoordinates(game: AiTicTacToe): Coordinate

}