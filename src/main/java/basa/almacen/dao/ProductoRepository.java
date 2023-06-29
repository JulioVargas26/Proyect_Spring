package basa.almacen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import basa.almacen.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
