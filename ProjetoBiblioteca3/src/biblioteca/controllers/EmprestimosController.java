package biblioteca.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.dao.EmprestimoDAO;
import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;

@Controller
public class EmprestimosController {
	@RequestMapping("/emprestimos/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "emprestimos/formEmprestimo";
	}

	@PostMapping("/emprestimos")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println("Chamou o método de adicionar");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.inserir(emprestimo);
		return "emprestimos/listaEmprestimo";
	}

	/*@GetMapping("/emprestimos")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDao.getLista();
		ModelAndView model = new ModelAndView("emprestimos/listaEmprestimo");
		model.addObject("emprestimos", lista);
		return model;
	}

	@GetMapping("/emprestimos")
	public ModelAndView listarAbertos() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDao.getListaAbertos();
		ModelAndView model = new ModelAndView("emprestimos/listaEmpreAbertos");
		model.addObject("emprestimos", lista);
		return model;
	}

	@GetMapping("/emprestimos")
	public ModelAndView listarAtrasados() {
		System.out.println("Chamou o metódo de listagem");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDao.getListaAtraso();
		ModelAndView model = new ModelAndView("emprestimos/listaEmpreAtrasados");
		model.addObject("emprestimos", lista);
		return model;
	}

	@GetMapping("/emprestimos")
	public String qtdeEmprestimos(Aluno aluno) {
		System.out.println("Chamou o metódo de quantidade");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		try {
			emprestimoDao.qtdEmprestimos(aluno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "qtdEmprestimos";
	}

/*
 * @PostMapping("/emprestimos") public String devolucao() {
 * System.out.println("Chamou o método de adicionar"); EmprestimoDAO
 * emprestimoDAO = new EmprestimoDAO(); emprestimoDAO.devolucao(aluno, livro);
 * return "redirect:emprestimos"; }
 */
}
