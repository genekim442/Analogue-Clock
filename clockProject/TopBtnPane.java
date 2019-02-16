package clockProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

class TopBtnPane extends HBox {

	public TopBtnPane() {
		this.setPrefWidth(20);
		HBox hBox = new HBox(0);
		hBox.setPadding(new Insets(0, 0, 0, 0));
		hBox.setAlignment(Pos.CENTER);

		getButtons(hBox);

		this.setAlignment(Pos.CENTER);
		this.getChildren().add(hBox);

	}

	public void getButtons(HBox hBox) {
		Button startBtn = new Button("Start");
		Button stopBtn = new Button("Stop");
		Button loadStartBtn = new Button("Load Current Time & Start");
		Button loadBtn = new Button("Just Load Current Time");
		startBtn.setOnAction(x -> {
			JavaClock.onPause = false;
		});
		stopBtn.setOnAction(x -> {
			JavaClock.onPause = true;
		});
		loadStartBtn.setOnAction(x -> {
			new SetClock();
			JavaClock.onPause = false;
		});
		loadBtn.setOnAction(x -> {
			new SetClock();
			JavaClock.onPause = true;
		});
		hBox.getChildren().addAll(startBtn, stopBtn, loadStartBtn, loadBtn);

	}

}
