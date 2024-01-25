import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Survive the attack waves
 **/
class TestAgent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int playerId = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < height; i++) {
            String line = in.nextLine();
        }

        int cnt =0;
        // game loop
        while (true) {
            int myMoney = in.nextInt();
            int myLives = in.nextInt();
            int opponentMoney = in.nextInt();
            int opponentLives = in.nextInt();
            int towerCount = in.nextInt();
            for (int i = 0; i < towerCount; i++) {
                String towerType = in.next();
                int towerId = in.nextInt();
                int owner = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int damage = in.nextInt();
                float attackRange = in.nextFloat();
                int reload = in.nextInt();
                int coolDown = in.nextInt();
            }
            int attackerCount = in.nextInt();
            for (int i = 0; i < attackerCount; i++) {
                int attackerId = in.nextInt();
                int owner = in.nextInt();
                float x = in.nextFloat();
                float y = in.nextFloat();
                int hitPoints = in.nextInt();
                int maxHitPoints = in.nextInt();
                float currentSpeed = in.nextFloat();
                float maxSpeed = in.nextFloat();
                int slowTime = in.nextInt();
                int bounty = in.nextInt();
            }

            // Write an action using System.out.println()
            System.err.println("Debug messages... here "+cnt);
            cnt++;

            System.out.println("BUILD 5 5 GUNTOWER"); // BUILD x y TOWER | UPGRADE id PROPERTY
        }
    }
}