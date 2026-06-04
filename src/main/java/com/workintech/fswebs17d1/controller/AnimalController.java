package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    // application.properties dosyasındaki değerleri @Value ile alıyoruz
    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullName;

    // Verileri hafızada (In-Memory) tutmak için Map tanımı
    private final Map<Integer, Animal> animals = new HashMap<>();

    // --- PROJE BILGILERINI GÖREBILMEK ICIN OPSIYONEL TEST ENDPOINT'I ---
    @GetMapping("/info")
    public String getInfo() {
        return "Course: " + courseName + " | Developer: " + developerFullName;
    }

    // 1. [GET] /workintech/animal => Tüm hayvanları Liste olarak döner
    @GetMapping
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    // 2. [GET] /workintech/animal/{id} => Belirli bir ID'ye sahip hayvanı döner
    @GetMapping("/{id}")
    public Animal findById(@PathVariable int id) {
        // Eğer haritada varsa döner, yoksa null döner (Gelişmiş yapılarda exception fırlatılabilir)
        return animals.get(id);
    }

    // 3. [POST] /workintech/animal => Yeni bir hayvan ekler
    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    // 4. [PUT] /workintech/animal/{id} => Var olan bir hayvanı günceller
    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal) {
        // URL'den gelen ID değerini nesne güvenliği için set ediyoruz
        animal.setId(id);
        animals.put(id, animal);
        return animal;
    }

    // 5. [DELETE] /workintech/animal/{id} => Belirtilen ID'deki hayvanı siler ve silineni döner
    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id) {
        return animals.remove(id);
    }
}