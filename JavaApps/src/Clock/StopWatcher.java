package Clock;

import java.text.DecimalFormat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class StopWatcher {
	
	public interface Printable {
		public void print(String value);
	}

	private Time time;
	private Time deltaTime;
	
	private boolean reverse;
	
	private Printable dst;
	private Timeline timer;
	
	public StopWatcher(Printable dst, Time startTime, boolean reverse, Time deltaTime) {
		this.dst = dst;
		this.time = startTime;
		this.reverse = reverse;
		this.deltaTime = deltaTime;
		restartTimer();
		timer.setCycleCount(Animation.INDEFINITE);
		dst.print(getClock());
	}
	public StopWatcher(Printable dst, Time startTime, boolean reverse) { this(dst, startTime, reverse, new Time(1)); }
	public StopWatcher(Printable dst, Time startTime) { this(dst, startTime, false, new Time(1)); }
	public StopWatcher(Printable dst, int deltaTime) { this(dst, new Time(), false, new Time(deltaTime)); }
	public StopWatcher(Printable dst) { this(dst, new Time(), false, new Time(1)); }
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public void setDeltaTime(Time deltaTime) {
		this.deltaTime = deltaTime;
	}
	
	public void restartTimer() {
		timer = new Timeline(new KeyFrame(Duration.millis(deltaTime.getTotalMiliseconds()), ae -> { 
			next(); 
			dst.print(getClock()); 
		}));
	}
	
	public void start() {
		timer.play();
	}
	
	public void stop() {
		timer.stop();
		restartTimer();
		timer.setCycleCount(Animation.INDEFINITE);
		setTime(new Time());
	}
	
	public void pause() {
		timer.stop();
	}
	
	private String getClock() {
		DecimalFormat dfu = new DecimalFormat("000");
		DecimalFormat dfo = new DecimalFormat("00");
		String miliseconds = dfu.format(time.getMiliseconds());
		String seconds = dfo.format(time.getSeconds());
		String minutes = dfo.format(time.getMinutes());
		String hours = dfo.format(time.getHours());
		String days = dfo.format(time.getDays());
		String clock = days + ":" + hours + ":" + minutes + ":" + seconds + "." + miliseconds;
		return clock;
	}
	
	private void next() {
		long miliseconds;
		if(reverse) {
			miliseconds = time.getTotalMiliseconds() - deltaTime.getTotalMiliseconds();
			if(miliseconds <= 0) {
				miliseconds = 0;
				stop();
			}
		} else {
			miliseconds = time.getTotalMiliseconds() + deltaTime.getTotalMiliseconds();
		}
		time.setMiliseconds(miliseconds);
	}

}


