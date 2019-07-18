package Clock;

public class Time {
	private long days = 0, hours = 0, minutes = 0, seconds = 0, miliseconds = 0;
	
	public Time(long days, long hours, long minutes, long seconds, long miliseconds) {
		this.setDays(days);
		this.setHours(hours);
		this.setMinutes(minutes);
		this.setSeconds(seconds);
		this.setMiliseconds(miliseconds);			
	}
	public Time(long miliseconds) { this(0, 0, 0, 0, miliseconds); }
	public Time() { this(0,0,0,0,0); }

	public long getDays() {
		return days;
	}

	public void setDays(long days) throws IllegalArgumentException {
		if(days >= 0) {
			this.days = days;
		} else {
			throw new IllegalArgumentException("Days value could not be negative");
		}
	}

	public long getHours() {
		return hours;
	}
	
	public long getTotalHours() {
		return hours + days * 24;
	}

	public void setHours(long hours) throws IllegalArgumentException {
		if(hours >= 0) {
			this.hours = hours % 24;
			this.setDays(hours / 24);
		} else {
			throw new IllegalArgumentException("Hours value could not be negative");
		}
	}

	public long getMinutes() {
		return minutes;
	}
	
	public long getTotalMinutes() {
		return minutes + getTotalHours() * 60;
	}

	public void setMinutes(long minutes) throws IllegalArgumentException {
		if(minutes >= 0) {
			this.minutes = minutes % 60;
			this.setHours(minutes / 60);
		} else {
			throw new IllegalArgumentException("Minutes value could not be negative");
		}
	}

	public long getSeconds() {
		return seconds;
	}

	public long getTotalSeconds() {
		return seconds + getTotalMinutes() * 60;
	}
	
	public void setSeconds(long seconds) throws IllegalArgumentException {
		if(seconds >= 0) {
			this.seconds = seconds % 60;
			this.setMinutes(seconds / 60);
		} else {
			throw new IllegalArgumentException("Seconds value could not be negative");
		}
	}

	public long getMiliseconds() {
		return miliseconds;
	}
	
	public long getTotalMiliseconds() {
		return miliseconds + getTotalSeconds() * 1000;
	}

	public void setMiliseconds(long miliseconds) throws IllegalArgumentException {
		if(miliseconds >= 0) {
			this.miliseconds = miliseconds % 1000;
			this.setSeconds(miliseconds / 1000);
		} else {
			throw new IllegalArgumentException("Miliseconds value could not be negative");
		}
	}
	
}
