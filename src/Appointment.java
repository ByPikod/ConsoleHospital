
public class Appointment {
	public int day = 0;
	public int whichTime  = 1; // 1 = 9pm, 2 = 10pm, 3 = 11pm, 4 = 12pm, 5 = 1am, 6 = 2am, 7 = 3am, 8 = 4am
	public Citizen citizen;
	public String desciption;
	
	public Appointment(Citizen c, String description, int day, int whichTime) {
		this.citizen = c;
		this.desciption = description;
		this.day = day;
		this.whichTime = whichTime;
	}
	
	public String getTimeAsString() {
		switch(whichTime) {
			case 1:
				return "09:00";
			case 2:
				return "10:00";
			case 3:
				return "11:00";
			case 4:
				return "12:00";
			case 5:
				return "13:00";
			case 6:
				return "14:00";
			case 7:
				return "15:00";
			case 8:
				return "16:00";
		}
		return "Bilinmeyen Zaman";
	}
}
