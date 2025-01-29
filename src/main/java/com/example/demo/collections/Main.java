package com.example.demo.collections;

import java.util.*;
import java.util.concurrent.Callable;

class Player {
    String name;
    Integer score;

    Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Player> players = new ArrayList<>();
        
        // Read input
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            players.add(new Player(name, score));
        }

        Comparator<Player> cmp=(p1,p2)-> {int k=p2.getScore()
                .compareTo(p1.getScore());
            if (k==0) {
                return p1.getName().compareTo(p2.getName());
            }
        return k;};

        // Sort using Java 8 Comparator and Lambda expression
        players.stream().sorted(cmp).forEach(System.out::println);

        // Output the sorted players
        players.forEach(System.out::println);
    }
}
