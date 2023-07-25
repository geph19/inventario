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
        return "Welcome to Inventario API";
    }

    @PostMapping("/api/inventario/agregar")
    public Inventario crearArticulo(@RequestBody Inventario inventario){
       inventarioService.createItem(inventario);
       return inventario;
    }

    @GetMapping("/api/inventario/get/{id}")
    public Inventario getItemById(@PathVariable("id") Integer id){
        return inventarioService.getItemById(id);
    }

    @GetMapping("api/inventario/get/name/{name}")
    public Inventario getItemByName(@PathVariable("name") String name){
        return inventarioService.getItemByName(name);
    }

    @GetMapping("api/inventario/all")
    public List<Inventario> getAllItems(){
        return inventarioService.getAllItems();
    }

    @PutMapping("/api/inventario/update")
    public Inventario updateItem(@RequestBody Inventario inventario){
        return inventarioService.updateItem(inventario);
    }
    @GetMapping("api/inventario/ordenado")
    public List<Inventario> ordenarItems() {
        return inventarioService.invertirOrden();
    }
}
