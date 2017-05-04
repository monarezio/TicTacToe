package net.monarezio.domain.models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * Created by monarezio on 04/05/2017.
 */
internal class GameBoardTest {

    val emptyBoard = GameBoard.createNewBoard(5, 4)

    @Test
    fun getRows() {
        assertEquals(5, emptyBoard.getRows())
    }

    @Test
    fun getColumns() {
        assertEquals(4, emptyBoard.getColumns())
    }

    @Test
    fun setField() {
        val newBoard = emptyBoard.setField(0, 1, Field.CIRCLE)
        assertEquals(Field.CIRCLE, newBoard.getField(0, 1))
    }

}