package info.busmaxime.gameoflife;

import org.lwjgl.opengl.Display;

import java.io.IOException;
import java.util.Random;

public class Main extends AbstractGameLoop {

    private Renderer renderer = new Renderer();
    private Space space = new Space(Main.randomize(100, 100));

    public static void main(String[] args) throws IOException, InterruptedException {

        new Main().run();
    }


    public static Cell[][] randomize(int rows, int columns) {
        Random random = new Random();

        Cell[][] space = new Cell[rows][columns];

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                space[i][j] = random.nextBoolean() ? Cell.livingCell() : Cell.deadCell();
            }
        }

        return space;
    }

    @Override
    public void init() {

    }

    @Override
    public void shutdown() {
        renderer.shutdown();
    }

    @Override
    public void update(long delta) throws InterruptedException {

    }

    @Override
    public void draw() {
        renderer.draw(this.space);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        space.computeNewSpace();
    }

    @Override
    public boolean doesTheGameMustStop() {
        if (Display.isCloseRequested()) {
            return true;
        }
        return false;
    }
}
