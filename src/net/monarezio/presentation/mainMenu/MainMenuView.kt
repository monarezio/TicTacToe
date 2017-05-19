package net.monarezio.presentation.mainMenu

import javafx.scene.layout.AnchorPane
import net.monarezio.domain.ai.RandomAi
import net.monarezio.domain.ai.models.Ais
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

    fun handleHumanVsAi() {
        val ais = Ais(null, RandomAi())
        val scope = Scope()
        setInScope(ais, scope)

        this += find<GameView>(scope)
    }
}
