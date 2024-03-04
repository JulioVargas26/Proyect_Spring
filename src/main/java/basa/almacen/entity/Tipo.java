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
	private Integer cod_Tipo;
	private String descripcion;
	
	@OneToMany(mappedBy = "tipo")
	@JsonIgnore
	private List<Producto> listaProducto;

	public Integer getCod_Tipo() {
		return cod_Tipo;
	}

	public void setCod_Tipo(Integer cod_Tipo) {
		this.cod_Tipo = cod_Tipo;
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
