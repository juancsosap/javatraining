package P09_Classes;

public class E07_EnumMonth {

	public static void main(String[] args) {
		
		System.out.println(Month.JANUARY + " : " + Month.JANUARY.getName() + " : " + Month.JANUARY.ordinal());
		System.out.println(Day.SUNDAY + " : " + Day.SUNDAY.ordinal());
		
		for(Day day : Day.values()) {
			System.out.print(day + " ");
		}
		
	}
	
	private enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
	
	private enum Month {
		
		JANUARY("Enero"),
		FEBRUARY("Febrero"),
		MARCH("Marzo"),
		APRIL("Abril"),
		MAY("Mayo"),
		JUNE("Junio"),
		JULY("Julio"),
		AUGUST("Agosto"),
		SEPTEMBER("Septiembre"),
		OCTOBER("Octubre"),
		NOVEMBER("Noviembre"),
		DECEMBER("Diciembre");
		
		private String name;
		
		private Month(String spanish_name) {
			this.name = spanish_name;
		}
		
		public String getName() {
			return name;
		}
		
	}

}
