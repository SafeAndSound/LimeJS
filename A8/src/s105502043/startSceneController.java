package s105502043;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class startSceneController {
	@FXML
	private Button startBt;
	@FXML
	private Button closeBt;
	@FXML
	private ImageView background;
	
	@FXML
	private void initialize(){
		background.setImage(new Image("file:image/background.jpg"));
	}
	
	public void setScene(Scene startScene, Scene gameScene, Stage primaryStage){
		startBt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				primaryStage.setScene(gameScene);
			}
		});
		closeBt.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				
			}
			
		});
	}
}
