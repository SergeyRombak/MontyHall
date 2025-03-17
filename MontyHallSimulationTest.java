package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MontyHallSimulationTest {

    @Test
    public void testSwitchWinsGreaterThanStayWins() {
        int trials = 10000;
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 0; i < trials; i++) {
            boolean[] doors = {false, false, false};
            int prizeDoor = (int) (Math.random() * 3);
            doors[prizeDoor] = true;

            int playerChoice = (int) (Math.random() * 3);
            int montyChoice = -1;

            for (int j = 0; j < 3; j++) {
                if (j != playerChoice && !doors[j]) {
                    montyChoice = j;
                    break;
                }
            }

            int switchChoice = 3 - playerChoice - montyChoice;

            if (doors[switchChoice]) {
                switchWins++;
            }
            if (doors[playerChoice]) {
                stayWins++;
            }
        }

        // Проверяем, что выигрыши при смене больше, чем при оставлении
        assertTrue(switchWins > stayWins, "Switching should win more often than staying.");
    }

    @Test
    public void testWinPercentages() {
        int trials = 10000;
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 0; i < trials; i++) {
            boolean[] doors = {false, false, false};
            int prizeDoor = (int) (Math.random() * 3);
            doors[prizeDoor] = true;

            int playerChoice = (int) (Math.random() * 3);
            int montyChoice = -1;

            for (int j = 0; j < 3; j++) {
                if (j != playerChoice && !doors[j]) {
                    montyChoice = j;
                    break;
                }
            }

            int switchChoice = 3 - playerChoice - montyChoice;

            if (doors[switchChoice]) {
                switchWins++;
            }
            if (doors[playerChoice]) {
                stayWins++;
            }
        }

        double switchWinPercentage = (double) switchWins / trials * 100;
        double stayWinPercentage = (double) stayWins / trials * 100;

        // Проверяем, что процент выигрышей при смене больше 66%
        assertTrue(switchWinPercentage > 66, "Switch win percentage should be greater than 66%.");
        // Проверяем, что процент выигрышей при оставлении меньше 34%
        assertTrue(stayWinPercentage < 34, "Stay win percentage should be less than 34%.");
    }
}
