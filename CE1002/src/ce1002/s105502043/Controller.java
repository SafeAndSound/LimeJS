package a5.s105502043;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    private ImageView buttonImage;
    @FXML
    private Button switchButton;
    private int angle = 0;
    private int direction = 1;

    @FXML
    private void initialize() {
        buttonImage.setImage ( new Image ("file:image/player.png") );
        switchButton.setOnAction ( new EventHandler<ActionEvent> () {
            @Override
            public void handle ( ActionEvent event ) {
            	 Controller.this.direction = (Controller.this.direction * -1);
            }
        } );
    }
    public void setScene(Scene scene){
        scene.setOnKeyPressed ( new EventHandler<KeyEvent> () {
            @Override
            public void handle ( KeyEvent event ) {
                if(event.getCode() == KeyCode.UP) {
                    buttonImage.setTranslateY ( buttonImage.getTranslateY () - 10 );
                }
                else if (event.getCode() == KeyCode.DOWN)
                {
                  Controller.this.buttonImage.setTranslateY(Controller.this.buttonImage.getTranslateY() + 10.0D);
                }
                else if (event.getCode() == KeyCode.LEFT)
                {
                  Controller.this.buttonImage.setTranslateX(Controller.this.buttonImage.getTranslateX() - 10.0D);
                }
                else if (event.getCode() == KeyCode.RIGHT)
                {
                  Controller.this.buttonImage.setTranslateX(Controller.this.buttonImage.getTranslateX() + 10.0D);
                }
                else if (event.getCode() == KeyCode.X)
                {
                  Controller.this.angle = (Controller.this.angle + 10 * Controller.this.direction);
                  Controller.this.buttonImage.setRotate(Controller.this.angle);
                  if (Controller.this.angle == 360) {
                    Controller.this.angle = 0;
                  }
                }
            }
        } );
    }
}
