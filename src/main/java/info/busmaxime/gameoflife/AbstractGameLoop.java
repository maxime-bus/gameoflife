package info.busmaxime.gameoflife;

import org.lwjgl.Sys;

/**
 * Represents the skeleton of a basic game loop. To run the game, you need to call the <strong>run</strong> method. But before this, you should redefine the following methods : <br/>
 * <ul>
 * <li><strong>init</strong>: this method is used to initialize resources.</li>
 * <li><strong>update</strong>: this method is used to update the state of the game.</li>
 * <li><strong>draw</strong>: this method is used to draw elements on the screen.</li>
 * <li><strong>isGameShouldStop</strong>: this method is used to tell the game loop to stop depending on a specified condition.</li>
 * <li><strong>shutdown</strong>: this method is used to free all resources.</li>
 * </ul>
 * <br/>
 * Basically, the run method calls the previous methods in this way : <br/><br/>
 * <pre>
 * init();
 *
 * Repeat until isGameShouldStop() returns true
 *     computeDelta();
 *     update(delta);
 *     draw();
 *
 * shutdown();
 *
 * </pre>
 *
 * @author maxime
 */
public abstract class AbstractGameLoop {

    private static long lastFrame;

    /**
     * Get the current time, in millis.
     *
     * @return the current time.
     */
    private static long getCurrentTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    /**
     * Compute time between each frame.
     *
     * @return the delta time.
     */
    private static long getDelta() {
        long currentTime = getCurrentTime();
        long delta = currentTime - lastFrame;
        lastFrame = getCurrentTime();
        return delta;
    }

    /**
     * Used to initialize resources.
     */
    public abstract void init();

    /**
     * Used to free all resources.
     */
    public abstract void shutdown();

    /**
     * Used to update the state of the game.
     *
     * @param delta elapsed time since the last update call.
     */
    public abstract void update(long delta) throws InterruptedException;

    /**
     * Used to draw sprites.
     */
    public abstract void draw();

    /**
     * Used to tell the game loop to stop, depending on a specified condition.
     *
     * @return true if the game loop should stop, false otherwise.
     */
    public abstract boolean doesTheGameMustStop();

    public void run() throws InterruptedException {
        init();

        while (!doesTheGameMustStop()) {
            long delta = getDelta();

            update(delta);

            draw();
        }

        shutdown();
    }
}