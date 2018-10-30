package biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.dao.LivroDAO;

import biblioteca.models.Livro;

@Controller
public class LivrosController {

	@RequestMapping("/livros/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "livros/formLivro";
	}

	@PostMapping("/livros")
	public String adicionar(Livro livro) {
		System.out.println("Chamou o método de adicionar");
		LivroDAO livroDao = new LivroDAO();
		livroDao.adicionar(livro);
		return "redirect:livros";
	}

	@GetMapping("/livros")
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		LivroDAO livroDao = new LivroDAO();
		List<Livro> lista = livroDao.getLista();
		ModelAndView model = new ModelAndView("livros/listaLivro");
		model.addObject("livros", lista);
		return model;
	}

	@RequestMapping("/livros/remover")
	public String remover(Livro livro) {
		System.out.println("Chamou o método remover");
		LivroDAO livroDao = new LivroDAO();
		livroDao.remover(livro);
		return "redirect:../livros";

	}
}
