package clockProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

class BottomBtnPane extends HBox {
	TextField hourText;
	TextField minuteText;
	TextField secondText;

	public BottomBtnPane() {
		this.setPrefWidth(20);
		HBox hBox = new HBox(0);
		hBox.setPadding(new Insets(0, 0, 0, 0));
		hBox.setAlignment(Pos.CENTER);

		hourText = new TextField(ClockHands.hour + "");
		hourText.setEditable(true);
		hourText.setPrefWidth(50);
		minuteText = new TextField(ClockHands.minute + "");
		minuteText.setEditable(true);
		minuteText.setPrefWidth(50);
		secondText = new TextField(ClockHands.second + "");
		secondText.setEditable(true);
		secondText.setPrefWidth(50);
		hBox.getChildren().addAll(new Label("Hour"), hourText, new Label("Minute"), minuteText, new Label("Second"),
				secondText);
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(hBox);
		hourText.setOnAction(x -> {
			ClockHands.rawHour = Integer.parseInt(this.hourText.getText()) % 12;

			JavaClock.updateClock();
		});

		minuteText.setOnAction(x -> {
			ClockHands.minute = Integer.parseInt(this.minuteText.getText()) % 60;

			JavaClock.updateClock();

		});

		secondText.setOnAction(x -> {
			ClockHands.second = Integer.parseInt(this.secondText.getText()) % 60;

			JavaClock.updateClock();

		});

	}
}
