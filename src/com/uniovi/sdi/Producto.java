/**
 * 
 */
package com.uniovi.sdi;

/**
 * @author Pablo Rodríguez Valdés
 *
 * SDI - 2019
 */
public class Producto {
	
	private String nombre;
	private String imagen;
	private float precio;
	
	/**
	 * Constructor sin argumentos
	 */
	public Producto() {
		
	}
	
	/**
	 * Constructor con argumentos 
	 * 
	 * @param nombre nombre del producto
	 * @param imagen URL de la imagen 
	 * @param precio precio del producto
	 */
	public Producto(String nombre, String imagen, float precio) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
