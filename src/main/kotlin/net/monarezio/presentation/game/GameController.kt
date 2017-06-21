package net.monarezio.presentation.game

import net.monarezio.domain.ai.Ai
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

    private var game: TicTacToe = Game.createNewGame(22, 35, 5)

    fun onMoveMade(x: Int, y: Int) {
        val circle = aiItems.circle
        val cross = aiItems.cross
        if(circle is Ai && cross is Ai) {
            val crossCoords = cross.nextCoordinates(game)
            game = game.makeMove(crossCoords.x, crossCoords.y)
            val circleCoords = circle.nextCoordinates(game)
            game = game.makeMove(circleCoords.x, circleCoords.y)
        } else if(circle is Ai) {
            game = game.makeMove(x, y)
            val circleCoords = circle.nextCoordinates(game)
            game = game.makeMove(circleCoords.x, circleCoords.y)
        } else {
            game = game.makeMove(x, y)
        }
    }

    fun getBoard(): Board = game.getBoard()

    fun getWinner() = game.getWinner()

    fun resetBoard() {
        game = Game.createNewGame(22, 35, 5)
    }

    fun makeOneMove() {
        val circle = aiItems.circle
        val cross = aiItems.cross
        if (circle is Ai && cross is Ai) {
            val crossCoords = cross.nextCoordinates(game)
            game = game.makeMove(crossCoords.x, crossCoords.y)
            val circleCoords = circle.nextCoordinates(game)
            game = game.makeMove(circleCoords.x, circleCoords.y)
        }
    }

    fun play() {

    }

    fun isAiVsAi(): Boolean = aiItems.cross is Ai && aiItems.circle is Ai
}