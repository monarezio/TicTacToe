package net.monarezio.domain.ai

import net.monarezio.domain.common.extensions.random
import net.monarezio.domain.game.AiTicTacToe
import net.monarezio.domain.game.TicTacToe
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 19/05/2017.
 */
class RandomAi : Ai {
    override fun nextCoordinates(game: AiTicTacToe): Coordinate {
        val board = game.getBoard().getFields()
        while (true) {
            val x = Int.random(0, board.size - 1)
            val y = Int.random(0, board[x].size - 1)
            if (board[x][y] == Field.ANON)
                return Coordinate(x, y)
        }
    }
}