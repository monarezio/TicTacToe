package net.monarezio.presentation.custom

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.scene.text.Font
import net.monarezio.domain.models.Board
import net.monarezio.domain.models.Coordinate
import net.monarezio.domain.models.Field
import tornadofx.*

/**
 * Created by monarezio on 06/05/2017.
 */
class GameGrid: Pane() {
    var clickListener: ClickListener? = null
    var size = 0.0

    fun setGameBoard(board: Board) {
        size = this.prefWidth / (board.getColumns() - 1)

        with(this) {
            this.children.clear()
            add(VBox().apply {
                for(i in 0..board.getRows() - 1) {
                    this += HBox().apply {
                        for(j in 0..board.getColumns() - 1) {
                            this += Label().apply {
                                alignment = Pos.CENTER
                                this.prefHeight = size
                                this.prefWidth = size
                                this.setOnMouseClicked { clickListener!!.onClicked(i, j) }
                                this.font = Font(size - 5)
                                this.onHover { this.font = Font(size - 5) }

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
            })
        }
    }

    fun drawLine(coord: List<Coordinate>) {
        with(this) {
            this += Line().apply {
                this.fill = Color.BLACK
                this.strokeWidth = 2.0
                this.startX = (coord[0].y + 1) * size - size / 4
                this.endX = (coord.last().y + 1) * size - size / 4
                this.startY = (coord[0].x + 1) * size - size / 4
                this.endY =  (coord.last().x + 1) * size - size / 4
                this.toFront() //TODO: Does bring fully to front
            }
        }
    }

    init {
        stylesheets.add("/resources/styles/game-grid.css")
    }

}