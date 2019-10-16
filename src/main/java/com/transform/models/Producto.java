package com.transform.models;

import java.util.List;

public class Producto {
	private String nombre;
	private String urlImg;
	private String descripcion;
	private List<String> tags;
	
	public Producto(String nombre, String urlImg, String descripcion, List<String> tags) {
		super();
		this.nombre = nombre;
		this.urlImg = urlImg;
		this.descripcion = descripcion;
		this.tags = tags;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
}
