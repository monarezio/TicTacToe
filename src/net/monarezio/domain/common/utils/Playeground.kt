package net.monarezio.domain.common.utils

import net.monarezio.domain.common.extensions.diagonalLeft
import net.monarezio.domain.game.models.Field

/**
 * Created by monarezio on 05/05/2017.
 */




fun main(args: Array<String>) {
    val fields = listOf(
            listOf(Field.ANON, Field.CROSS, Field.ANON, Field.ANON),
            listOf(Field.CIRCLE, Field.CROSS, Field.ANON, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.CROSS, Field.ANON),
            listOf(Field.ANON, Field.ANON, Field.ANON, Field.CROSS)
    )


    val x = 1
    val y = 3
    val diagonal = fields.diagonalLeft(x, y, 3)

    print(diagonal)
}