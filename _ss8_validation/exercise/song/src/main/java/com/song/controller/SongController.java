package com.song.controller;

import com.song.model.Song;
import com.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("songList", songService.findAll(PageRequest.of(page, 2, sort)));
        return "index";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("song", song);
        redirectAttributes.addFlashAttribute("msg", "Song created successfully!!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Song song){
        songService.update(song);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        Optional<Song> song = songService.findById(id);
        songService.remove(song.get());
        return "redirect:/";
    }
}
