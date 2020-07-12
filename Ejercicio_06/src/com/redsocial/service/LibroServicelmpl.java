package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.LibroBean;
import com.redsocial.bean.TemaBean;
import com.redsocial.dao.MySqlLibroDAO;

public class LibroServicelmpl implements LibroService{
	
	MySqlLibroDAO dao=new MySqlLibroDAO();

	@Override
	public List<LibroBean> listaLibro(String filtro) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaLibro(filtro);
	}

	@Override
	public int eliminaLibro(int idLibro) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminaLibro(idLibro);
	}

	@Override
	public List<TemaBean> listaTema() throws Exception {
		// TODO Auto-generated method stub
		return dao.listaTema();
	}

	@Override
	public List<LibroBean> listaLibro(FiltroBean filtro) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaLibro(filtro);
	}

	@Override
	public List<LibroBean> listaLibroMultiple(FiltroBean filtro) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaLibroMultiple(filtro);
	}

}
