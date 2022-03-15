package ui;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import model.ArrayBillBoards;

public class Main {
	static ArrayBillBoards billboards;
	static Scanner sc;
	
	public static void main(String[]args) {
		billboards=new ArrayBillBoards();
		deserialize();		
		int index;
		do {
			index=menu();
			serialize();
		}while(index!=0);
		
	}
	
	public static int menu() {
		sc=new Scanner(System.in);
		int index;
		System.out.println("Select");
		System.out.println("1. To import");
		System.out.println("2. Add billboard");
		System.out.println("3. Show billboard");
		System.out.println("4. Hazard report");
		System.out.println("0. Finish");
		index=sc.nextInt();
		sc.nextLine();
		switch(index) {
		case 0:
			System.out.println("Bye");
			break;
		case 1:
			importData();
			break;
		case 2:
			addBillboard();
			break;
		case 3:
			showBillboards();
			break;
		case 4:
			report();
			break;
		}
		return index;
	}
	
	public static void addBillboard() {
		sc=new Scanner(System.in);
		System.out.println("Digite information");
		String input=sc.nextLine();
		
		String[] data = input.split("\\+\\+");
		int width= Integer.parseInt(data[0]);
		int height=Integer.parseInt(data[1]);
		boolean inUse=Boolean.getBoolean(data[2]);
		if(data[2].equals("true")) {
			inUse=true;
		}else inUse=false;
		
		String name=data[3];
		billboards.addBillboard(width,height,inUse,name);
	}
	
	public static void report() {
		System.out.println(billboards.billboardReport());
	}
	
	public static void showBillboards() {
		String[] toPrint=billboards.billboardsToPrint();
		System.out.println("w    |   h   |  inUse  |  brand");
		for(int i=0;i<toPrint.length;i++) {
			System.out.println(toPrint[i]);
		}
	}
	public static void importData() {
		System.out.println("Digite path");
		String path=sc.nextLine();
		billboards.loadBillBoards(path);
	}
	public static void serialize() {
		File file = new File("billboards.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(billboards);
			
			oos.close();
			fos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deserialize() {
		File file = new File("billboards.txt");
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			billboards = (ArrayBillBoards) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
