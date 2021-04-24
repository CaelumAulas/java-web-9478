package br.com.caelum.tarefas.hibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class GeraTabelas {

	public static void main(String[] args) {
		
//		buscaPorStatus(false);
//		buscaPorDescricao("Primeiro insert com Hibernate");
//		adiciona();
//		pesquisaPorId(1L);
//		atualizandoComValidacaoDataFutura();
//		listaTudo();

	}
	
	public static void adiciona() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Primeiro insert com Hibernate");
		tarefa.setFinalizado(true);
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("ID gerado no insert: " + tarefa.getId());
		System.out.println(tarefa.getDescricao());
		
		manager.close();
		factory.close();
		
	}

	public static void pesquisaPorId(Long id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefaCarregada = manager.find(Tarefa.class, id);
		
		System.out.println("Tarefa ID: " + tarefaCarregada.getId());
		System.out.println("Tarefa descrição: " + tarefaCarregada.getDescricao());
		
		manager.close();
		factory.close();
		
	}
	
	public static void atualizandoComValidacaoDataFutura() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefaCarregada = manager.find(Tarefa.class, 2L);
		
		System.out.println("Tarefa ID: " + tarefaCarregada.getId());
		System.out.println("Tarefa descrição: " + tarefaCarregada.getDescricao());
		
		Calendar dataFutura = Calendar.getInstance();
		dataFutura.add(Calendar.DATE, 3);
		
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(dataFutura.getTime()));
		
		tarefaCarregada.setDataFinalizacao(dataFutura);
		tarefaCarregada.setDescricao("Alteramos com Hibernate e JPA");
		
		manager.getTransaction().begin();
		manager.merge(tarefaCarregada);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}
	
	public static void buscaPorStatus(boolean status) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		// todas as finalizadas
		List<Tarefa> tarefas = manager.createQuery("select t from Tarefa as t where t.finalizado = :status")
				.setParameter("status", status)
				.getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
		
		manager.close();
		factory.close();
		
	}
	
	public static void buscaPorDescricao(String descricao) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		// todas as finalizadas
		List<Tarefa> tarefas = manager.createQuery("select t from Tarefa as t where t.descricao = :descricao")
									.setParameter("descricao", descricao).getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
		
		manager.close();
		factory.close();
	}
	
	public static void listaTudo() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		List<Tarefa> tarefas = manager.createQuery("select t from Tarefa as t where 1=1").getResultList();
		
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa);
		}
		
		manager.close();
		factory.close();
	}
	
}
