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
	private Integer cod_producto;

	private int cant_Salida;
	private String guia_Salida;
	private int cant_Ingreso;
	private String guia_Ingreso;
	private int merma;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name="tipo_insumo")
	private Tipo tipo;

	public Integer getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Integer cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getCant_Salida() {
		return cant_Salida;
	}

	public void setCant_Salida(int cant_Salida) {
		this.cant_Salida = cant_Salida;
	}

	public String getGuia_Salida() {
		return guia_Salida;
	}

	public void setGuia_Salida(String guia_Salida) {
		this.guia_Salida = guia_Salida;
	}

	public int getCant_Ingreso() {
		return cant_Ingreso;
	}

	public void setCant_Ingreso(int cant_Ingreso) {
		this.cant_Ingreso = cant_Ingreso;
	}

	public String getGuia_Ingreso() {
		return guia_Ingreso;
	}

	public void setGuia_Ingreso(String guia_Ingreso) {
		this.guia_Ingreso = guia_Ingreso;
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
