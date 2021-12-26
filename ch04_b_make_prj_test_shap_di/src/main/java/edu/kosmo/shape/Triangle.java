package edu.kosmo.shape;

public class Triangle implements Shape {
	private double area;
	private double width;
	private double height;
	
	public Triangle() {
	}
	 
		
	public Triangle(double area, double width, double height) {
		super();
		this.area = area;
		this.width = width;
		this.height = height;
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
