package net.monarezio.domain.ai.models

import net.monarezio.domain.ai.Ai
import tornadofx.*

/**
 * Created by monarezio on 06/06/2017.
 */
data class AiItems(val cross: Ai?, val circle: Ai?): ViewModel()