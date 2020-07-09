package br.fatec.estantevirtualmvs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fatec.estantevirtualmvs.model.Livro;
import br.fatec.estantevirtualmvs.repository.LivroRepository;


@Controller
@RequestMapping("/books/")
public class LivroController {
	
	private final LivroRepository livroRepository;
	
    @Autowired
    public LivroController( LivroRepository livroRepository) {
          this.livroRepository = livroRepository;
    }
    
    @GetMapping("register")
    public String showBookForm(Livro livro) {
        return "add-book";
    }
    
    @GetMapping("list")
    public String getAll(Model model) {
    	model.addAttribute("livros", livroRepository.findAll());
    	return "index";
	}
    
    @PostMapping("add")
    public String addBook(Livro livro, BindingResult result, Model model) {
    	  if (result.hasErrors()) {
              return "add-book";
          }
        livroRepository.save(livro);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		model.addAttribute("livro", livro);
		return "update-book";
    }

    @PostMapping("update/{id}")
    public String updateBook(@PathVariable("id") long id,  Livro livro, BindingResult result, Model model) {
    	if (result.hasErrors()) {
			livro.setId(id);
			return "update-student";
		}

		livroRepository.save(livro);
		model.addAttribute("livros", livroRepository.findAll());
		return "index";
    		
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		livroRepository.delete(livro);
		model.addAttribute("livros", livroRepository.findAll());
		return "index";
    }
}
