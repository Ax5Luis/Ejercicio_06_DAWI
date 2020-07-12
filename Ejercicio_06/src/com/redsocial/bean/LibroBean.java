package com.redsocial.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroBean {
	
	
	private int idLibro;
	private String nombre;
	private double precio;
	private TemaBean tema;

}
