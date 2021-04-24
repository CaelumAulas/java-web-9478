package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("olaMundo")
	public String executa() {
		
		System.out.println("Devolvendo a tela de Bemvindo.jsp");
		
		return "bemvindo";
	}
	
	@RequestMapping("adiciona")
	public String adiciona() {
		
		System.out.println("Adiciona");
		
		return "bemvindo";
	}
	
	@RequestMapping("remove")
	public String remove() {
		
		System.out.println("Remove");
		
		return "bemvindo";
	}
	
	

}
