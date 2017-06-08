package net.monarezio.domain.list

import net.monarezio.domain.ai.Ai
import org.reflections.Reflections

/**
 * Created by monarezio on 08/06/2017.
 */
class AiListManager private constructor(): AiList {

    override fun getAvailableAis(): Set<Class<out Ai>> {
        val reflections = Reflections("net.monarezio.domain.ai")
        return reflections.getSubTypesOf<Ai>(Ai::class.java)
    }

    companion object {
        val instance = AiListManager()
    }

}