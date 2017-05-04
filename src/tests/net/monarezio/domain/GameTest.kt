package net.monarezio.domain

import net.monarezio.domain.models.Field
import net.monarezio.domain.models.GameBoard
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * Created by monarezio on 04/05/2017.
 */
internal class GameTest {

    val game = Game.createNewGame(4, 4)
    val newGame = game.makeMove(1, 2)
    val finishedGame = Game.createGame(GameBoard.createBoard(listOf(
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON),
            listOf(Field.CROSS, Field.CIRCLE, Field.CIRCLE, Field.CIRCLE),
            listOf(Field.ANON, Field.CROSS, Field.CROSS, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON)
    )), Field.CIRCLE, 3)
    val finishedGame2 = Game.createGame(GameBoard.createBoard(listOf(
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON)
    )), Field.CIRCLE, 3)
    val finishedGame3 = Game.createGame(GameBoard.createBoard(listOf(
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.CROSS, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.CROSS, Field.ANON),
            listOf(Field.CROSS, Field.ANON, Field.ANON, Field.CROSS)
    )), Field.CIRCLE, 3)

    @Test
    fun makeMove() {
        assertEquals(Field.CROSS, newGame.getBoard().getField(1, 2))
    }

    @Test
    fun isMoveAvailable() {
        assertEquals(false, newGame.isMoveAvailable(1, 2))
    }

    @Test
    fun getPlayerOnMove() {
        assertEquals(Field.CROSS, game.getPlayerOnMove())
        assertEquals(Field.CIRCLE, newGame.getPlayerOnMove())
    }

    @Test
    fun getWinner() {
        assertEquals(Field.ANON, game.getWinner())
        assertEquals(Field.CIRCLE, finishedGame.getWinner())
        assertEquals(Field.CROSS, finishedGame2.getWinner())
        assertEquals(Field.CROSS, finishedGame3.getWinner())
    }

}