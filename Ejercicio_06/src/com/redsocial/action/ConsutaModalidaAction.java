package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.LibroBean;

import com.redsocial.service.LibroService;
import com.redsocial.service.LibroServicelmpl;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@CommonsLog
public class ConsutaModalidaAction extends ActionSupport {

	private @Getter @Setter List<LibroBean> lstLibro = new ArrayList<LibroBean>();

	private @Getter @Setter FiltroBean filtro;

	@Action(value = "/consultaLibroPorFiltro", results = { @Result(name = "success", type = "json") })
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

	@Action(value = "/consultaLibroMultiple", results = { @Result(name = "success", type = "json") })
	public String listarMultiple() {
		log.info("En listar listarMultiple");
		try {
			LibroService service = new LibroServicelmpl();
			lstLibro = service.listaLibroMultiple(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
