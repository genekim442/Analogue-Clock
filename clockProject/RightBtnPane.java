package clockProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class RightBtnPane extends VBox {

	public RightBtnPane() {
		this.setPrefWidth(120);
		VBox rightvBox = new VBox(0);
		rightvBox.setPadding(new Insets(0, 0, 0, 0));
		rightvBox.setAlignment(Pos.CENTER_RIGHT);
		getButtons(rightvBox);

		this.setAlignment(Pos.CENTER_RIGHT);
		this.getChildren().add(rightvBox);

	}

	public void getButtons(VBox rightvBox) {
		Button london = new Button("        London      ");
		Button tokyo = new Button("         Tokyo       ");
		Button berlin = new Button("         Berlin        ");
		Button moscow = new Button("        Moscow     ");
		london.setOnAction(x -> {
			JavaClock.location = "London";
			JavaClock.timeZone = +5;
			new ClockHands();
		});

		tokyo.setOnAction(x -> {
			JavaClock.location = "Tokyo";
			JavaClock.timeZone = +14;
			new ClockHands();
		});

		berlin.setOnAction(x -> {
			JavaClock.location = "Berlin";
			JavaClock.timeZone = +6;
			new ClockHands();
		});

		moscow.setOnAction(x -> {
			JavaClock.location = "Moscow";
			JavaClock.timeZone = +8;
			new ClockHands();
		});

		rightvBox.getChildren().addAll(london, tokyo, berlin, moscow);
	}
}
