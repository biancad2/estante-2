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
        model.addAttribute("livro", livroRepository.findById(id));
        return "update-book";
    }

    @PostMapping("update/{id}")
    public String updateBook(@PathVariable("id") long id,  Livro livro, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            livro.setId(id);
            return "update-book";
        }

        livroRepository.save(livro);
        model.addAttribute("livros", livroRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	Livro _livro = livroRepository.findById(id);
        livroRepository.delete(livroRepository.findById(id));
        model.addAttribute("livros", studentRepository.findAll());
        return "index";
    }
}
