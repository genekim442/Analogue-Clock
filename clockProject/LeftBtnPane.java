package clockProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class LeftBtnPane extends VBox {

	public LeftBtnPane() {
		this.setPrefWidth(120);
		VBox leftvBox = new VBox(0);
		leftvBox.setPadding(new Insets(0, 0, 0, 0));
		leftvBox.setAlignment(Pos.CENTER_LEFT);
		getButtons(leftvBox);

		this.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().add(leftvBox);

	}

	public void getButtons(VBox leftvBox) {
		Button newYork = new Button("     New York     ");
		Button dallas = new Button("        Dallas        ");
		Button denver = new Button("       Denver       ");
		Button losAngeles = new Button("   Los Angeles   ");
		newYork.setOnAction(x -> {
			JavaClock.location = "New York";
			JavaClock.timeZone = 0;
			new ClockHands();

		});

		dallas.setOnAction(x -> {
			JavaClock.location = "Dallas";
			JavaClock.timeZone = -1;
			new ClockHands();

		});

		denver.setOnAction(x -> {
			JavaClock.location = "Denver";
			JavaClock.timeZone = -2;
			new ClockHands();
		});

		losAngeles.setOnAction(x -> {
			JavaClock.location = "Los Angeles";
			JavaClock.timeZone = -3;
			new ClockHands();
		});

		leftvBox.getChildren().addAll(newYork, dallas, denver, losAngeles);
	}
}
