package com.sound.client;

import java.util.Scanner;
import com.sound.service.Button;
import com.sound.service.Instrument;
import com.sound.service.XmlOperation;

public class Admin {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome Administrator ");
		System.out.println("1. Instruments Adding \n2. Buttons Adding ");
		int input = sc.nextInt();
		sc.nextLine();

		switch(input){

		case 1: 
			XmlOperation xmlInstrument = new XmlOperation("instruments.xml");
			while(true){
				System.out.println("Enter Instrument Name\n");
				String name = sc.nextLine();
				System.out.println("Enter Instrument Id\n");
				int instId = sc.nextInt();
				sc.nextLine();
				
				Instrument inst = new Instrument(instId, name);
				xmlInstrument.writeToXml(inst,"Instruments");
				
				System.out.println("Press 1 to Exit");
				String exit = sc.nextLine();
				if(exit.contains("1")){
					break;
				}
			}
			sc.close();
			break;
		case 2:
			XmlOperation xmlButton = new XmlOperation("button.xml");
			while(true){
				System.out.println("Enter Button Name ");
				String name = sc.nextLine();
				System.out.println("Enter Button Fill");
				String fill = sc.nextLine();
				System.out.println("Enter Grid X Value");
				int gridX = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Grid Y Value");
				int gridY = Integer.parseInt(sc.nextLine());
				
				Button b = new Button(name, fill, gridX, gridY);
				xmlButton.writeToXml(b,"Buttons");
				
				System.out.println("Press 1 to Exit");
				String exit = sc.next();
				if(exit.contains("1")){
					break;
				}
			}
			break;
		default :
			System.out.println("Entered Wrong Number");
		}


	}

}
