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
		System.out.println(hastaneismi+" ho�geldiniz!");
		
		utils = new Utils();
		db = new Database(this);
		
		while(true){
			if(session != null) { // If user logged in
				System.out.println("Ho�geldiniz, "+session.getName()+" "+session.getSurname()+"!");
				if(session.isPersonal()) System.out.println("> Personel modu a��k!");
				
				while(session != null) {
					int in;
					if(session.isPersonal()) { // We checking user is personal for menu options.
						in = utils.openMenu("��k�� Yap", "Randevu Al", "�al��ma Saatleri", "Randevular� G�r (Personel �zel)");
					}else {
						in = utils.openMenu("��k�� Yap", "Randevu Al", "�al��ma Saatleri");
					}
					
					switch(in) {
						case 1: // Log out
							session = null;
							System.out.println("��k�� yap�yorsunuz...");
							break;
						case 2: // Get appointment
							
							System.out.println("> L�tfen randevu sebebiyle ilgili bilgi verin.");
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
							
							System.out.println("Ba�ar�l�, "+day+" g�n sonra saat "+date.getTimeAsString() + " i�in randevu al�nd�!");
							break;
						case 3: // Work hours
							System.out.println("�al��ma saatlerimiz 09:00 - 16:00 �eklindedir.");
							break;
						case 4: // See dates
							if(!session.isPersonal()) {
								System.out.println("L�tfen, �� ila bir aras�nda bir rakam giriniz!");
								break;
							}
							System.out.println("Randevular: ");
							for(Appointment appointment : appointments) {
								System.out.println(appointment.citizen.getName()+" "+appointment.citizen.getSurname()+" adl� ki�inin "+appointment.day+" g�n sonra saat "+appointment.getTimeAsString()+" i�in randevusu var: "+appointment.desciption);
							}
							break;
						default:
							if(session.isPersonal()) {
								System.out.println("L�tfen, d�rt ila bir aras�nda bir rakam giriniz!");
							}else {
								System.out.println("L�tfen, �� ila bir aras�nda bir rakam giriniz!");
							}
							break;
					}
				}
			}
			
			// Login
			System.out.println("> L�tfen TC kimlik numaran�z� yaz�n.");
			long tc = utils.getLong();

			System.out.println("> L�tfen tam ad�n�z� yaz�n.");
			String name = utils.getString();
			
			System.out.println("> L�tfen soyad�n�z� yaz�n.");
			String surname = utils.getString();
			
			Citizen c = db.getCitizen(tc, name, surname);
			if(c == null) {
				System.out.println("Bilgiler hatal�, l�tfen tekrar deneyin.");
				continue;
			}
			session = c;
		}
	}
	
}
