package basa.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basa.almacen.dao.TipoRepository;
import basa.almacen.entity.Tipo;

@Service
public class TipoService {

	@Autowired
	private TipoRepository repo;
	
	
	public void grabar(Tipo t) {
		repo.save(t);
	}
	
	public List<Tipo> listarTipo(){
		return repo.findAll();
	}
	
	public void actualizar(Tipo t) {
		repo.save(t);
	}
	
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	
	public Tipo buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
