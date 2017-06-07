package net.monarezio.presentation.list

import javafx.scene.layout.AnchorPane
import net.monarezio.domain.game.models.type.GameType
import net.monarezio.domain.game.models.type.Type
import net.monarezio.presentation.mainMenu.MainMenuView
import tornadofx.*

/**
 * Created by monarezio on 06/06/2017.
 */
class ListView: View() {
    override val root: AnchorPane by fxml("/resources/fxml/list.fxml")

    private val crossSplit: AnchorPane by fxid("cross")

    private val type: Type by inject()

    init {
        with(root) {
            if(type.gameType == GameType.AI_VS_PLAYER) {
                crossSplit.children.clear()
            }
        }
    }

    fun handleBack() {
        replaceWith(MainMenuView::class)
    }
}