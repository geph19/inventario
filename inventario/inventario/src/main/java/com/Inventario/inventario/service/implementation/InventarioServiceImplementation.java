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
    public void createItem(Inventario inventario) {
        boolean repeatValidation = noRepeatValidation(inventario);
        if (!repeatValidation) {
            inventario.setId(generateId());
            inventario.setLastUpdate(LocalDateTime.now());
            inventarioRepository.createItem(inventario);
        }
        if (repeatValidation){
            throw new RuntimeException(500 + "error de sistema, el usuario ya existe");
        }
    }
    @Override
    public Inventario getItemById(Integer id) {
        return inventarioRepository.getItemById(id);
    }

    @Override
    public Inventario getItemByName(String name) {
        return inventarioRepository.getItemByName(name);
    }

    @Override
    public List<Inventario> getAllItems() {
        return inventarioRepository.getAllItems();
    }

    @Override
    public Inventario updateItem(Inventario inventario) {
        if (inventario.getId() == null){
            Inventario updatedItem = inventarioRepository.getItemByName(inventario.getName());
            updatedItem.setStock(inventario.getStock());
            updatedItem.setPrice(inventario.getPrice());
            updatedItem.setLastUpdate(LocalDateTime.now());
            inventarioRepository.updateItems(updatedItem);
            return updatedItem;
        } else {
            Inventario updatedItem = inventarioRepository.getItemById(inventario.getId());
            updatedItem.setStock(updatedItem.getStock());
            updatedItem.setPrice(updatedItem.getPrice());
            updatedItem.setLastUpdate(LocalDateTime.now());
            inventarioRepository.updateItems(updatedItem);
            return updatedItem;
        }

    }

    @Override
    public List<Inventario> invertirOrden() {
        return inventarioRepository.invertirOrden();
    }

    private boolean noRepeatValidation(Inventario inventario) {
        List<Inventario> inventarioList = inventarioRepository.getAllItems();
        if (inventarioList.size() == 0) {
            return false;
        }
        for (Integer i = 0; i < inventarioList.size(); i++) {
            Inventario inventario1 = inventarioRepository.getItemById(i +1);
            if (inventario1.getName().toLowerCase().equals(inventario.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }


}
