package biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.dao.AlunoDAO;
import biblioteca.models.Aluno;

@Controller
public class ContatosController {

	@RequestMapping("/contatos/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "contatos/form";
	}

	@PostMapping("/contatos")
	public String adicionar(Aluno aluno) {
		System.out.println("Chamou o método de adicionar");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.inserir(aluno);
		return "redirect:contatos";
	}

	@GetMapping("/contatos")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> lista = alunoDao.getLista();
		ModelAndView model = new ModelAndView("contatos/lista");
		model.addObject("contatos", lista);
		return model;
	}

	@RequestMapping("/contatos/remover")
	public String remover(Aluno aluno) {
		System.out.println("Chamou o método remover");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.remover(aluno);
		return "redirect:../contatos";

	}

}
