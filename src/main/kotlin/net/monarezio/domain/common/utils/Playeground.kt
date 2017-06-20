package net.monarezio.domain.common.utils

import models.GameBoard
import net.monarezio.domain.common.extensions.diagonalLeft
import net.monarezio.domain.common.extensions.toCoordinates
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Coordinate
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 05/05/2017.
 */




fun main(args: Array<String>) {

    val b = GameBoard.createBoard(listOf(
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.CIRCLE, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON)
    ))

    fun getAvailableMoves(board: Board): List<Coordinate> {
        val coordinates = board.getFields().toCoordinates()
        return coordinates.filter { i -> board.getField(i.x, i.y) == Field.ANON && board.getFieldsAround(i).any { j -> j != Field.ANON }}
    }

    println(getAvailableMoves(b))

}