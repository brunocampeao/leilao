package br.projeto.leilao.app;


import java.io.InputStream;
import java.util.Arrays;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Main {

	public static void main(String[] args) {
		
		log.debug("Iniciando a aplicacao");
		
		ClassRelativeResourceLoader loader = new ClassRelativeResourceLoader(Main.class); 
		SpringApplication app = new SpringApplication(Main.class);
		try {//(Resource resource = app.getResourceLoader().getResource("classpath:banner.txt")) {
			Resource resource = loader.getResource("classpath:banner.txt");
			ResourceBanner banner = new ResourceBanner(resource);
			app.setBanner(banner);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		app.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}