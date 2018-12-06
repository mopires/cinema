package br.com.cinema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cinema.dao.IngressoDAO;
import br.com.cinema.model.Ingresso;

@Controller
public class IngressoController {
	
    @Autowired
    IngressoDAO daoIngresso;
    
	@RequestMapping("listaIngressos")
    public String lista(Model modelIngresso) throws ClassNotFoundException {
        modelIngresso.addAttribute("ingressos", daoIngresso.lista());
        return "ingresso/lista";
    }

	@RequestMapping("novoIngresso")
	public String form() {
		return "ingresso/formulario";
	}
	
	@RequestMapping("adicionaIngresso")
	public String adiciona(@Valid Ingresso ingresso, BindingResult result) throws ClassNotFoundException {
		daoIngresso.adiciona(ingresso);
		return "redirect:listaIngressos";
	}
	
	@RequestMapping("mostraIngresso")
    public String mostra(Long id, Model modelIngresso) throws ClassNotFoundException {
        modelIngresso.addAttribute("ingresso", daoIngresso.buscaPorId(id));
        return "ingresso/mostra";
    }
	
	@RequestMapping("alteraIngresso")
	public String altera(@Valid Ingresso ingresso, BindingResult result) throws ClassNotFoundException {
		daoIngresso.altera(ingresso);
        return "redirect:listaIngressos";
    }
	
    @RequestMapping("removeIngresso")
    public String remove(Ingresso ingresso) throws ClassNotFoundException {
    	daoIngresso.remove(ingresso);
        return "redirect:listaIngressos";
    }
    
}