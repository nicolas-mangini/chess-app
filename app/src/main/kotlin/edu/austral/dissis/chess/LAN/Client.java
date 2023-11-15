/*
import edu.austral.dissis.LAN.client.ClientManager;
import edu.austral.dissis.chess.gui.CachedImageResolver;
import edu.austral.dissis.chess.gui.DefaultImageResolver;
import edu.austral.dissis.chess.gui.GameView;
import edu.austral.dissis.chess.gui.ImageResolver;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Client extends Application {

    private final ImageResolver imageResolver = new CachedImageResolver(new DefaultImageResolver());

    public static final String GameTitle = "Chess";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(GameTitle);
        GameView root = new GameView(imageResolver); // You may need to adapt this line based on your actual classes
        new ClientManager(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
*/
