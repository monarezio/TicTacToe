package net.monarezio.domain.ai

import net.monarezio.domain.common.extensions.*
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
                .map { i -> Pair(minimax(game.makeMove(i.x, i.y), 2, false, game.getPlayerOnMove()), i) }

        return a
                .sorted { o1, o2 -> o2.first.compareTo(o1.first) }
                .findFirst().get().second
    }

    private fun minimax(game: AiTicTacToe, depth: Int = 2, max: Boolean, playerOnMove: Field): Int {
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
        val winNumber = 5 //TODO: make it more universal
        val board = game.getBoard()
        val fields = board.getFields()

        var amount = 0

        for(i in 0..board.getRows() - winNumber) {
            for(j in 0..board.getColumns() - winNumber) {
                val rows = i.rangeTo(i + winNumber - 1).map { index -> fields[index][j] }
                val rowCount = rows.count { i -> i == playerOnMove }
                if(rowCount > 0)
                    amount = rowCount


                val columns = j.rangeTo(j + winNumber - 1).map { index -> fields[i][index] }
                val collumnCount = columns.count { i -> i == playerOnMove }
                if(collumnCount > amount)
                    amount = collumnCount

                val diagonalRight = fields.diagonalRight(i, j, winNumber)
                val diagonalRightCount = diagonalRight.count { i -> i == playerOnMove }
                if(diagonalRightCount > amount)
                    amount = diagonalRightCount

                val diagonalLeft = fields.diagonalLeft(i, j + winNumber - 1, winNumber)
                val diagonalLeftCount = diagonalLeft.count { i -> i == playerOnMove }
                if(diagonalLeftCount > amount)
                    amount = diagonalLeftCount
            }
        }


        println(amount)
        return amount
    }

    private fun getAvailableMoves(board: Board, lastCoords: Pair<Coordinate, Coordinate>): List<Coordinate>
            = (board.getCoordsAround(lastCoords.first) + board.getCoordsAround(lastCoords.second)).filter { i -> board.getField(i.x, i.y) == Field.ANON }
}