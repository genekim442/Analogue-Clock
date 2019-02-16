package clockProject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class JavaClock extends Application {

	static BorderPane borderPane;
	static boolean onPause = false;
	static String location = "New York";
	static int timeZone = 0;

	public void start(Stage primaryStage) {
		new SetClock();
		ClockHands clock = new ClockHands();
		BottomBtnPane timeNumPane = new BottomBtnPane();
		borderPane = new BorderPane();
		updateClock();

		EventHandler<ActionEvent> eventHandler = e -> {
			if (JavaClock.onPause == false) {
				clock.tick();
				updateClock();
			}

		};

		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

		Scene scene = new Scene(borderPane, 600, 360);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void updateClock() {
		borderPane.getChildren().clear();
		borderPane.setTop(new TopBtnPane());
		borderPane.setLeft(new LeftBtnPane());
		borderPane.setRight(new RightBtnPane());
		borderPane.setCenter(new ClockHands());
		borderPane.setBottom(new BottomBtnPane());

	}

	public static void main(String[] args) {
		launch(args);
	}
}
