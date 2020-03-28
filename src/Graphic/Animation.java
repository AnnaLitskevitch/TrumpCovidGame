package Graphic;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int index;
    private long lasttime;
    private long timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lasttime = System.currentTimeMillis();
        timer = 0;
    }

    public BufferedImage getcurrentframe() {
        return frames[index];

    }

    public void tick() {
        timer += System.currentTimeMillis() - lasttime;
        lasttime = System.currentTimeMillis();
        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }

    }

}
