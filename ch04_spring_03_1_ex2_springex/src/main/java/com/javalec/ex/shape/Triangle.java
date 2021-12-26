package com.javalec.ex.shape;

public class Triangle  implements Shape{
	private int height;
	private int width;
	private double area;
	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Triangle(int height, int width) {
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
		return this.width*this.height/2.0f;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	
}
