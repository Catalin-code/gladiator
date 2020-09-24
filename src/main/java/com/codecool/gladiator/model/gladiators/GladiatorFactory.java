package com.codecool.gladiator.model.gladiators;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

public class GladiatorFactory {

    private List<String> names;

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileOfNames).toURI());
            System.out.println(file.toPath());
            System.out.println(new File(getClass().getClassLoader().getResource(fileOfNames).getFile()).toPath());
            names = Files.readAllLines(file.toPath());
        }
        catch (IOException | NullPointerException | URISyntaxException e) {
//            System.out.println(Arrays.stream(e.getStackTrace()).forEach(System.out::println));
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    private String getRandomName() {
        // Todo
        return "Brutus";
    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        // Todo
        return new Brutal(getRandomName(), 50, 50, 50, 1);
    }
}
