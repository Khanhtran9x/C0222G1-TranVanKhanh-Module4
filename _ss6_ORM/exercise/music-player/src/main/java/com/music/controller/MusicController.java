package com.music.controller;

import com.music.model.Music;
import com.music.service.IMusicPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    private IMusicPlayerService musicPlayerService;

    @GetMapping("")
    public String showIndex(Model model){
        model.addAttribute("musicList", musicPlayerService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music){
        musicPlayerService.save(music);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("music", musicPlayerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music){
        musicPlayerService.update(music);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
     musicPlayerService.remove(musicPlayerService.findById(id));
     return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(String songName, Model model){
        model.addAttribute("musicList", musicPlayerService.searchByName(songName));
        return "index";
    }
}
