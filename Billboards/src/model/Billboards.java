package model;

import java.io.Serializable;

public class Billboards implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int m2;
	private boolean inUse;
	private String name;
	
	public Billboards(int width,int height,boolean inUse,String name) {
		this.width=width;
		this.height=height;
		this.inUse=inUse;
		this.name=name;
		this.m2=(width*height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getM2() {
		return m2;
	}
	public String toString() {
		return width+"    "+height+"    "+inUse+"       " + name;
	}
	
}
