package com.javalec.ex.shape;

public class Rectangle implements Shape {
	private int height;
	private int width;
	private double area;
	public Rectangle() {

	}
	public Rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) { 
		this.width = width;
	}
	public double getArea() {
		return this.width*this.height;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	
}
