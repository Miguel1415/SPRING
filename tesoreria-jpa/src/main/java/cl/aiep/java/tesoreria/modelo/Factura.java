package cl.aiep.java.tesoreria.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames= {"proveedor_id","folio"})})
public class Factura {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne //implementacion de uno a muchos
	private Proveedor proveedor;
	private Long folio;
	private double monto;	
	private LocalDate fecha;
	
	
	public Factura() {
		super();
	}


	public Factura(Long id, Proveedor proveedor, Long folio, double monto, LocalDate fecha) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.folio = folio;
		this.monto = monto;
		this.fecha = fecha;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Long getFolio() {
		return folio;
	}


	public void setFolio(Long folio) {
		this.folio = folio;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
}