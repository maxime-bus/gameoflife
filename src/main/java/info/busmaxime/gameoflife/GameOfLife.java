package info.busmaxime.gameoflife;

public class GameOfLife {

    public static boolean shouldStayAlive(Boolean isCellAlive, boolean[] neighbors) {
        int numberOfNeighorsAlive = 0;

        for (boolean neighbor : neighbors) {
            if (neighbor) numberOfNeighorsAlive++;
        }

        if (numberOfNeighorsAlive == 3) {
            return true;
        }

        if (isCellAlive && numberOfNeighorsAlive == 2) {
            return true;
        }

        return false;
    }
}
