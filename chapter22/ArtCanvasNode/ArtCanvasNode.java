package ArtCanvasNode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArtCanvasNode extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ArtCanvasNode.fxml"));
        primaryStage.setTitle("Canvas");
        primaryStage.setScene(new Scene(root, 500, 505));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



