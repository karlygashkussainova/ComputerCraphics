package dgmjcj.chapter6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample1 extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Menus Example");

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);

		MenuBar menuBar = new MenuBar();

		MenuItem exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setOnAction(e -> Platform.exit());

		Menu fileMenu = new Menu("File");
		fileMenu.getItems().add(exitMenuItem);

		menuBar.getMenus().add(fileMenu);

		root.setTop(menuBar);

		stage.setScene(scene);
		stage.setTitle("App with Menus");
		stage.show();
	}

}

