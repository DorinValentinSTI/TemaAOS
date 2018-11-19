package com.tema2.AOS.TemaTwoAOS;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tema2.persondatabase.PersonDatabase;

@SpringBootApplication
@RestController
public class TemaTwoAosApplication {
	
	private EntityManagerFactory entityManagerFactory;
    private PersonDatabase personDAO;
    
	public static void main(String[] args) {
		SpringApplication.run(TemaTwoAosApplication.class, args);
	}
	@RequestMapping("/")
    public String intialize() {
		
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        personDAO = new PersonDatabase(entityManagerFactory);
        return "Hello Programmer!!!";
    }
	
	@RequestMapping("/hello")

    public String sayHello(@RequestParam("name") String name) {

        return "HELLO "+name;

    }
}
