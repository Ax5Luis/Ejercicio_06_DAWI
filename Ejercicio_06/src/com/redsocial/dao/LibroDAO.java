package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.LibroBean;
import com.redsocial.bean.TemaBean;

public interface LibroDAO {
	
	
	public List<LibroBean> listaLibro(String filtro) throws Exception;
	public int eliminaLibro(int idLibro) throws Exception;
	public List<TemaBean> listaTema() throws Exception;
	
	
	public List<LibroBean> listaLibro(FiltroBean filtro)  throws Exception;
	public List<LibroBean> listaLibroMultiple(FiltroBean filtro)  throws Exception;

}
