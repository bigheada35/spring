package com.javalec.ex.shape2;

public class Rectangle implements Shape {
	private double width;
	private double height;
	
	public Rectangle() {
		
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public void setWidth(double width) {
		this.width = width;

	}

	@Override
	public void setHeight(double height) {
		this.height = height;

	}

}
