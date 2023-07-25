package com.Inventario.inventario.repository;

import com.Inventario.inventario.model.Inventario;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InventarioRepository {
    private Map<Integer, Inventario> itemMap = new HashMap<>();

    public void createItem(Inventario inventario){
        itemMap.put(inventario.getId(), inventario);
    }

    public Inventario getItemById(Integer id){
        return itemMap.get(id);
    }
    public Inventario getItemByName(String name){
        for (Integer i = 0; i < itemMap.size(); i++) {
            Inventario inventario = itemMap.get( i + 1);
            System.out.println(inventario.getName());

            if (inventario.getName().toLowerCase().contains(name.toLowerCase())){
                return inventario;
            }
        }
        System.out.println("No hay items con esa descripción");
        throw new RuntimeException();
    }
    public List<Inventario> getAllItems() {
        return new ArrayList<Inventario>(itemMap.values());
    }
    public Inventario updateItems(Inventario updatedItem) {
        return itemMap.put(updatedItem.getId(), updatedItem);
    }

    public Integer mapSize() {
        int lastId = 0;
        for(int key : itemMap.keySet()){
            lastId = key;
        }
        return lastId;
    }

    public List<Inventario> invertirOrden() {
        List<Inventario> inventarioList = getAllItems();
        Comparator<Inventario> comparator = new Comparator<Inventario>() {
            @Override
            public int compare(Inventario o1, Inventario o2) {
                return 0;
            }
        };
        Collections.sort(inventarioList, comparator);
        Collections.reverse(inventarioList);
        return inventarioList;
    }
}
