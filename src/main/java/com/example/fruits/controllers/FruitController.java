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
 * Project: fruits <br>
 */
@RestController
@RequestMapping(path="/fruit")
public class FruitController{

    @Autowired
    private IfruitRepo ifruitrepo;

    @GetMapping(path="/info")
    public String index(){
        return  "/add = add a fruit with Get method<br>" +
                "/addwithpost = add a fruit with Post method<br>" +
                "/addlistwithpost = adds a list of fruits with Post method<br>" +
                "/getall = returns all fruits<br>" +
                "/getbyname = returns specific fruits with that names info<br>" +
                "/getbycolor = returns specific fruits with that colors info<br>" +
                "/getbynameandcolor = return specific fruits with those variables<br>" +
                "/deletebyname = delete one fruit with specific name<br>" +
                "/deleteallbyname = deletes all fruits with specific name<br>" +
                "/deletebycolor = delete one fruit with specific color<br>" +
                "/deleteallbycolor = deletes all fruits with specific color<br>";
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

    @PostMapping(path="/addlistwithpost")
    public String addNewListGroceryByPost(@RequestBody List<Fruit> fruits){
        for(Fruit f : fruits){
            Fruit fruit = new Fruit();
            fruit.setName(f.getName());
            fruit.setColor(f.getColor());
            ifruitrepo.save(f);
        }
        return "Fruit saved with post method!";
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

    @GetMapping(path="/deletebyname")
    public String deleteByName(@RequestParam String name){
        Iterable<Fruit> list = ifruitrepo.findAll();
        for(Fruit f : list){
            if(f.getName().equalsIgnoreCase(name)) {
                ifruitrepo.delete(f);
                return "Deleted "+f+" from database";
            }
        }
        return "Didn't find anything fruit with that name.";
    }

    @GetMapping(path="/deleteallbyname")
    public String deleteAllByName(@RequestParam String name){
        Iterable<Fruit> list = ifruitrepo.findByName(name);
        ifruitrepo.deleteAll(list);
        return "Delete from database: <br> " + list;
    }

    @GetMapping(path="/deletebycolor")
    public String deleteByColor(@RequestParam String color){
        Iterable<Fruit> list = ifruitrepo.findAll();
        for(Fruit f : list){
            if(f.getName().equalsIgnoreCase(color)) {
                ifruitrepo.delete(f);
                return "Deleted "+f+" from database";
            }
        }
        return "Didn't find anything fruit with that name.";
    }

    @GetMapping(path="/deleteallbycolor")
    public String deleteAllByColor(@RequestParam String color){
        Iterable<Fruit> list = ifruitrepo.findByName(color);
        ifruitrepo.deleteAll(list);
        return "Delete from database: <br> " + list;
    }

}