package net.monarezio.domain.ai

import net.monarezio.domain.game.AiTicTacToe
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 12/06/2017.
 */
class Minimax: Ai {
    override fun nextCoordinates(game: AiTicTacToe): Coordinate {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun eval(board: Board, playerOnMove: Field): Int {
        
    }
}