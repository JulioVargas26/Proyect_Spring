package basa.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basa.almacen.dao.ProductoRepository;
import basa.almacen.entity.Producto;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	public void grabar(Producto p) {
		repo.save(p);
	}
	
	public List<Producto> listarProductos(){
		return repo.findAll();
	}
	
	public void actualizar(Producto p) {
		repo.save(p);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	
	public Producto buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
