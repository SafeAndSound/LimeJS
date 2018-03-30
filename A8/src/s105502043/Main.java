package s105502043;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller ();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hello World");
        Scene gameScene = new Scene ( root, 963, 577 );
        controller.setScene ( gameScene );
        
        FXMLLoader startLoader = new FXMLLoader(getClass().getResource("startScene.fxml"));
        startSceneController startController = new startSceneController();
        startLoader.setController(startController);
        Scene startScene = new Scene ((Parent)startLoader.load(), 963 ,577);
        startController.setScene(startScene, gameScene, primaryStage);
        primaryStage.setScene(startScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
