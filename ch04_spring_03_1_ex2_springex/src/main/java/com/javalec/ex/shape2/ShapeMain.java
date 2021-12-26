package com.javalec.ex.shape2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShapeMain {

	public static void main(String[] args) {
		String config = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		
		Shape shape = ctx.getBean("shape", Shape.class);
		
		
		System.out.println("넓이는 " + shape.getArea());
		
		shape.setHeight(100);
		shape.setWidth(100);
		
		System.out.println("넓이는 " + shape.getArea());
		
		ctx.close();

	}

}
