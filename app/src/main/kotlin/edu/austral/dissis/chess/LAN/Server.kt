package edu.austral.dissis.chess.LAN

import edu.austral.dissis.common.LAN.server.ServerManager
//import edu.austral.dissis.checkers.CheckersGameEngine
import edu.austral.dissis.common.game.GameEngine
import edu.austral.dissis.common.game.GameType
import javafx.application.Application
import javafx.stage.Stage

fun main() {
    Application.launch(ServerApplication::class.java)
}

class ServerApplication : Application() {
    private val gameEngine = GameEngine(GameType.CHECKERS)
    //private val gameEngine = CheckersGameEngine()

    override fun start(primaryStage: Stage) {
        ServerManager(gameEngine)
    }
}