# TicTacToe
TicTacToe implementation in kotlin

## Todo
- [x] Presentation layer
- [x] Domain Layer
- [x] Ai interface
- [ ] Working ai

## Writing an custom ai

#### Step 1
Clone this git repository and set it up with gradle in intellij or any other preffered IDE 🙂

#### Step 2
In the package `net.monarezio.domain.ai` create a new class:

```kotlin
  class RandomAi {
    
  }
```

#### Step 3
implement the interface Ai
```kotlin
  class RandomAi : Ai {
      override fun nextCoordinates(game: AiTicTacToe): Coordinate
              = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
```

#### Step 4
Write your code
```kotlin
  class RandomAi : Ai {
      override fun nextCoordinates(game: AiTicTacToe): Coordinate {
          val board = game.getBoard().getFields()
          while (true) {
              val x = Int.random(0, board.size - 1)
              val y = Int.random(0, board[x].size - 1)
              if (board[x][y] == Field.ANON)
                  return Coordinate(x, y)
          }
      }
  }
```

#### Step 5
Build and run the project, in main menu choose one of the options with the Ai 🙂
