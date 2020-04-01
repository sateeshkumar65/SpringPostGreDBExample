package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.postgre.ApplicationMeta;
import com.example.demo.postgre.ApplicationMetaRepository;

@SpringBootApplication
public class SpringPostGreDbExampleApplication implements CommandLineRunner {
	
	@Autowired
	private ApplicationMetaRepository applicationMetaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringPostGreDbExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationMeta applicationMeta = new ApplicationMeta();
		applicationMeta.setName("MyNewApp");
		applicationMeta.setDescription("This is a completely new application");
		applicationMetaRepository.save(applicationMeta);

		ApplicationMeta applicationMeta1 = new ApplicationMeta();
		applicationMeta1.setName("CoolApp");
		applicationMeta1.setDescription("This is cool application!");
		applicationMetaRepository.save(applicationMeta1);	
		
	}

}
