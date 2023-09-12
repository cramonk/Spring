package ru.cramonk.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cramonk.spring.dao.GameDAO;

@Controller
@RequestMapping("/games")
public class GamesController {
    private GameDAO gameDAO;

    @Autowired
    public GamesController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("games", gameDAO.index());
        return "games/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("game", gameDAO.show(id));
        return "games/show";
    }
}
