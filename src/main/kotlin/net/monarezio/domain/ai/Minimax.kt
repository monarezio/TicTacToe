package net.monarezio.domain.ai

import net.monarezio.domain.common.extensions.toCoordinates
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
        return 1
    }

    private fun adjacent(amount: Int, pos: Coordinate) {

    }

    private fun getAvailableMoves(board: Board): List<Coordinate> {
        val coordinates = board.getFields().toCoordinates()
        return coordinates.filter { i -> board.getField(i.x, i.y) == Field.ANON && board.getFieldsAround(i).any { j -> j != Field.ANON }}
    }
}