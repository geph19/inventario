package com.Inventario.inventario.service.implementation;

import com.Inventario.inventario.model.Inventario;
import com.Inventario.inventario.repository.InventarioRepository;
import com.Inventario.inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventarioServiceImplementation implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public int generateId(){
        int idValue = inventarioRepository.mapSize();
        return idValue + 1;
    }
    @Override
    public Inventario createItem(Inventario inventario) {
        inventario.setId(generateId());
        inventario.setLastUpdate(LocalDateTime.now());
        inventarioRepository.createItem(inventario);
        return inventario;
    }
    @Override
    public Inventario getItemById(Integer id) {
        return inventarioRepository.getItemById(id);
    }
    @Override
    public Inventario getItemByName(Inventario inventario) {
        return inventarioRepository.getItemByName(inventario);
    }
    @Override
    public List<Inventario> getAllItems() {
        return inventarioRepository.getAllItems();
    }

    @Override
    public void updateItem(Integer id, Inventario updatedItem) {
        inventarioRepository.updateItems(id, updatedItem);
    }


}
