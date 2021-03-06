package agendaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import agendaspring.models.Contato;

@Controller
public class ContatosController {
	
	@RequestMapping("/contatos/form")
	public String form() {
		System.out.println("Chamou o meu m�todo");
		return "contatos/form";
	}
	
	@RequestMapping("/contatos")
	public String adicionar(Contato contato) {
		System.out.println("Chamou o m�todo de adicionar");
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endere�o: " + contato.getEndereco());
		System.out.println("Data de Nascimento: " + contato.getDataNascimento());
		return "contatos/ok";
	}

}
