package edu.austral.dissis.chess.LAN

import edu.austral.dissis.common.LAN.server.ServerManager
import edu.austral.dissis.checkers.CheckersGameEngine
import edu.austral.dissis.chess.ChessGameEngine
import javafx.application.Application
import javafx.stage.Stage

fun main() {
    Application.launch(ServerApplication::class.java)
}

class ServerApplication : Application() {
    private val gameEngine = ChessGameEngine()
    //private val gameEngine = CheckersGameEngine()

    override fun start(primaryStage: Stage) {
        ServerManager(gameEngine)
    }
}