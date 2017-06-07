package net.monarezio.presentation.mainMenu

import javafx.scene.layout.AnchorPane
import net.monarezio.domain.ai.RandomAi
import net.monarezio.domain.ai.models.AiItems
import net.monarezio.domain.game.models.type.GameType
import net.monarezio.domain.game.models.type.Type
import net.monarezio.presentation.game.GameView
import net.monarezio.presentation.list.ListView
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
        val aiItems = AiItems(null, null)
        val scope = Scope()
        setInScope(aiItems, scope)

        this += find<GameView>(scope)
    }

    fun handleHumanVsAi() {
        val gameType = Type(GameType.AI_VS_PLAYER)
        val scope = Scope()
        setInScope(gameType, scope)

        this += find<ListView>(scope)
    }

    fun handleAiVsAi() {
        val gameType = Type(GameType.AI_VS_AI)
        val scope = Scope()
        setInScope(gameType, scope)

        this += find<ListView>(scope)
    }
}
