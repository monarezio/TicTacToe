package net.monarezio.presentation.custom

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.*
import javafx.scene.text.Font
import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Field
import tornadofx.*

/**
 * Created by monarezio on 06/05/2017.
 */
class GameGrid: VBox() {
    var clickListener: ClickListener? = null

    fun setGameBoard(board: Board) {
        children.clear()
        val size = this.prefWidth / (board.getColumns() - 1)

        with(this) {
            for(i in 0..board.getRows() - 1) {
                this += HBox().apply {
                    for(j in 0..board.getColumns() - 1) {
                        this += Label().apply {
                            alignment = Pos.CENTER
                            this.prefHeight = size
                            this.prefWidth = size
                            this.setOnMouseClicked { clickListener!!.onClicked(i, j) }
                            this.font = Font(size - 5)

                            val field = board.getFields()[i][j]

                            if(field == Field.CROSS) {
                                this.text = "X"
                                this.styleClass.add("x")
                            } else if (field == Field.CIRCLE) {
                                this.text = "O"
                                this.styleClass.add("o")
                            }
                        }
                    }
                }
            }
        }
    }

    init {
        stylesheets.add("/resources/styles/game-grid.css")
    }

}