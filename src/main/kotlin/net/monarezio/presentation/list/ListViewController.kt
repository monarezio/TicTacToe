package net.monarezio.presentation.list

import net.monarezio.domain.ai.Ai
import net.monarezio.domain.list.AiListManager
import tornadofx.*

/**
 * Created by monarezio on 06/06/2017.
 */
class ListViewController: Controller() {

    private val classes = AiListManager.instance.getAvailableAis()

    fun getAvailableAis(): List<String> = classes.map { i -> i.simpleName }

    fun getAiByName(name: String): Ai = classes.find { i -> i.simpleName == name }?.newInstance()!!

}