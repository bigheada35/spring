package com.javalec.ex.shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShapeMain {

	public static void main(String[] args) {
		
		String config = "classpath:applicationCTX4.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		
		Shape shape = ctx.getBean("shape", Shape.class);

		System.out.println(shape.getArea());
		ctx.close();

	}

}
