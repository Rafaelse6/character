package com.rafaelsantos.character.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rafaelsantos.character.entities.Character;

@Controller
public class CharacterResource {
	
	List<Character> characters = new ArrayList<>();
	
	@GetMapping("/create")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("create");
		mv.addObject("character", new Character());
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("characters", characters);
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("create");

		Character characterFind = characters.stream().filter(character -> id.equals(character.getId())).findFirst().get();
		mv.addObject("character", characterFind);
		return mv;
	}
	
	@PostMapping("/create")
	public String create(Character character) {
		
		if (character.getId() != null) {
			Character characterFind = characters.stream().filter(characterItem -> character.getId().equals(characterItem.getId())).findFirst().get();
			characters.set(characters.indexOf(characterFind), character);
		} else {
			Long id = characters.size() + 1L;
			characters.add(new Character(id, character.getName(), character.getWorld()));
		}
		return "redirect:/list";
	}
}
