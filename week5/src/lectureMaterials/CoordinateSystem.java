package lectureMaterials;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CoordinateSystem extends Application {

	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;
	private static final int RECT_SQUARE = 100;

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFont(Font.font(12));
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		gc.setStroke(Color.LIGHTGRAY);

		for (int i = 0; i < WIDTH; i += RECT_SQUARE) {
			for (int j = 0; j < HEIGHT; j += RECT_SQUARE) {
				gc.strokeRect(i, j, RECT_SQUARE, RECT_SQUARE);
				gc.setFill(Color.WHITE);
				gc.fillText("x=" + i + ",y=" + j, i + 2, j + 12);
				gc.setFill(Color.RED);
				gc.fillOval(i - 4, j - 4, 8, 8);
			}
		}

		stage.setScene(new Scene(new StackPane(canvas), WIDTH, HEIGHT));
		stage.setTitle("Coordinate System demonstration");
		stage.show();
	}

}

