package com.sound.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.sound.service.Instrument;
import com.sound.service.InstrumentXml;

public class Admin {

	public static void main(String[] args) {

		Instrument inst ;
		ArrayList<Instrument> insts = new ArrayList<Instrument>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome Administrator ");
		System.out.println("Please Enter new Instrument Details ");

		while(true){

			System.out.println("Enter Instrument Name\n");
			String name = sc.nextLine();

			System.out.println("Enter Instrument Id\n");
			int instId = Integer.parseInt(sc.next());

			inst = new Instrument(instId, name);
			insts.add(inst);

			System.out.println("Press 1 to Exit");
			String exit = sc.next();
			if(exit.contains("1")){
				break;
			}

		}
		InstrumentXml.writeToXml(insts);
		sc.close();
	}

}
