package ru.cramonk.spring.dao;

import org.springframework.stereotype.Component;
import ru.cramonk.spring.models.Game;

import java.util.ArrayList;
import java.util.List;
@Component
public class GameDAO {
    private static int GAMES_COUNT;
    private List<Game> games;

    {
        games = new ArrayList<>();
        games.add(new Game(++GAMES_COUNT, "Dark souls"));
        games.add(new Game(++GAMES_COUNT, "Hollow knight"));
        games.add(new Game(++GAMES_COUNT, "Armored Core 6"));
        games.add(new Game(++GAMES_COUNT, "The Witcher 3"));
    }

    public List<Game> index() {
        return games;
    }

    public Game show(int id) {
        return games.stream().filter(game -> game.getId()==id).findAny().orElse(null);
    }
}
