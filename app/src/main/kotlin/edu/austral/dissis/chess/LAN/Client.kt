package edu.austral.dissis.chess.LAN

import edu.austral.dissis.common.LAN.client.ClientManager
import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.GameView
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

fun main() {
    Application.launch(Client::class.java)
}

class Client : Application() {
    private val imageResolver = CachedImageResolver(DefaultImageResolver())

    companion object {
        const val GameTitle = "Chess"
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = GameTitle
        val root = GameView(imageResolver)
        ClientManager(root, 8082)
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }
}