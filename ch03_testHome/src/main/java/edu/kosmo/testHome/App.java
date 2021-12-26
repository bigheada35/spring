package edu.kosmo.testHome;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //Rectangle rec = new Rectangle(10,10);
        //Triangle tri = new Triangle(10,10);
        ApplicationContext context = new ClassPathXmlApplicationContext("edu/kosmo/testHome/appCTX5.xml");
        
        //Shape shape = (Shape)context.getBean(Rectangle.class);
        //shape.area();
        Rectangle rec = context.getBean(Rectangle.class);
        System.out.println(rec.getArea());
        
        //Shape shape2 = (Shape)context.getBean(Triangle.class); 
        //shape2.area();
        Triangle tri = context.getBean(Triangle.class);
        System.out.println(tri.getArea());
        
    }
}
