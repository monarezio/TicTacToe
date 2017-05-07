package net.monarezio.presentation.game

import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import net.monarezio.domain.Game
import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Field
import net.monarezio.presentation.custom.ClickListener
import net.monarezio.presentation.custom.GameGrid
import net.monarezio.presentation.game.win.Win
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
        val winner = controller.getWinner()
        gridPane.setGameBoard(controller.getBoard())
        if(winner.first != Field.ANON)
            gridPane.drawLine(winner.second)
    }

    fun handleBack() {
        replaceWith(MainMenuView::class)
    }

    fun handleReset() {
        controller.resetBoard()
        render()
    }
}
