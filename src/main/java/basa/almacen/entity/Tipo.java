package basa.almacen.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo")
public class Tipo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_insumo;
	private String descripcion;
	
	@OneToMany(mappedBy = "tipo")
	@JsonIgnore
	private List<Producto> listaProducto;

	public Integer getId_insumo() {
		return id_insumo;
	}

	public void setId_insumo(Integer id_insumo) {
		this.id_insumo = id_insumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	
}
