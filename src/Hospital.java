import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	Utils utils;
	Database db;
	
	Citizen session;
	List<Appointment> appointments = new ArrayList<Appointment>();
	
	public static void main(String arg[]) {
		new Hospital("Federal Hastenesi"); // Start hospital system
	}
	
	public Hospital(String hastaneismi) { // Begin
		System.out.println(hastaneismi+" hoþgeldiniz!");
		
		utils = new Utils();
		db = new Database(this);
		
		while(true){
			if(session != null) { // If user logged in
				System.out.println("Hoþgeldiniz, "+session.getName()+" "+session.getSurname()+"!");
				if(session.isPersonal()) System.out.println("> Personel modu açýk!");
				
				while(session != null) {
					int in;
					if(session.isPersonal()) { // We checking user is personal for menu options.
						in = utils.openMenu("Çýkýþ Yap", "Randevu Al", "Çalýþma Saatleri", "Randevularý Gör (Personel Özel)");
					}else {
						in = utils.openMenu("Çýkýþ Yap", "Randevu Al", "Çalýþma Saatleri");
					}
					
					switch(in) {
						case 1: // Log out
							session = null;
							System.out.println("Çýkýþ yapýyorsunuz...");
							break;
						case 2: // Get appointment
							
							System.out.println("> Lütfen randevu sebebiyle ilgili bilgi verin.");
							String description = utils.getString();
							
							Appointment last;
							if(appointments.size() == 0) {
								last = new Appointment(null, null, 0, 0); // If never define any appointment
							}else {
								last = appointments.get(appointments.size()-1); // Getting last element of appointment list for calculate next appointment's time.
							}
							
							
							int day = last.day;
							int time = last.whichTime + 1;
							
							if(last.whichTime == 8) { // Next day
								time = 1;
								day = last.day + 1;
							}
							
							Appointment date = new Appointment(session, description, day, time); // Create appoitment
							appointments.add(date); // Add Appointment
							
							System.out.println("Baþarýlý, "+day+" gün sonra saat "+date.getTimeAsString() + " için randevu alýndý!");
							break;
						case 3: // Work hours
							System.out.println("Çalýþma saatlerimiz 09:00 - 16:00 þeklindedir.");
							break;
						case 4: // See dates
							if(!session.isPersonal()) {
								System.out.println("Lütfen, üç ila bir arasýnda bir rakam giriniz!");
								break;
							}
							System.out.println("Randevular: ");
							for(Appointment appointment : appointments) {
								System.out.println(appointment.citizen.getName()+" "+appointment.citizen.getSurname()+" adlý kiþinin "+appointment.day+" gün sonra saat "+appointment.getTimeAsString()+" için randevusu var: "+appointment.desciption);
							}
							break;
						default:
							if(session.isPersonal()) {
								System.out.println("Lütfen, dört ila bir arasýnda bir rakam giriniz!");
							}else {
								System.out.println("Lütfen, üç ila bir arasýnda bir rakam giriniz!");
							}
							break;
					}
				}
			}
			
			// Login
			System.out.println("> Lütfen TC kimlik numaranýzý yazýn.");
			long tc = utils.getLong();

			System.out.println("> Lütfen tam adýnýzý yazýn.");
			String name = utils.getString();
			
			System.out.println("> Lütfen soyadýnýzý yazýn.");
			String surname = utils.getString();
			
			Citizen c = db.getCitizen(tc, name, surname);
			if(c == null) {
				System.out.println("Bilgiler hatalý, lütfen tekrar deneyin.");
				continue;
			}
			session = c;
		}
	}
	
}
