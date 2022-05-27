package cl.aiep.java.tesoreria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.tesoreria.modelo.Proveedor;

//int -> Integer
//long -> Long
//short ->Short
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>
{
	public List<Proveedor> findByRut(String rut);

}
