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
public class AlunosController {

	@RequestMapping("/bibliotecas/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "bibliotecas/form";
	}

	@PostMapping("/bibliotecas")
	public String adicionar(Aluno aluno) {
		System.out.println("Chamou o método de adicionar");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.inserir(aluno);
		return "redirect:bibliotecas";
	}

	@GetMapping("/bibliotecas")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> lista = alunoDao.getLista();
		ModelAndView model = new ModelAndView("bibliotecas/lista");
		model.addObject("bibliotecas", lista);
		return model;
	}

	@RequestMapping("/bibliotecas/remover")
	public String remover(Aluno aluno) {
		System.out.println("Chamou o método remover");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.remover(aluno);
		return "redirect:../bibliotecas";

	}

}
