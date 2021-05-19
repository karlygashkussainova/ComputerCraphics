package lectureMaterials;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample3 extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Menus Example");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);

		MenuItem exitMenuItem = new MenuItem("E_xit");
		exitMenuItem.setMnemonicParsing(true);
		exitMenuItem.setOnAction(e -> Platform.exit());

		ContextMenu contextFileMenu = new ContextMenu(exitMenuItem);

		stage.addEventHandler(MouseEvent.MOUSE_CLICKED,
				(MouseEvent me) -> {
					if (me.getButton() == MouseButton.SECONDARY || me.isControlDown()) {
						contextFileMenu.show(root, me.getScreenX(), me.getScreenY());
					} else {
						contextFileMenu.hide();
					}
				});

		stage.setScene(scene);
		stage.setTitle("App with Menus");
		stage.show();
	}

}

