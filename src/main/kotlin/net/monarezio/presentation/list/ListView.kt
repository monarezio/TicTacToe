package net.monarezio.presentation.list

import javafx.collections.FXCollections
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.text.Font
import net.monarezio.domain.ai.models.AiItems
import net.monarezio.domain.game.models.type.GameType
import net.monarezio.domain.game.models.type.Type
import net.monarezio.presentation.game.GameController
import net.monarezio.presentation.game.GameView
import net.monarezio.presentation.mainMenu.MainMenuView
import tornadofx.*

/**
 * Created by monarezio on 06/06/2017.
 */
class ListView: View() {
    override val root: AnchorPane by fxml("/resources/fxml/list.fxml")

    private val controller: ListViewController by inject<ListViewController>()

    private val crossSplit: AnchorPane by fxid("cross")
    private val listCross: ListView<String> by fxid("listCross")
    private val listCircle: ListView<String> by fxid("listCircle")
    private val continueButton: Button by fxid("continueButton")

    private val type: Type by inject()

    init {
        with(root) {
            val items = FXCollections.observableArrayList(controller.getAvailableAis())
            if(type.gameType == GameType.AI_VS_PLAYER) {
                crossSplit.children.clear()
                crossSplit += Label("Player").apply {
                    this.styleClass.add("player_label")
                    this.alignment = Pos.CENTER
                    AnchorPane.setLeftAnchor(this, 0.0)
                    AnchorPane.setRightAnchor(this, 0.0)
                    AnchorPane.setTopAnchor(this, 0.0)
                    AnchorPane.setBottomAnchor(this, 0.0)
                }
                listCircle.items = items
            } else {
                listCircle.items = items
                listCross.items = items
            }
        }
    }

    fun handleBack() {
        replaceWith(MainMenuView::class)
    }

    fun handleContinue() {
        val cross = if(type.gameType == GameType.AI_VS_AI) controller.getAiByName(listCross.selectionModel.selectedItem) else null
        val circle = controller.getAiByName(listCircle.selectionModel.selectedItem)
        val aiItems = AiItems(cross, circle)
        val scope = Scope()
        setInScope(aiItems, scope)

        this += find<GameView>(scope)
    }

    fun handleCircle(event: MouseEvent) {
        toggleContinue()
    }

    fun handleCross(event: MouseEvent) {
        toggleContinue()
    }

    private fun toggleContinue() {
        continueButton.isDisable = (type.gameType  == GameType.AI_VS_AI && !(listCircle.selectionModel.selectedItem is String && listCross.selectionModel.selectedItem is String) ||
                (type.gameType  == GameType.AI_VS_PLAYER && !(listCircle.selectionModel.selectedItem is String)))
    }
}