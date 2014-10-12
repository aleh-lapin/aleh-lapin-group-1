package jmp.module02.gc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class App 
{

	private static final String MESSAGE = "ENTER the nuber of testcase within the following range 1-7 and -1 for exit";

	public static void main( String[] args )
	{

		try {
			int testCaseNunber = -1;
			Scanner scn = new Scanner(System.in);
			System.out.println(MESSAGE);
			while(scn.hasNextLine()){
				String value = scn.nextLine();
				try{
					testCaseNunber = Integer.parseInt(value);
				} catch(NumberFormatException e){
					System.out.println(MESSAGE);
				}
				switch(testCaseNunber) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					CaseHolder holder = new CaseHolder();
					String parameters = holder.getParameters(testCaseNunber);
					System.out.println(parameters);
					Runtime runtime = Runtime.getRuntime();
					Process process = runtime.exec(parameters);
					BufferedInputStream stream = new BufferedInputStream(process.getInputStream());
					Scanner scanner = new Scanner(stream);

					while(scanner.hasNextLine()) {
						String nextLine = scanner.nextLine();
						System.out.println(nextLine);
					}
					break;
				case -1:
						System.exit(0);
				}
			}
		} catch (Exception e) {

		}
	}
}
