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
     * sets the field on the position given and returns a new Board
     */
    fun setField(x: Int, y: Int, field: Field): Board

}