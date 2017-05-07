package net.monarezio.presentation.game

import javafx.scene.layout.AnchorPane
import net.monarezio.domain.Game
import net.monarezio.domain.models.Board
import net.monarezio.presentation.custom.ClickListener
import net.monarezio.presentation.custom.GameGrid
import net.monarezio.presentation.mainMenu.MainMenuView
import tornadofx.*

/**
 * Created by monarezio on 06/05/2017.
 */
class GameView : View(), ClickListener {
    override val root: AnchorPane by fxml("/resources/fxml/game.fxml")
    val controller: GameController by inject()

    val gridPane: GameGrid by fxid()

    init {
        gridPane.clickListener = this
        render()
    }

    override fun onClicked(x: Int, y: Int) {
        controller.onMoveMade(x, y)
        render()
    }

    fun render() {
        gridPane.setGameBoard(controller.getBoard())
    }

    fun handleBack() {
        replaceWith(MainMenuView::class)
    }
}
