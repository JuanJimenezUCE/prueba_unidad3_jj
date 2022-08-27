package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermercado.repository.modelo.Producto;
import com.uce.edu.demo.supermercado.repository.modelo.dto.ListaProductos;
import com.uce.edu.demo.supermercado.service.IGestorSupermercadoService;
import com.uce.edu.demo.supermercado.service.IProductoService;
import com.uce.edu.demo.supermercado.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3JjP2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3JjP2Application.class, args);
	}

	private static Logger LOG = Logger.getLogger(PruebaUnidad3JjP2Application.class);

	
	@Autowired
	private IGestorSupermercadoService iGestorSupermercadoService;
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IVentaService iVentaService;
	
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Producto producto1= new Producto();
		producto1.setNombre("Leche");
		producto1.setCategoria("Bebidas");
		producto1.setCodigoBarras("123456");
		producto1.setPrecio(new BigDecimal(1.50));
		
		this.iGestorSupermercadoService.ingresarProducto(producto1, 5);
		
		
		List<ListaProductos> productos = new ArrayList<>();
			
		ListaProductos lp = new  ListaProductos();
		lp.setCantidad(2);
		lp.setCodigoBarras("123456");
	

		productos.add(lp);
		
		this.iVentaService.realizarVenta(productos, "1723026900", "1");
		
		Producto p1=this.iProductoService.buscarPorCodigoBarrasCriteria("123456");
	    
     	LOG.info("producto Criteria API: "+p1);
		
	}

}
