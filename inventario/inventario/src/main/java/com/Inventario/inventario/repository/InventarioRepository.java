package com.Inventario.inventario.repository;

import com.Inventario.inventario.model.Inventario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InventarioRepository {
    public Map<Integer, Inventario> itemMap = new HashMap<>();

    public Inventario createItem(Inventario inventario){
        itemMap.put(inventario.getId(), inventario);
        return inventario;
    }
    public Inventario getItemById(Integer id){
        return itemMap.get(id);
    }
    public Inventario getItemByName(Inventario inventario){
        return itemMap.get(inventario);
    }
    public List<Inventario> getAllItems() {
        return new ArrayList<Inventario>(itemMap.values());
    }
    public void updateItems(Integer id, Inventario updatedItem) {
        itemMap.put(id, updatedItem);
    }

    public Integer mapSize() {
        int lastId = 0;
        for(int key : itemMap.keySet()){
            lastId = key;
        }
        return lastId;
    }
}
