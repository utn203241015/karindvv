package com.villegas.karin.karindvv.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.villegas.karin.karindvv.model.Categoria;

public interface IntServiceCategoria {

	public List<Categoria> obtenerCategorias();
	public void guardar (Categoria categoria);
	public Categoria buscarPorId(Integer idCategoria);
	public void eliminar (Integer idCategoria);
	public Integer numeroCategorias();
	public Page<Categoria> buscarTodas(Pageable page);

	
}
