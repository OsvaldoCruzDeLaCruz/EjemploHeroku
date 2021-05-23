package com.osvaldo.cruz.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{
	
	@GetMapping("/tabla")
	public String tabla(Model model) {
		List<Producto> lista = obtenerProductos();
		model.addAttribute("productos", lista);
		for(Producto p: lista) {
			System.out.println(p.getId() + "--"+
								p.getNombre() + "--" +
								p.getPrecio());
		}
		return "tabla";
	}
	
	@GetMapping("/index")
	public String home() {
		return "home";
	}
	@GetMapping("/mensaje")
	public String mensaje(Model model) {
		String str="Bienbenidos a mi sitiio web";
		Double raiz = Math.sqrt(35);
		model.addAttribute("mensjae", str);
		model.addAttribute("raiz",raiz);
		model.addAttribute("colores", colores());
		
		for(String color:colores()) {
			System.out.println(color);
		}
		model.addAttribute("productos", obtenerProductos());
		for(Producto producto: obtenerProductos()) {
			System.out.println(producto);
		}
	return "mensaje";
	}
	
	public List<Producto> obtenerProductos(){
		List<Producto> lista = new LinkedList<Producto>();
		Producto p1 = new Producto();
		p1.setId(1);
		p1.setNombre("Camisa");
		p1.setPrecio(250.0);
		
		Producto p2 = new Producto();
		p2.setId(2);
		p2.setNombre("Pantalon");
		p2.setPrecio(350.0);
		
		Producto p3 = new Producto();
		p3.setId(3);
		p3.setNombre("Chamarra");
		p3.setPrecio(450.0);
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		return lista;
		
	}
	
	
	public List<String> colores(){
		List<String> lista = new LinkedList<String>();
		lista.add("Rojo");
		lista.add("Verde");
		lista.add("Amarillo");
		lista.add("Blancos");
		return lista;
	}
	
}
	class Producto{
	Integer id;
	String nombre;
	Double precio;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	

}