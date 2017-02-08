package info.busmaxime.gameoflife;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Renderer {

    public Renderer() {
        try {
            Display.setDisplayMode(new DisplayMode(500, 500));
            Display.create();
        } catch (LWJGLException ex) {
            System.exit(0);
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 500, 500, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void draw(Space space) {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);


        Cell[][] cells = space.getState();

        for (int row = 0; row <= space.getMaxRowsZeroBased(); row++) {
            for (int column = 0; column <= space.getMaxColumnsZeroBased(); column++) {
                if (cells[row][column].isAlive()) {

                    GL11.glColor3f(1f, (float) row / (float) space.getMaxRowsZeroBased(), (float) column / (float) space.getMaxColumnsZeroBased());

                    GL11.glBegin(GL11.GL_QUADS);
                    GL11.glVertex2f((column * 5), (row * 5));
                    GL11.glVertex2f((column * 5), (row * 5) + 5);
                    GL11.glVertex2f((column * 5) + 5, (row * 5) + 5);
                    GL11.glVertex2f((column * 5) + 5, (row * 5));
                    GL11.glEnd();
                }
            }
        }

        Display.update();
    }

    public void shutdown() {
        Display.destroy();
    }
}
