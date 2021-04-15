package com.example.fruits.controllers;

import com.example.fruits.models.Fruit;
import com.example.fruits.repositories.IfruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 14:40 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
@RestController
@RequestMapping(path="/fruit")
public class FruitController{

    @Autowired
    private IfruitRepo ifruitrepo;

    @GetMapping(path="/info")
    public String index(){
        return "/add = post a fruit<br>/getall = returns all fruits<br>/getbyname = returns specific fruit info";
    }

    @GetMapping(path="/add")
    public String addNewGrocery(@RequestParam String name, @RequestParam String color){
        Fruit f = new Fruit();
        f.setName(name);
        f.setColor(color);
        ifruitrepo.save(f);
        return "Fruit saved with get method!";
    }

    @PostMapping(path="/addwithpost")
    public String addNewGroceryByPost(@RequestBody Fruit fruit){
        Fruit f = new Fruit();
        f.setName(fruit.getName());
        f.setColor(fruit.getColor());
        ifruitrepo.save(f);
        return "Fruit saved with post method!";
    }


    @GetMapping(path="/addRandom")
    public String addRandomFruit(){
        Fruit f = new Fruit();
        f.setName("Banan");
        f.setColor("Gul");
        ifruitrepo.save(f);
        return "Fruit saved";
    }

    @GetMapping(path="/getall")
    public @ResponseBody Iterable<Fruit> getGroceries(){
        return ifruitrepo.findAll();
    }

    @GetMapping(path="/getbyname")
    public @ResponseBody List<Fruit> getFruitByName(@RequestParam String name){
        return ifruitrepo.findByName(name);
    }

    @GetMapping(path="/getbycolor")
    public @ResponseBody List<Fruit> getFruitByColor(@RequestParam String color){
        return ifruitrepo.findByColor(color);
    }

    @GetMapping(path="/getbynameandcolor")
    public @ResponseBody List<Fruit> getFruitByNameAndColor(@RequestParam String name, @RequestParam String color){
        return ifruitrepo.findByNameAndColor(name,color);
    }

}
