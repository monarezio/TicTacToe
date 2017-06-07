package net.monarezio.domain.common.extensions

import java.util.concurrent.ThreadLocalRandom

/**
 * Created by monarezio on 06/06/2017.
 */

/**
 * Returns a random number
 */
fun Int.Companion.random (lower: Int , upper: Int) = ThreadLocalRandom.current().nextInt(lower, upper + 1);