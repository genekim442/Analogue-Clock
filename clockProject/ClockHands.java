package clockProject;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;

class ClockHands extends Pane {
	static int rawHour;
	static int hour;
	static int minute;
	static int second;
	static final double centerX = 175;
	static final double centerY = 140;
	static final double clockRadius = 100;

	public ClockHands() {

		paintClock();
		paintLocation();
	}

	private void paintClock() {

		hour = rawHour + JavaClock.timeZone;
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		this.getChildren().addAll(circle);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 2, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 1, "6");
		getChildren().addAll(t1, t2, t3, t4);
		secondHand();
		minuteHand();
		hourHand();

	}

	private void secondHand() {

		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		this.getChildren().add(sLine);

	}

	private void minuteHand() {
		double mLength = clockRadius * 0.65;
		double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
		mLine.setStroke(Color.BLUE);
		this.getChildren().add(mLine);
	}

	private void hourHand() {
		hour = rawHour + JavaClock.timeZone;
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		this.getChildren().add(hLine);

	}

	private void paintLocation() {
		Text locationText = new Text(138, 265, JavaClock.location);
		locationText.setFont(Font.font(18));
		this.getChildren().add(locationText);

	}

	public void tick() {
		hour = rawHour + JavaClock.timeZone;
		if (JavaClock.onPause == false)
			this.second++;
		if (this.second >= 60) {
			this.second = 0;
			this.minute++;
		}

		if (this.minute >= 60) {
			this.minute = 0;
			this.hour++;
		}
		if (this.hour >= 13)
			this.hour %= 12;

	}
}