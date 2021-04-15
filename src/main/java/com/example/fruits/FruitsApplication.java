package com.example.fruits;

import com.example.fruits.models.Fruit;
import com.example.fruits.repositories.IfruitRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FruitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IfruitRepo repo){
        return (args) -> {
            // create and save fruits to database
            repo.save(new Fruit("Banan","Gul"));
            repo.save(new Fruit("Banan","Brun"));
            repo.save(new Fruit("Äpple","Röd"));
            repo.save(new Fruit("Äpple","Grön"));
            repo.save(new Fruit("Apelsin","Orange"));
            repo.save(new Fruit("Apelsin","Grön"));
            repo.save(new Fruit("Päron","Grön"));
            repo.save(new Fruit("Päron","Brunt"));
            repo.save(new Fruit("Ananas","Gul"));

            // retrieve all fruits from database
            for(Fruit f : repo.findAll()){
                System.out.println(f.toString());
            }
        };
    }

}
