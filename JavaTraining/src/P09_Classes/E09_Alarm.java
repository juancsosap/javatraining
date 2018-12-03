package P09_Classes;

import java.util.HashSet;
import java.util.Set;

public class E09_Alarm {

	public static void main(String[] args) {
		
		Alarm a1 = new Alarm();
		
		ContinuousSensor s1 = new ContinuousSensor("S1", a1, 0, 20, 10);
		ContinuousSensor s2 = new ContinuousSensor("S2", a1, 3, 10, -5);
		
		System.out.println(s1.getValue());
		System.out.println(s1.getState());
		s1.setValue(15);
		System.out.println(s1.getState());
		s1.setValue(30);
		System.out.println(s1.getState());
		
		System.out.println(s2.getValue());
		System.out.println(s2.getState());
		s2.setValue(15);
		System.out.println(s2.getState());
		s2.setValue(-30);
		System.out.println(s2.getState());
		
		DiscreteSensor s3 = new DiscreteSensor("S3", a1, true);
		s3.setValue(false);
		
	}
	
	public static enum SensorState { UP, NORMAL, DOWN }
	
	public static abstract class Sensor {
		
		protected SensorState state;
		protected Alarm alarm;
		protected String name;
		
		protected void registerAlarm(Alarm alarm) {
			this.alarm = alarm;
			this.alarm.register(this);
		}
		
		public String toString() {
			return this.name;
		}
		
		public SensorState getState() {
			return this.state;
		}
		
	}
	
	
	public static class ContinuousSensor extends Sensor {
		
		private final double HIGH;
		private final double LOW;
		private double value;
		
		public ContinuousSensor(String name, Alarm alarm, double value, double high, double low) {
			this.name = name;
			this.HIGH = high;
			this.LOW = low;
			registerAlarm(alarm);
			setValue(value);
		}
		
		public void setValue(double value) {
			this.value = value;
			setState(value);
			this.alarm.inform();
		}
		
		private void setState(double value) {
			if(value >= HIGH) this.state = SensorState.UP;
			else if(value <= LOW) this.state = SensorState.DOWN;
			else this.state = SensorState.NORMAL;
		}
		
		public double getValue() {
			return this.value;
		}
		
	}
	
	public static class DiscreteSensor extends Sensor {
		
		private boolean value;
		
		public DiscreteSensor(String name, Alarm alarm, boolean value) {
			this.name = name;
			registerAlarm(alarm);
			setValue(value);
		}
		
		public void setValue(boolean value) {
			this.value = value;
			setState(value);
			this.alarm.inform();
		}
		
		private void setState(boolean value) {
			if(value) this.state = SensorState.UP;
			else this.state = SensorState.NORMAL;
		}
		
		public boolean getValue() {
			return this.value;
		}
		
	}
	
	public static class Alarm {
		
		private Set<Sensor> sensors = new HashSet<>();
		
		public void register(Sensor sensor) {
			sensors.add(sensor);
		}

		public void unregister(Sensor sensor) {
			sensors.remove(sensor);
		}
		
		public void inform() {
			for(Sensor s : sensors) {
				if(!(s.getState() == SensorState.NORMAL)) {
					System.out.println(s + " - ALAAAAAAARMA");
				}
			}
		}
		
		
	}

}

