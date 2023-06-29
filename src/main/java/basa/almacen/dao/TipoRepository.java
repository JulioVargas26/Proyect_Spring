package basa.almacen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import basa.almacen.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
