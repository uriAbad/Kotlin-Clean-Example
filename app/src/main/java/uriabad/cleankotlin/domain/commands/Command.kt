package uriabad.cleankotlin.domain.commands

/**
 * Created by Uri Abad on 28/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
interface Command<T> {
    fun execute(): T
}