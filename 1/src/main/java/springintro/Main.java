package springintro;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springintro.bean.Product;

public class Main 
{
	public static void main(String[] args)
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
		//le indicamos a spring que cree una instancia del bean product
		Product product1 = context.getBean("product", Product.class);
		product1.setName("Excellent snake oil");
		System.out.println("product1: " + product1.getName());
		
		LocalDate localDate = context.getBean("localDate", java.time.LocalDate.class);
	}
}
