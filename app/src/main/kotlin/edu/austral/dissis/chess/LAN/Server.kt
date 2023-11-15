package edu.austral.dissis.chess.LAN

import edu.austral.dissis.LAN.server.GameServerManager
import edu.austral.dissis.checkers.CheckersGameEngine
import javafx.application.Application
import javafx.stage.Stage

fun main() {
    Application.launch(ServerApplication::class.java)
}

class ServerApplication : Application() {
    private val gameEngine = CheckersGameEngine()

    override fun start(primaryStage: Stage) {
        GameServerManager(gameEngine)
    }
}