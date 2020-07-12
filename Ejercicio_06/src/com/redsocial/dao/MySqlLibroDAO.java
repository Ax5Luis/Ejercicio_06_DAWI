package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.LibroBean;
import com.redsocial.bean.TemaBean;

public class MySqlLibroDAO implements LibroDAO {
	
	
	
	
	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<LibroBean> listaLibro(String filtro) throws Exception {
		SqlSession session = null;
		List<LibroBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_libro", filtro+"%")  ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaLibro(int idLibro) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_elimina_Libro", idLibro);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}

	@Override
	public List<TemaBean> listaTema() throws Exception {
		SqlSession session = null;
		List<TemaBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_lista_tema");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public List<LibroBean> listaLibro(FiltroBean filtro) throws Exception {
		SqlSession session = null;
		List<LibroBean> salida = null;
		try {
			session = sqlMapper.openSession();
			filtro.setNombre(filtro.getNombre()+"%");
			salida = session.selectList("SQL_listaLibroPorFiltro",filtro );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

	@Override
	public List<LibroBean> listaLibroMultiple(FiltroBean filtro) throws Exception {
		SqlSession session = null;
		List<LibroBean> salida = null;
		try {
			session = sqlMapper.openSession();
			salida = session.selectList("SQL_listaLibroMultiple",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return salida;
	}

}
