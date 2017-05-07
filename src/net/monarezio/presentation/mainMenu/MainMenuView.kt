package net.monarezio.presentation.mainMenu

import javafx.scene.Parent
import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import net.monarezio.presentation.game.GameView
import tornadofx.*

/**
 * Created by monarezio on 06/05/2017.
 */
class MainMenuView : View("Tic Tac Toe"){
    override val root: AnchorPane by fxml("/resources/fxml/main-menu.fxml")

    init {
        with(root) {

        }
    }

    fun handleHumanVsHuman() {
        replaceWith(GameView::class)
    }
}