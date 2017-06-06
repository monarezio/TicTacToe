package net.monarezio.domain.ai.models

import net.monarezio.domain.ai.Ai
import tornadofx.*

/**
 * Created by monarezio on 19/05/2017.
 */
data class Ais(val circle: Ai?, val cross: Ai?): ViewModel()