package net.monarezio.presentation.game

import javafx.scene.control.Button
import javafx.scene.layout.AnchorPane
import net.monarezio.domain.game.models.Field
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

    private val backwordsButton: Button by fxid("backwordsButton")
    private val playButton: Button by fxid("playButton")
    private val forwardsButton: Button by fxid("forwardsButton")

    init {
        gridPane.clickListener = this
        render()
        if(!controller.isAiVsAi()) {
            backwordsButton.hide()
            playButton.hide()
            forwardsButton.hide()
        }
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

    fun handlePlay() {
        controller.play()
        render()
    }

    fun handleForward() {
        controller.makeOneMove()
        render()
    }

    fun handleBackwords() {
        //TODO: implement
    }
}
