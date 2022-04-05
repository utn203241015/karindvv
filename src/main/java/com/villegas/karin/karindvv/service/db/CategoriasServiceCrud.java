package com.villegas.karin.karindvv.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.villegas.karin.karindvv.model.Categoria;
import com.villegas.karin.karindvv.repository.CategoriasRepository;
import com.villegas.karin.karindvv.service.IntServiceCategoria;

@Service
@Primary
public class CategoriasServiceCrud implements IntServiceCategoria{
	
	//inyectamos una instancia en este caso la interfaz
	
	@Autowired
	private CategoriasRepository repoCategorias;

	@Override
	public List<Categoria> obtenerCategorias() {
		// TODO Auto-generated method stub
		return (List<Categoria>) repoCategorias.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional <Categoria> optional = repoCategorias.findById(idCategoria);
			if (optional.isPresent()) {
		return optional.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);
		
	}

	@Override
	public Integer numeroCategorias() {
		
		return (int) repoCategorias.count();
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategorias.findAll(page);
	}

}
