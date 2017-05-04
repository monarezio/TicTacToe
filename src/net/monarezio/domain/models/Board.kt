package net.monarezio.domain.models

/**
 * Created by monarezio on 04/05/2017.
 */
interface Board {

    /**
     * returns fields
     */
    fun getFields(): List<List<Field>>

    /**
     * returns the field ont the current position
     */
    fun getField(x: Int, y: Int): Field

    /**
     * sets the field on the position given and returns a new Board
     */
    fun setField(x: Int, y: Int, field: Field): Board

    /**
     * returns amount of rows
     */
    fun getRows(): Int

    /**
     * returns amount of columns
     */
    fun getColumns(): Int
}