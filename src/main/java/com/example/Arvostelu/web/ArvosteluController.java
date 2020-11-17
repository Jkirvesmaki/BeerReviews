package com.example.Arvostelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Arvostelu.model.Arvostelu;
import com.example.Arvostelu.model.ArvosteluRepository;
import com.example.Arvostelu.model.CategoryRepository;



@Controller
public class ArvosteluController {

	 @Autowired
	    private ArvosteluRepository repository;

	    @Autowired
	    private CategoryRepository crepository;
	
	    @RequestMapping(value= {"/", "/login"}, method = RequestMethod.GET)
	    public String login() {
	        return "login";
	    }
		
	  
	    @RequestMapping(value="/arvostelut")
	    public String arvostelut(Model model) {
	        model.addAttribute("arvostelu", repository.findAll());
	        return "arvostelut";

	    }
	    @RequestMapping(value="/api/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Arvostelu> findArvosteluRest(@PathVariable("id") Long Id) {    
	        return repository.findById(Id);
	    }      
	    @RequestMapping(value = "/add")
	    public String addReview(Model model){
	        model.addAttribute("arvostelu", new Arvostelu());
	        model.addAttribute("categories", crepository.findAll());
	        return "addreview";
	    }
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Arvostelu arvostelu){
	        repository.save(arvostelu);
	        return "redirect:arvostelut";
	        
	    }
	   
	    
	    @PreAuthorize("hasAuthority('ADMIN')")
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long arvosteluId, Model model) {
	    	repository.deleteById(arvosteluId);
	    	return"redirect:../arvostelut";
	    	} 
	    

	    @RequestMapping(value="/modify/{id}")
	    public String editBook(@PathVariable("id") Long arvosteluId, Model model) {
	        model.addAttribute("arvostelu", repository.findById(arvosteluId));
	        model.addAttribute("categories", crepository.findAll());
	        return "modifyreview";
	    }
	}
