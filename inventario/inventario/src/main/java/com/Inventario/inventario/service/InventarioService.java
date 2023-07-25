package com.Inventario.inventario.service;

import com.Inventario.inventario.model.Inventario;

import java.util.List;

public interface InventarioService {
     void createItem(Inventario inventario);
     Inventario getItemById(Integer id);
     Inventario getItemByName(String name);
     List<Inventario> getAllItems();
     Inventario updateItem(Inventario updatedInventario);
     List<Inventario> invertirOrden();

}
