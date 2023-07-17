package com.Inventario.inventario.service;

import com.Inventario.inventario.model.Inventario;

import java.util.List;

public interface InventarioService {
     Inventario createItem(Inventario inventario);
     Inventario getItemById(Integer id);
     Inventario getItemByName(Inventario inventario);
     List<Inventario> getAllItems();
     void updateItem(Integer id, Inventario updatedInventario);

}
