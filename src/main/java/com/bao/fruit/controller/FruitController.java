package com.bao.fruit.controller;


import com.bao.fruit.entity.Fruit;
import com.bao.fruit.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-07-16
 */
@RestController
@RequestMapping("//fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/list")
    public List<Fruit> list(){
        return this.fruitService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return fruitService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Fruit find(@PathVariable("id") Integer id){
        return this.fruitService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Fruit fruit){
        return this.fruitService.updateById(fruit);
    }

}

