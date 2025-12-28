package random;

import java.io.*;
import java.util.*;

public class DECA {

	public static void main(String[] args) {
		String file = "Deca Writtens Submissions";
		String provsFile = "Deca Provs";
		String fullProvsFile = "Full Provs";
		String findEvent = "IMCS";
		String line = null;
		String [] list = new String[200];
		String [] fullList = new String[200];
		int woss = 0;
		int eventCount = 0;
		int provEvCount = 0;
		int wossers = 0;
		int count = 0;

		// Paper Submissions
		try {
			Scanner input = new Scanner(new File(file));

			while (input.hasNext()) {
				line = input.nextLine();
				if (line.substring(0,line.indexOf(" ")).equals("White")) {
					woss += 1;
				}
				if (line.contains(findEvent)) {
					eventCount += 1;
				}

			}

		} catch (FileNotFoundException e) {
			System.out.print("File not Found.");
			System.exit(0);
		}

		// Final Provs
		try {
			Scanner input = new Scanner(new File(provsFile));

			while (input.hasNext()) {
				line = input.nextLine();

				for (int i = 0; i < 3; i++) {
					line = line.substring(line.indexOf(" ") + 1,line.length());
				}

				list[count] = line;

				count += 1;
				wossers += 1;

			}

		} catch (FileNotFoundException e) {
			System.out.print("File not Found.");
			System.exit(0);
		}

		count = 0;
		
		// Full Provs
		try {
			Scanner input = new Scanner(new File(fullProvsFile));

			while (input.hasNext()) {
				line = input.nextLine();
				
				/*
				if (line.equals(".Roster with Times") || line.equals("Ontario DECA") ||  line.equals("White Oaks SS") || line.equals("ID Name Series") || line.equals("Code") || line.equals("Team Name Judge First Call") || line.equals("Time") || line.equals("Second") || line.equals("Call Time") || line.equals("Event Location Awards") || line.equals("(continued)") || line.equals("Report printed by CEMS (c) 2018 L D Ness Inc Licensed to Ontario DECA 2024-01-22 01:13 PM")) {
					
				}
				else {
					System.out.println(line);
				}
				*/
				
				fullList[count] = line;
				
				if (Character.isAlphabetic(line.charAt(0))) {
					System.out.println(line);
				}
				else {
					System.out.print(line);
				}
				
				if (line.substring(0,1) == "0") {
					System.out.print(line);
				}
				

				for (int i = 0; i < 3; i++) {
					line = line.substring(line.indexOf(" ") + 1,line.length());
				}

				count += 1;

			}

		} catch (FileNotFoundException e) {
			System.out.print("File not Found.");
			System.exit(0);
		}

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				// remove duplicates
				if (list[i].equals(list[j]) && i != j) {
					//System.out.println(list[i]);
					//System.out.println(list[j]);
					list[j] = "-1";
				}
			}
		}

		for (int i = 0; i < list.length; i++) {
			line = list[i];
			if (line.contains(findEvent)) {
				provEvCount += 1;
			}
		}

		/*
		if (line.equals("2024 Submission Status of Written Papers 2024-01-15") || line.equals("5:29 PM") || line.equals("Chapter Name Last Name Event Approval") || line.equals("Has Successfully") || line.equals("Uploaded a PDF") || line.equals("Attachment")) {

		}
		*/

		
		/*
		System.out.println("Prov Submissions:");
		System.out.println("Number of people at WOSS: " + woss);
		System.out.println("Number of people in " + findEvent + ": " + eventCount);

		System.out.println("\nWOSS Provs:");
		System.out.println("Number of people at WOSS: " + wossers);
		System.out.println("Number of Wossers in " + findEvent + ": " + provEvCount);
		*/

	}

}
