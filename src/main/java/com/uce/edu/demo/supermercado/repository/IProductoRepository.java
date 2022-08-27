package com.uce.edu.demo.supermercado.repository;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;

public interface IProductoRepository {

	
	void insertar(Producto producto);

	void actualizar(Producto producto);

	public Producto buscarPorCodigoBarras(String codigoBarras);
	
	public Producto buscarPorCodigoBarrasCriteria(String codigoBarras);
}
