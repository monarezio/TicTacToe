package net.monarezio.domain.game.models

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
     * returns list of fields around the point in a random order
     */
    fun getFieldsAround(x: Int, y: Int): List<Field>

    /**
     * returns list of fields around the point in a random order
     */
    fun getFieldsAround(coord: Coordinate): List<Field>

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