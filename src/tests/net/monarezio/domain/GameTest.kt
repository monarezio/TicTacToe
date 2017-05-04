package net.monarezio.domain

import net.monarezio.domain.models.Field
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * Created by monarezio on 04/05/2017.
 */
internal class GameTest {

    val game = Game.createNewGame(4, 4)
    val newGame = game.makeMove(1, 2)

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

}