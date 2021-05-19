package lectureMaterials;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuExample4 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Menu Example");
        primaryStage.setScene(new Scene(root, 300, 275));
        MenuBar menuBar = new MenuBar();

        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit() );

        fileMenu.getItems().addAll(
                newMenuItem,
                saveMenuItem,
                new SeparatorMenuItem(),
                exitMenuItem
        );

        // Cameras menu - camera 1, camera 2
        Menu cameraMenu = new Menu("Cameras");
        CheckMenuItem cam1MenuItem = new CheckMenuItem("Show Camera 1");
        cam1MenuItem.setSelected(true);
        cameraMenu.getItems().add(cam1MenuItem);

        CheckMenuItem cam2MenuItem = new CheckMenuItem("Show Camera 2");
        cam2MenuItem.setSelected(true);
        cameraMenu.getItems().add(cam2MenuItem);

        // Alarm Menu
        Menu alarmMenu = new Menu("Alarm");

        // sound or turn alarm off
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem soundAlarmItem = new RadioMenuItem("Sound Alarm");
        soundAlarmItem.setToggleGroup(tGroup);
        RadioMenuItem stopAlarmItem = new RadioMenuItem("Alarm Off");
        stopAlarmItem.setToggleGroup(tGroup);
        stopAlarmItem.setSelected(true);

        alarmMenu.getItems().addAll(
                soundAlarmItem,
                stopAlarmItem,
                new SeparatorMenuItem()
        );

        // Contingencey Menu options
        Menu contingencyPlans = new Menu("Contingent Plans");
        contingencyPlans.getItems().addAll(
                new CheckMenuItem("Self Destruct in T minus 50"),
                new CheckMenuItem("Turn off the coffee machine "),
                new CheckMenuItem("Run for your lives! "));
        alarmMenu.getItems().add(contingencyPlans);

        menuBar.getMenus().addAll(fileMenu, cameraMenu, alarmMenu);

        root.setTop(menuBar);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
