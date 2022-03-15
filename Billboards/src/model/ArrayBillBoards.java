package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ArrayBillBoards implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Billboards> billboards;
	public final int DANGER=200000;
	
	public ArrayBillBoards() {
		billboards=new ArrayList<>();
	}
	
	public ArrayList<Billboards> getBillboards() {
		return billboards;
	}

	public void setBillboards(ArrayList<Billboards> billboards) {
		this.billboards = billboards;
	}
	
	public void addBillboard(int width,int height,boolean inUse,String name) {
		Billboards toAdd=new Billboards(width,height,inUse,name);
		billboards.add(toAdd);
	}
	
	public void loadBillBoards(String path){
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader input = new BufferedReader(fr);
			input.readLine();
			while (input.ready()) {
				
				String[] data = input.readLine().split("\\|");
				int width= Integer.parseInt(data[0]);
				int height=Integer.parseInt(data[1]);
				boolean inUse=Boolean.getBoolean(data[2]);
				if(data[2].equals("true")) {
					inUse=true;
				}else inUse=false;
				String name=data[3];
				billboards.add(new Billboards(width,height,inUse,name));
			}
			
			input.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String [] billboardsToPrint() {
		String [] out=new String[billboards.size()];
		for(int i=0;i<out.length;i++) {
			out[i]=billboards.get(i).toString();
		}
		return out;
	}
	
	public String billboardReport() {
		String out="";
		int count=0;
		for(int i=0;i<billboards.size();i++) {
			if(billboards.get(i).getM2()>=DANGER) {
				count++;
				out+=count+". Billboard "+billboards.get(i).getName()+" with area "+billboards.get(i).getM2()+"\n";
			}
		}
		return out;
	}
}
