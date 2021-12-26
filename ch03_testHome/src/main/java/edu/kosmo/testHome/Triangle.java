package edu.kosmo.testHome;

public class Triangle {
	private int width;
	private int height;
	private double area;
	public Triangle() {

	}
	public Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
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
	public double getArea() {
		area = width * height /2.0f;
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	
}
