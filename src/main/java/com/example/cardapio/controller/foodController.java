package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("cardapio")
    public class foodController {
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping // ENDPOIT (GET) - CONSULTAR TODOS OS ITENS
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        try {
            return foodList;
        }
        catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Ocorreu um erro: ", e);
        }
        return foodList;
    }

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "8")
    @PostMapping // ENDPOIT (POST) - CADASTRAR ITENS INDIVIDUALMENTE
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.PUT})
    @PutMapping("/{id}") // ENDPOIT (PUT) - ATUALIZAR ITENS INDIVIDUALMENTE
    public String updateFood(@PathVariable long id, @RequestBody Food food){
        Food updateFood = repository.findById(id).get();
        try {
            updateFood.setTitle(food.getTitle());
            updateFood.setImage(food.getImage());
            updateFood.setPrice(food.getPrice());

            repository.save(updateFood);
            return "Updated!";
        }
        catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Ocorreu um erro: ", e);
        }
        return "Updated!";
    }

    @CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.DELETE})
    @DeleteMapping("/{id}") // ENDPOIT (DELETE) - DELETAR ITENS PELO ID
    public String deleteFood (@PathVariable ("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            return "Não há ID!";
        }
        return "ok";
    }
}