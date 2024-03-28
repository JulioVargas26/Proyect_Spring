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
	private Integer id_tipo;
	private String descripcion;
	
	@OneToMany(mappedBy = "tipo")
	@JsonIgnore
	private List<Producto> listaProducto;

	

	public Tipo() {
		
	}

	@Override
	public String toString() {
		return "Tipo [id_tipo=" + id_tipo + ", descripcion=" + descripcion + ", listaProducto=" + listaProducto + "]";
	}

	public Tipo(Integer id_tipo, String descripcion, List<Producto> listaProducto) {
		super();
		this.id_tipo = id_tipo;
		this.descripcion = descripcion;
		this.listaProducto = listaProducto;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
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
