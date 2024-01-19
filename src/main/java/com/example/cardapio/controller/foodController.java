package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardapio")
    public class foodController {

// MÉTODO PARA CONSULTAR ITEM DO BANCO DE DADOS
    @Autowired
    private FoodRepository repository;
    @GetMapping  // CRIANDO ENDPOINT GET
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

// MÉTODO PARA SALVAR ITEM DO BANCO DE DADOS
    @CrossOrigin(origins = "*", allowedHeaders = "8")
    @PostMapping   // CRIANDO ENDPOINT POST
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

// MÉTODO PARA ATUALIZAR ITEM DO BANCO DE DADOS
    @PutMapping(value = "/{id}") // CRIANDO ENDPOINT PUT
    public String updateFood(@PathVariable long id, @RequestBody Food food){

        Food updateFood = repository.findById(id).get();

        updateFood.setTitle(food.getTitle());
        updateFood.setImage(food.getImage());
        updateFood.setPrice(food.getPrice());

        repository.save(updateFood);

        return "Updated!";
    }

// MÉTODO PARA DELETAR ITEM DO BANCO DE DADOS
    @DeleteMapping("/{id}") // CRIANDO ENDPOINT DELETE
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