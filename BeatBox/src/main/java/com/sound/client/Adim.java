package com.sound.client;

import java.util.Scanner;

import com.sound.service.Instrument;
import com.sound.service.InstrumentXml;

public class Adim {

	public static void main(String[] args) {

		Instrument inst ;
		Scanner sc = new Scanner(System.in);
		InstrumentXml toWrite = new InstrumentXml();

		while(true){

			System.out.println("Welcome Administrator ");
			System.out.println("Please Enter new Instrument Details ");

			System.out.println("Enter Instrument Name\n");
			String name = sc.nextLine();

			System.out.println("Enter Instrument Id\n");
			int instId = sc.nextInt();

			inst = new Instrument(instId, name);
			toWrite.write(inst);

			System.out.println("Press Y to Exit");
			if(sc.next().contains("Y")){
				break;
			}

		}
		sc.close();
	}

}
