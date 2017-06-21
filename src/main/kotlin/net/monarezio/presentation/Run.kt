package net.monarezio.presentation

import javafx.application.Application
import javafx.scene.text.Font
import javafx.stage.Stage
import net.monarezio.presentation.mainMenu.MainMenuView
import tornadofx.*

/**
 * Created by monarezio on 06/05/2017.
 */
class Run: App(MainMenuView::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isResizable = false
    }

    init {
        Font.loadFont(Run::class.java.getResource("/resources/fonts/TicTacToe.ttf").toExternalForm(), 10.0)
        Font.loadFont(Run::class.java.getResource("/resources/fonts/super-webcomic-bros.regular.ttf").toExternalForm(), 10.0).name
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Run::class.java, *args)
        }
    }
}