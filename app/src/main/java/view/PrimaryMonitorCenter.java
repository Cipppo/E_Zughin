package view;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class PrimaryMonitorCenter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label label = new Label("Hello world!");
		Scene scene = new Scene(label, 600, 200);
		
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * 0.5;
		double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.5;
		
		primaryStage.setScene(scene);
		primaryStage.setX(x);
		primaryStage.setY(y);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

	
}
