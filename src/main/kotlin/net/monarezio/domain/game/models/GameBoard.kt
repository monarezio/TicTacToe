package models

import net.monarezio.domain.common.extensions.set
import net.monarezio.domain.game.models.Board
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 04/05/2017.
 */
data class GameBoard private constructor(private val fields: List<List<Field>>): Board {

    override fun getFields(): List<List<Field>> = fields

    override fun getField(x: Int, y: Int): Field = fields[x][y]

    override fun setField(x: Int, y: Int, field: Field): Board = GameBoard.Companion.createBoard(fields.set(x, fields[x].set(y, field)))

    override fun getRows(): Int = fields.size

    override fun getColumns(): Int = fields[0].size

    companion object {

        /**
         * creates a new empty board
         */
        fun createNewBoard(rows: Int, columns: Int): Board = GameBoard(
                0.rangeTo(rows - 1).map { i -> 0.rangeTo(columns - 1).map { j -> Field.ANON } }
        )

        /**
         * creates a board with preset fields
         */
        fun createBoard(fields: List<List<Field>>): Board = GameBoard(fields)

    }
}