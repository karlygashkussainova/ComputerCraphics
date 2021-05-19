package lectureMaterials;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample2 extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Menus Example");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);

		MenuBar menuBar = new MenuBar();
		MenuItem newMenuItem = new MenuItem("New");
		MenuItem saveMenuItem = new MenuItem("Save");
		saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));

		MenuItem exitMenuItem = new MenuItem("E_xit");
		exitMenuItem.setMnemonicParsing(true);
		exitMenuItem.setOnAction(e -> Platform.exit());

		Menu fileMenu = new Menu("_File");
		fileMenu.setMnemonicParsing(true);

		fileMenu.getItems().addAll(
				newMenuItem,
				saveMenuItem,
				new SeparatorMenuItem(),
				exitMenuItem
		);

		menuBar.getMenus().add(fileMenu);
		root.setTop(menuBar);

		stage.setScene(scene);
		stage.setTitle("App with Menus");
		stage.show();
	}

}

