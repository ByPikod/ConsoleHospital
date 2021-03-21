import java.util.Scanner;

public class Utils {
	private Scanner input = new Scanner(System.in);
	
	public int getInteger() {
		int ret;
		while(true) {
			String line = input.nextLine();
			try {
				ret = Integer.valueOf(line);
				break;
			}catch(Exception e) {
				System.out.println("> Lütfen geçerli bir sayý giriniz!");
				continue;
			}
		}
		return ret;
	}
	
	public long getLong() {
		long ret;
		while(true) {
			String line = input.nextLine();
			try {
				ret = Long.valueOf(line);
				break;
			}catch(Exception e) {
				System.out.println("> Lütfen geçerli bir sayý giriniz!");
				continue;
			}
		}
		return ret;
	}
	
	public int openMenu(String... args) {
		System.out.println("----------------------------------");
		for(int i = 0; i < args.length; i++) {
			System.out.println("("+(i+1)+") "+args[i]);
		}
		System.out.println("----------------------------------");
		return getInteger();
	}
	
	public String getString() {
		String line = input.nextLine();
		return line;
	}
}
