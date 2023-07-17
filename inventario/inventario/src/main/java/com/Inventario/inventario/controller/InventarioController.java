package com.Inventario.inventario.controller;

import com.Inventario.inventario.model.Inventario;
import com.Inventario.inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Inventario app";
    }

    @PostMapping("/api/inventario/agregar")
    public Inventario crearArticulo(@RequestBody Inventario inventario){
        inventario=  inventarioService.createItem(inventario);
        return inventario;
    }

    @GetMapping("/api/inventario/get/{id}")
    public Inventario getItemById(@PathVariable("id") Integer id){
        return inventarioService.getItemById(id);
    }

    @GetMapping("api/inventario/get/item/{name}")
    public Inventario getItemByName(@RequestBody Inventario inventario){
        inventario = inventarioService.getItemByName(inventario);
        return inventario;
    }

    @GetMapping("api/inventario/all")
    public List<Inventario> getAllItems(){
        return inventarioService.getAllItems();
    }

    @PutMapping("/api/inventario/update/{id}")
    public Inventario updateItem(@PathVariable Integer id){
        return null;
    }
}
