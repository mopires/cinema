package br.com.cinema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cinema.dao.FilmeDAO;
import br.com.cinema.model.Filme;

@Controller
public class FilmeController {
	
    @Autowired
    FilmeDAO daoFilme;
    
	@RequestMapping("listaFilmes")
    public String lista(Model modelFilme) throws ClassNotFoundException {
        modelFilme.addAttribute("filmes", daoFilme.lista());
        return "filme/lista";
    }

	@RequestMapping("novoFilme")
	public String form() {
		return "filme/formulario";
	}
	
	@RequestMapping("adicionaFilme")
	public String adiciona(@Valid Filme filme, BindingResult result) throws ClassNotFoundException {
		daoFilme.adiciona(filme);
		return "redirect:listaFilmes";
	}
	
	@RequestMapping("mostraFilme")
    public String mostra(Long id, Model modelFilme) throws ClassNotFoundException {
        modelFilme.addAttribute("filme", daoFilme.buscaPorId(id));
        return "filme/mostra";
    }
	
	@RequestMapping("alteraFilme")
	public String altera(@Valid Filme filme, BindingResult result) throws ClassNotFoundException {
		daoFilme.altera(filme);
        return "redirect:listaFilmes";
    }
	
    @RequestMapping("removeFilme")
    public String remove(Filme filme) throws ClassNotFoundException {
    	daoFilme.remove(filme);
        return "redirect:listaFilmes";
    }
    
}