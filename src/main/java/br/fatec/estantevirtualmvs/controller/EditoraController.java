package br.fatec.estantevirtualmvs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fatec.estantevirtualmvs.model.Editora;
import br.fatec.estantevirtualmvs.repository.EditoraRepository;


@Controller
@RequestMapping("/publisher/")
public class EditoraController {
	
	private final EditoraRepository editoraRepository;
	
    @Autowired
    public EditoraController( EditoraRepository editoraRepository) {
          this.editoraRepository = editoraRepository;
    }
    
    @GetMapping("register")
    public String showBookForm(Editora editora) {
        return "add-publisher";
    }
    
    @GetMapping("list")
    public String getAll(Model model) {
    	model.addAttribute("editoras", editoraRepository.findAll());
    	return "publishers";
	}
    
    @PostMapping("add")
    public String addBook(Editora editora, BindingResult result, Model model) {
    	  if (result.hasErrors()) {
              return "add-publisher";
          }
        editoraRepository.save(editora);
        return "redirect:list";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Editora editora = editoraRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		model.addAttribute("editora", editora);
		return "update-publisher";
    }

    @PostMapping("update/{id}")
    public String updateBook(@PathVariable("id") long id,  Editora editora, BindingResult result, Model model) {
    	if (result.hasErrors()) {
			editora.setId(id);
			return "update-publisher";
		}

		editoraRepository.save(editora);
		model.addAttribute("editoras", editoraRepository.findAll());
		return "index";
    		
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
    	Editora editora = editoraRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		editoraRepository.delete(editora);
		model.addAttribute("editoras", editoraRepository.findAll());
		return "publishers";
    }
}
