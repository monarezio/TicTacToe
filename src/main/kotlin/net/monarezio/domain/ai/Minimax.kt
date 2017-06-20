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
        val nextMoves = getAvailableMoves(game.getBoard())
        return nextMoves.map { i -> Pair(i, game.makeMove(i.x, i.y)) }
                .map { i -> Pair(i.first, adjacent(i.second.getBoard(), i.first)) }
                .sortedBy { i -> i.second }
                .first().first
    }

    private fun eval(board: Board, playerOnMove: Field): Int {
        return 1
    }

    /**
     * DOES NOT ACTUALLY RETURN NUMBER OF ADJACENT FIELDS (black magic)
     */
    private fun adjacent(board: Board, pos: Coordinate, amount: Int = 1, memory: Set<Coordinate> = setOf()): Int {
        val tmpList = board.getCoordsAround(pos)
                .filter { i -> board.getField(pos.x, pos.y) == board.getField(i.x, i.y) && !memory.contains(i) }

        if(tmpList.isEmpty())
            return amount

        return tmpList
                .map { i -> adjacent(board, i, amount + 1, memory + pos) }
                .sum()
    }

    private fun getAvailableMoves(board: Board): List<Coordinate> {
        val coordinates = board.getFields().toCoordinates()
        return coordinates.filter { i -> board.getField(i.x, i.y) == Field.ANON && board.getFieldsAround(i).any { j -> j != Field.ANON }}
    }
}