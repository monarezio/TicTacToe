package net.monarezio.domain.list

import net.monarezio.domain.ai.Ai

/**
 * Created by monarezio on 08/06/2017.
 */
interface AiList {

    /**
     * returns names of available AIs
     */
    fun getAvailableAis(): Set<Class<out Ai>>

}