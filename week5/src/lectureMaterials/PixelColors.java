package lectureMaterials;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PixelColors extends Application {

	private static final int WIDTH = 1200;
	private static final int HEIGHT = 1000;

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				gc.getPixelWriter().setColor(i, j, Color.color(Math.random(), Math.random(), Math.random()));
			}
		}

		stage.setScene(new Scene(new StackPane(canvas), WIDTH, HEIGHT));
		stage.setTitle("Random colors on all pixel");
		stage.show();
	}

}

