package com.example;

import java.util.Random;

public class MontyHallSimulation {

    private static final int TOTAL_TRIALS = 10000;

    public static void main(String[] args) {
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 0; i < TOTAL_TRIALS; i++) {
            boolean[] doors = {false, false, false}; // 3 двери
            Random random = new Random();

            // Случайно выбираем дверь с призом
            int prizeDoor = random.nextInt(3);
            doors[prizeDoor] = true;

            // Игрок выбирает дверь
            int playerChoice = random.nextInt(3);

            // Монти открывает одну из оставшихся дверей
            int montyChoice = -1;
            for (int j = 0; j < 3; j++) {
                if (j != playerChoice && !doors[j]) {
                    montyChoice = j;
                    break;
                }
            }

            // Игрок меняет выбор
            int switchChoice = 3 - playerChoice - montyChoice;

            // Проверяем, выиграл ли игрок
            if (doors[switchChoice]) {
                switchWins++;
            }
            if (doors[playerChoice]) {
                stayWins++;
            }
        }

        System.out.println("Wins by switching: " + switchWins);
        System.out.println("Wins by staying: " + stayWins);
        System.out.println("Switch win percentage: " + (switchWins * 100.0 / TOTAL_TRIALS) + "%");
        System.out.println("Stay win percentage: " + (stayWins * 100.0 / TOTAL_TRIALS) + "%");
    }
}
