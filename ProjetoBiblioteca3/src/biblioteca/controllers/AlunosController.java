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

	@RequestMapping("/alunos/form")
	public String form() {
		System.out.println("Chamou o meu m�todo");
		return "alunos/formAluno";
	}

	@PostMapping("/alunos")
	public String adicionar(Aluno aluno) {
		System.out.println("Chamou o m�todo de adicionar");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.inserir(aluno);
		return "redirect:alunos";
	}

	@GetMapping("/alunos")
	public ModelAndView listar() {
		System.out.println("Chamou o met�do de listagem");
		AlunoDAO alunoDao = new AlunoDAO();
		List<Aluno> lista = alunoDao.getLista();
		ModelAndView model = new ModelAndView("alunos/listaAluno");
		model.addObject("alunos", lista);
		return model;
	}

	@RequestMapping("/alunos/remover")
	public String remover(Aluno aluno) {
		System.out.println("Chamou o m�todo remover");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.remover(aluno);
		return "redirect:../alunos";

	}

}
