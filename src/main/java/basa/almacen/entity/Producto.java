package basa.almacen.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tb_producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;

	private int cant_salida;
	private String guia_salida;
	private int cant_ingreso;
	private String guia_ingreso;
	private int merma;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipo tipo;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", cant_salida=" + cant_salida + ", guia_salida=" + guia_salida
				+ ", cant_ingreso=" + cant_ingreso + ", guia_ingreso=" + guia_ingreso + ", merma=" + merma + ", fecha="
				+ fecha + ", tipo=" + tipo + "]";
	}

	public Producto(Integer id_producto, int cant_salida, String guia_salida, int cant_ingreso, String guia_ingreso,
			int merma, LocalDate fecha, Tipo tipo) {
		super();
		this.id_producto = id_producto;
		this.cant_salida = cant_salida;
		this.guia_salida = guia_salida;
		this.cant_ingreso = cant_ingreso;
		this.guia_ingreso = guia_ingreso;
		this.merma = merma;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public int getCant_salida() {
		return cant_salida;
	}

	public void setCant_salida(int cant_salida) {
		this.cant_salida = cant_salida;
	}

	public String getGuia_salida() {
		return guia_salida;
	}

	public void setGuia_salida(String guia_salida) {
		this.guia_salida = guia_salida;
	}

	public int getCant_ingreso() {
		return cant_ingreso;
	}

	public void setCant_ingreso(int cant_ingreso) {
		this.cant_ingreso = cant_ingreso;
	}

	public String getGuia_ingreso() {
		return guia_ingreso;
	}

	public void setGuia_ingreso(String guia_ingreso) {
		this.guia_ingreso = guia_ingreso;
	}

	public int getMerma() {
		return merma;
	}

	public void setMerma(int merma) {
		this.merma = merma;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	
	
	
}
