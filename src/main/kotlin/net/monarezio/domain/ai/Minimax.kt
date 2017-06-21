package net.monarezio.domain.ai

import net.monarezio.domain.common.extensions.toCoordinates
import net.monarezio.domain.game.AiTicTacToe
import net.monarezio.domain.game.Game
import net.monarezio.domain.game.TicTacToe
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field
import java.util.stream.Collectors

/**
 * Created by monarezio on 12/06/2017.
 */
class Minimax: Ai {
    override fun nextCoordinates(game: AiTicTacToe): Coordinate {
        return minimax(game)
    }

    private fun minimax(game: AiTicTacToe, depth: Int = 3): Coordinate {
        return getAvailableMoves(game.getBoard())
                .parallelStream()
                .map { i -> Pair(i, minimaxNumeric(game.makeMove(i.x, i.y), depth - 1, i)) }
                .sorted { o1, o2 -> o2.second.compareTo(o1.second) }
                .findFirst().get().first
    }

    private fun minimaxNumeric(game: AiTicTacToe, depth: Int = 2, lastMove: Coordinate): Int {
        if(depth <= 0)
            return eval2(game)
        return getAvailableMoves(game.getBoard())
                .parallelStream()
                .map { i -> minimaxNumeric(game.makeMove(i.x, i.y), depth - 1, i) }
                .sorted { o1, o2 -> o2.compareTo(o1) }
                .findFirst()
                .get()
    }

    private fun eval(board: Board, pos: Coordinate, amount: Int = 1, memory: Set<Coordinate> = setOf()): Int {
        val tmpList = board.getCoordsAround(pos)
                .filter { i -> board.getField(pos.x, pos.y) == board.getField(i.x, i.y) && !memory.contains(i) }

        if(tmpList.isEmpty())
            return amount

        return tmpList
                .map { i -> eval(board, i, amount + 1, memory + pos) }
                .sorted().last()
    }

    private fun eval2(game: AiTicTacToe, lastMove: Coordinate): Int {
        
    }

    private fun getAvailableMoves(board: Board): List<Coordinate> {
        val coordinates = board.getFields().toCoordinates()
        return coordinates.filter { i -> board.getField(i.x, i.y) == Field.ANON && board.getFieldsAround(i).any { j -> j != Field.ANON }}
    }
}