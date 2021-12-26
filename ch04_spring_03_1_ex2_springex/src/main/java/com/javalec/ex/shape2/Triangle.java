package com.javalec.ex.shape2;

public class Triangle implements Shape {
	private double width;
	private double height;
	
	public Triangle() {
		
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height/2.0f;
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
