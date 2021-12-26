package edu.kosmo.shape;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! " );
        String loc = "classpath:appCTX.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
        Shape shape = ctx.getBean("shape", Shape.class);
        System.out.println("넓이 : " + shape.getArea());
        
    }
}
