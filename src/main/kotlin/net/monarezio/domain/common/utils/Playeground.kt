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
            listOf(Field.ANON, Field.CROSS, Field.CROSS, Field.ANON),
            listOf(Field.ANON, Field.CROSS, Field.CROSS, Field.CROSS),
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.ANON)
    ))

    fun adjacent(board: Board, pos: Coordinate, amount: Int = 1, memory: Set<Coordinate> = setOf()): Int {
        val tmpList = board.getCoordsAround(pos)
                .filter { i -> board.getField(pos.x, pos.y) == board.getField(i.x, i.y) && !memory.contains(i) }

        if(tmpList.isEmpty())
            return amount

        return tmpList
            .map { i -> adjacent(board, i, amount + 1, memory + pos) }
            .sorted().last()
    }

    println(adjacent(b, Coordinate(0, 0)))

}