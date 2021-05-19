package TextShadow;

import javafx.application.Application;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.scene.text.Font;


public class TextShadow extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("ShadowText");
        VBox box = new VBox();
        Text text = new Text("Text With Shadow");
        text.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 100));
        text.setStyle("-fx-effect: dropshadow(two-pass-box,orangered,15.0,0.6,3.0,9.0);" + "-fx-fill: navajowhite");
        box.getChildren().add(text);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        Scene scene = new Scene(box, 900, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}