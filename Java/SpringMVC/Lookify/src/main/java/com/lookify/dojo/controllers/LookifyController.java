package com.lookify.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.dojo.models.Lookify;
import com.lookify.dojo.services.LookifyService;

@Controller
public class LookifyController {
    
	@Autowired
	LookifyService lookifyService;
	
    @GetMapping("/")
    public String index() {

        return "welcome.jsp";
        
    }
	
    @GetMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("language") Lookify language) {
    	List<Lookify> allSongs = lookifyService.allSongs();
    	model.addAttribute("allsongs", allSongs);
    	
        return "dashboard.jsp";
        
    }
    
    @GetMapping("/songs/new")
    public String index( @ModelAttribute("song") Lookify song) {

        return "addSong.jsp";
        
    }
    
    
    @PostMapping("/songs/new")
    public String addSong(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "addSong.jsp";
        } else {
        	lookifyService.addSong(song);
        	return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Lookify song = lookifyService.findSong(id);
        model.addAttribute("song", song);
        return "edit.jsp";
    }
    
    @PutMapping("/songs/{id}")
    public String update(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            lookifyService.updateSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @DeleteMapping("/songs/{id}")
    public String destroy(@PathVariable("id") Long id) {
        lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/songs/{id}")
    public String index(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", lookifyService.findSong(id));
        return "songDetails.jsp";
    }
    
    @PostMapping("/search")
    public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
    }
    @GetMapping("/search/{artist}")
    public String searchResult(@PathVariable("artist") String artist, Model model) {
    		List<Lookify> artistSongs = lookifyService.search(artist);
    		model .addAttribute("artistSongs", artistSongs);
    		if (artistSongs.size()>0) {
    			model.addAttribute("artist", artistSongs.get(0).getArtist());
    		}else {
    			model.addAttribute("artist", artist);
    		}
    		return "SearchResult.jsp";
    }
    
    @GetMapping("/search/topTen")
    public String topTen(Model model) {
        model.addAttribute("topSongs", lookifyService.topTen());
        return "TopTen.jsp";
    }
    
    
    
    
    
}
