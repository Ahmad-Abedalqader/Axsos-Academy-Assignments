package com.relationships.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.relationships.dojo.models.Category;
import com.relationships.dojo.models.Product;
import com.relationships.dojo.services.CategServ;
import com.relationships.dojo.services.ProdServ;

@Controller
public class mainCont {
    
	@Autowired
	ProdServ prodServ;
	@Autowired
	CategServ categServ;
	
	@GetMapping("/")
	public String start() {
		return "welcome.jsp";	
	}
    
    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "NewProduct.jsp"; 
    }
    
    
    @PostMapping("/products/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "NewProduct.jsp";
        } else {
        	prodServ.createProduct(product);
        	return "redirect:/products/"+product.getId();
        }
    }
    
    @GetMapping("/categories/new")
    public String newCateg(@ModelAttribute("category") Category categ, Model model) {
    	return "NewCategory.jsp";
    }
    
    
    @PostMapping("/categories/new")
    public String createCateg(@Valid @ModelAttribute("category") Category categ, BindingResult result) {
        if (result.hasErrors()) {
            return "NewCategory.jsp";
        } else {
        	categServ.createCateg(categ);
        	return "redirect:/categories/"+categ.getId();
        }
    }
    
    @GetMapping ("/categories/{categ_id}")
    public String showCategory ( @PathVariable("categ_id") Long id, Model model){
    	Category thisCategory = categServ.findCateg(id);
    	model.addAttribute("category", thisCategory);
    	model.addAttribute("nonOwnedProd", prodServ.allCategNotContain(thisCategory));
    	return "CategDetails.jsp";
    }
    @PostMapping ("/categories/{categ_id}")
    public String showProduct ( @PathVariable("categ_id") Long id, Model model,
    							@RequestParam("myProd_id") Long prod_id){
    	Category thisCategory = categServ.findCateg(id);
    	Product thisProduct = prodServ.findProduct(prod_id);
    	categServ.associate(thisProduct, thisCategory);
    	return "redirect:/categories/"+id;
    }
    
    
    
    @GetMapping ("/products/{product_id}")
    public String showProduct(@PathVariable("product_id") Long id, Model model){
    	Product thisProduct = prodServ.findProduct(id);
    	model.addAttribute("product", thisProduct);
    	model.addAttribute("nonOwnedCateg", categServ.allCategNotContain(thisProduct));
    	return "ProductDetails.jsp";
    }
    @PostMapping ("/products/{product_id}")
    public String showCategory ( @PathVariable("product_id") Long id, Model model,
    							@RequestParam("myCateg_id") Long categ_id){
    	Category thisCategory = categServ.findCateg(categ_id);
    	Product thisProduct = prodServ.findProduct(id);
    	categServ.associate(thisProduct, thisCategory);
    	return "redirect:/products/"+id;
    }
    
    
}
