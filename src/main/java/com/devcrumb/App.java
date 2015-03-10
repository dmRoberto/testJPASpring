package com.devcrumb;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devcrumb.dao.PersonDaoImpl;
import com.devcrumb.model.Person;

/**
 * App class with main method to test our DAO
 * 
 * @author DevCrumb.com
 */
public class App {
	
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new  
    			  ClassPathXmlApplicationContext("applicationContext.xml");
    	PersonDaoImpl dao = (PersonDaoImpl) context.getBean("personDao");
    	
        Person peter = new Person("Peter", "Sagan");
        Person nasta = new Person("Nasta", "Kuzminova");
        
        List<Person> persons = dao.getAll();
        for (Person person : persons) {
			System.out.println(person);
		}
        
        dao.save(peter);
        dao.save(nasta);
        
        persons = dao.getAll();
        for (Person person : persons) {
			System.out.println(person);
		}
        context.close();
    }
}
