package net.monarezio.domain.ai

import net.monarezio.domain.common.extensions.toCoordinates
import net.monarezio.domain.game.AiTicTacToe
import net.monarezio.domain.game.Game
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 12/06/2017.
 */
class Minimax: Ai {

    override fun nextCoordinates(game: AiTicTacToe): Coordinate {

        if(game.getLastCoordinates().first.isEmpty() && game.getLastCoordinates().second.isEmpty())
            return Coordinate(game.getBoard().getRows()/1, game.getBoard().getColumns()/2)

        val a = getAvailableMoves(game.getBoard(), game.getLastCoordinates())
                .parallelStream()
                .map { i -> Pair(minimax(game.makeMove(i.x, i.y), 3, false, game.getPlayerOnMove()), i) }

        return a
                .sorted { o1, o2 -> o2.first.compareTo(o1.first) }
                .findFirst().get().second
    }

    private fun minimax(game: AiTicTacToe, depth: Int = 4, max: Boolean, playerOnMove: Field): Int {
        if(depth == 0)
            return eval(game, playerOnMove)

        val tmpResult = getAvailableMoves(game.getBoard(), game.getLastCoordinates())
                .map { i -> minimax(game.makeMove(i.x, i.y), depth - 1, !max, playerOnMove) }
                .sorted()

        if(max)
            return tmpResult.last()
        return tmpResult.first()
    }

    private fun eval(game: AiTicTacToe, playerOnMove: Field): Int {
        val winner = game.getWinner().first
        if(winner == playerOnMove)
            return Int.MAX_VALUE
        else if(winner == playerOnMove.toggle())
            return Int.MIN_VALUE
        else return 0
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

    private fun getAvailableMoves(board: Board, lastCoords: Pair<Coordinate, Coordinate>): List<Coordinate>
            = (board.getCoordsAround(lastCoords.first) + board.getCoordsAround(lastCoords.second)).filter { i -> board.getField(i.x, i.y) == Field.ANON }
}