package net.monarezio.domain.common.utils

import net.monarezio.domain.common.extensions.diagonalLeft
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 05/05/2017.
 */




fun main(args: Array<String>) {
    val a = 0.rangeTo(10).map { i -> 0.rangeTo(10) }.flatMap { i -> i }
    println(a)
}