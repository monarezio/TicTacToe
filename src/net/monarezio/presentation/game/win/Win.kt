package net.monarezio.presentation.game.win

import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import tornadofx.*

/**
 * Created by monarezio on 07/05/2017.
 */
class Win(val player: String) : View() {
    override val root = StackPane()

    init {
        with(root) {
            root += Label("Winner: " + player)
        }
    }
}
