package com.villegas.karin.karindvv.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.villegas.karin.karindvv.model.Categoria;
import com.villegas.karin.karindvv.service.IntServiceCategoria;


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = serviceCategorias.buscarTodas(page);
	model.addAttribute("total", serviceCategorias.numeroCategorias());
	model.addAttribute("categorias", lista);
	return "categorias/listaCategorias";
	}

	
	@Autowired
	private IntServiceCategoria serviceCategorias;
	
	@GetMapping("/consulta")
	public String consulta(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	
	
	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		Categoria cat = new Categoria();
		int id = serviceCategorias.obtenerCategorias().size();
		Categoria c = serviceCategorias.obtenerCategorias().get(id-1);
		System.out.println(id);
		cat.setId(++id);
		cat.setNombre(nombre);
		cat.setDescripcion(descripcion);
		serviceCategorias.guardar(cat);
		return "redirect:/categorias/indexPaginate";
	}*/
	
	@PostMapping ("/guardar")
	public String guardar (Categoria categoria) {
		System.out.println(categoria);
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/indexPaginate";
	}
	
	@GetMapping("/nueva")
	public String nuevaCategoria(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping("eliminar/{id}")
	public String eliminarCategoria(@PathVariable("id") int idCategoria, RedirectAttributes atributo) {
		atributo.addFlashAttribute("msg", "¡La categoria se elimino con exito!");
		serviceCategorias.eliminar(idCategoria);
		return "redirect:/categorias/indexPaginate";
	}
	
	@GetMapping("/mostrar")
	public String mostrar(@RequestParam("id") Integer id, Model model) {
		Categoria vac = new Categoria();
		vac= serviceCategorias.buscarPorId(id);
		model.addAttribute("categoria", vac);
		return "categorias/detalle";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = new LinkedList<Categoria>();
		lista = serviceCategorias.obtenerCategorias();
		System.out.println(lista);
		for(Categoria c : lista) {
			System.out.println(c);
		}
		model.addAttribute("categorias",lista);
		return "/categorias/listaCategorias";
	}	
}
