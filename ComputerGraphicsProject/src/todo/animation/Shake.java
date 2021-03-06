package todo.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {

    private TranslateTransition translateTransition;

    public Shake(Node node) {
        translateTransition = new TranslateTransition(Duration.millis(100), node);
        translateTransition.setFromX(0f);
        //translateTransition.setFromY(0f);

        translateTransition.setByX(10f);
        //translateTransition.setByY(20f);
        translateTransition.setCycleCount(3);
        translateTransition.setAutoReverse(true);
    }

    public void playAnimation(){
        translateTransition.playFromStart();
    }


}
