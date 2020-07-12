package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import com.redsocial.bean.LibroBean;

import com.redsocial.bean.TemaBean;
import com.redsocial.service.LibroService;
import com.redsocial.service.LibroServicelmpl;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ModalidadAction extends ActionSupport {

	// Para la consulta
	private @Getter @Setter List<LibroBean> lstLibro = new ArrayList<LibroBean>();
	private @Getter @Setter String filtro = "";

	// Para el combo
	private @Getter @Setter List<TemaBean> lstTema = new ArrayList<TemaBean>();

	// Para insertar y actualizar
	private @Getter @Setter LibroBean libro;
	
	// Para eliminar
	private @Getter @Setter String id;

	@Action(value = "/cargaLibro", results = { @Result(name = "success", type = "json") })
	public String cargaLibro() {
		log.info("En carga libro");
		try {
			LibroServicelmpl service = new LibroServicelmpl();
			lstTema = service.listaTema();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/eliminaLibro", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
	public String elimina() {
		log.info("En eliminar libro");
		LibroService service = new LibroServicelmpl();
		try {
			service.eliminaLibro(Integer.parseInt(id));
			lstLibro = service.listaLibro(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}




	@Action(value = "/consultaLibro", results = { @Result(name = "success", location = "/crudModalidad.jsp") })
	public String listar() {
		log.info("En listar libro");
		try {
			LibroService service = new LibroServicelmpl();
			lstLibro = service.listaLibro(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


}
