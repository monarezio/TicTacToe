package net.monarezio.domain.common.extensions

/**
 * Created by monarezio on 04/05/2017.
 */

fun<E> List<E>.set(index: Int, value: E): List<E> {
    return mapIndexed { i, e ->
        if(i == index) value
        else e
    }
}

fun<E> List<List<E>>.diagonalRight(i: Int, j: Int, amount: Int, list: List<E> = listOf()): List<E> {
    if(amount <= 0)
        return list
    return diagonalRight(i + 1, j + 1, amount-1, list + listOf(get(i)[j]))
}

fun<E> List<List<E>>.diagonalLeft(i: Int, j: Int, amount: Int, list: List<E> = listOf()): List<E> {
    if(amount <= 0)
        return list
    return diagonalLeft(i + 1, j - 1, amount-1, list + listOf(get(i)[j]))
}