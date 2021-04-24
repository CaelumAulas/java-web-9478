package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefaController {

	@Autowired
	private JdbcTarefaDao dao;

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public ModelAndView lista() {

		List<Tarefa> tarefas = dao.lista();

		ModelAndView mv = new ModelAndView("tarefa/lista");
		mv.addObject("tarefas", tarefas);

		return mv;
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {

		dao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {

		model.addAttribute("tarefa", dao.buscaPorId(id));

		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {

		dao.altera(tarefa);

		return "redirect:listaTarefas";
	}

	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finalizaAgora(Long id) {
		dao.finaliza(id);
	}

	@RequestMapping("listaTarefas2")
	public String lista2(Model model) {

		List<Tarefa> tarefas = dao.lista();

		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}

}
