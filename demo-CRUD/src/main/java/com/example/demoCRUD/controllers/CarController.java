package com.example.demoCRUD.controllers;

import java.util.List;


import com.example.demoCRUD.entities.Car;
import com.example.demoCRUD.repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/car")
public class CarController {
    //per creare un oggetto serve un repository che viene gestito da Java spring tramite @Autowired
    @Autowired
   CarRepository carRepository;

    //iniziamo facendo le oprazioni CRUD - quindi C di create
    //all'interno dell' API di Create si ha il POST
    @PostMapping
    public Car create(@RequestBody Car car){
      Car carSaved = carRepository.saveAndFlush(car);
      return carSaved;
    }
    //per osservare l'intero elenco di Car
    @GetMapping
    public List<Car> get() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    //se provo a cercare un oggetto car per id, posso trovarla all'interno del repository
    // oppure ritorna l'oggetto vuoto
    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id) {
        Car car = new Car();
        if (carRepository.existsById(id)) {
            car = carRepository.getById(id);
            return car;
        } else {
            return car;
        }
    }
    //metodo mer modificare un oggetto car in base all'id
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car car) {
        if (carRepository.existsById(id)) {
            Car updatedCar = carRepository.saveAndFlush(car);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //eliminare un oggetto in base all'id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    //metodo per rimuovere tutte le macchine
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
