package AwtCanvasWrapper;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class AwtCanvasWrapper extends Application{
	private static final int W = 200;
	private static final int H = 200;
	
	public void start(final Stage stage) throws Exception{
		
		final AwtInitializerTask awtInitializerTask = new AwtInitializerTask(() -> {
			JPanel jPanel = new JPanel();
			jPanel.add(new CustomAwtCanvas(W,H));
		
			return jPanel;
			
			
		});
	
		SwingUtilities.invokeLater(awtInitializerTask);
	
		SwingNode swingnode = new SwingNode();
		swingnode.setContent(awtInitializerTask.get());
	
		stage.setScene(new Scene(new Group(swingnode),W,H));
		stage.setResizable(false);
		stage.show();
	}

	private class AwtInitializerTask extends FutureTask<JPanel>{
		public AwtInitializerTask(Callable<JPanel> callable){
			super(callable);
		}
	}
	
	private class CustomAwtCanvas extends Canvas{
		public CustomAwtCanvas (int width, int height){
			setSize(width,height);
		}
		public void paint (Graphics g){
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.setColor(Color.GRAY);
			g2.fillRect(
					0,0,
					(int) getSize().getWidth(), (int) getSize().getHeight()
				);
			g2.setColor(Color.BLACK);
			g2.drawString("Custom area",25,50);
			
		}
	}
	
	public static void main (String[] args){
		Application.launch(args);
	}
}