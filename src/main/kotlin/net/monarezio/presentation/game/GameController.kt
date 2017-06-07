package net.monarezio.presentation.game

import net.monarezio.domain.ai.models.AiItems
import net.monarezio.domain.game.Game
import net.monarezio.domain.game.TicTacToe
import net.monarezio.domain.game.models.Board
import tornadofx.*

/**
 * Created by monarezio on 07/05/2017.
 */

class GameController : Controller() {
    private val aiItems: AiItems by inject()

    private var game: TicTacToe = Game.createNewGame(22, 35, 5, aiItems.circle, aiItems.cross)

    fun onMoveMade(x: Int, y: Int) {
        game = game.makeMove(x, y)
    }

    fun getBoard(): Board = game.getBoard()

    fun getWinner() = game.getWinner()

    fun resetBoard() {
        game = Game.createNewGame(22, 35, 5, aiItems.circle, aiItems.cross)
    }
}