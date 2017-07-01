package net.monarezio.domain.game.models

/**
 * Created by monarezio on 07/05/2017.
 */

data class Coordinate(val x: Int, val y: Int) {
    fun isEmpty() = (x < 0 || y < 0)
}