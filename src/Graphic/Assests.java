package Graphic;

import Graphic.ImageLoader;
import Graphic.SpriteSource;

import java.awt.image.BufferedImage;

public class Assests {

    public static BufferedImage[] down;
    public static BufferedImage[] up;
    public static BufferedImage[] left;
    public static BufferedImage[] right;
    public static BufferedImage[] idle;
    public static BufferedImage floorboard, brick, rock, sand, cobblestone;
    public static BufferedImage[] start;
    public static BufferedImage[] humanoid;
    public static BufferedImage[] healthbar;
    public static BufferedImage handsanitizer;
    public static BufferedImage[] retry;
    public static BufferedImage menubackground;
    public static BufferedImage[] redgirl;
    public static BufferedImage[] corona;
    private int w, h = 100;
    public static void init() {
        BufferedImage testimage = ImageLoader.loadimage( "res" + sep + "trump_run.png");
        SpriteSource sheet = new SpriteSource(testimage);
        down = new BufferedImage[6];
        down[1] = sheet.crop(0,0, 100, 100);
        down[2] = sheet.crop(100,0, 100, 100);
        down[3] = sheet.crop(200,0, 100, 100);
        down[4] = sheet.crop(300,0, 100, 100);
        down[5] = sheet.crop(400,0, 100, 100);
        down[0] = sheet.crop(500,0, 100, 100);
        up = new BufferedImage[6];
        up[1] = sheet.crop(0,200, 100, 100);
        up[2] = sheet.crop(100,200, 100, 100);
        up[3] = sheet.crop(200,200, 100, 100);
        up[4] = sheet.crop(300,200, 100, 100);
        up[5] = sheet.crop(400,200, 100, 100);
        up[0] = sheet.crop(500,200, 100, 100);
        left = new BufferedImage[6];
        left[1] = sheet.crop(0,300, 100, 100);
        left[2] = sheet.crop(100,300, 100, 100);
        left[3] = sheet.crop(200,300, 100, 100);
        left[4] = sheet.crop(300,300, 100, 100);
        left[5] = sheet.crop(400,300, 100, 100);
        left[0] = sheet.crop(500,300, 100, 100);
        right = new BufferedImage[6];
        right[1] = sheet.crop(0,100, 100, 100);
        right[2] = sheet.crop(100,100, 100, 100);
        right[3] = sheet.crop(200,100, 100, 100);
        right[4] = sheet.crop(300,100, 100, 100);
        right[5] = sheet.crop(400,100, 100, 100);
        right[0] = sheet.crop(500,100, 100, 100);
        BufferedImage idleimage = ImageLoader.loadimage( "res" + sep + "trump_iddle.png");
        SpriteSource idlesheet = new SpriteSource(idleimage);
        idle = new BufferedImage[10];
        idle[0] = idlesheet.crop(0,0, 256, 256);
        idle[1] = idlesheet.crop(256*1,0, 256, 256);
        idle[2] = idlesheet.crop(256*2,0, 256, 256);
        idle[3] = idlesheet.crop(256*3,0, 256, 256);
        idle[4] = idlesheet.crop(256*4,0, 256, 256);
        idle[5] = idlesheet.crop(256*5,0, 256, 256);
        idle[6] = idlesheet.crop(256*6,0, 256, 256);
        idle[7] = idlesheet.crop(256*7,0, 256, 256);
        idle[8] = idlesheet.crop(256*8,0, 256, 256);
        idle[9] = idlesheet.crop(256*9,0, 256, 256);
        BufferedImage tileimage = ImageLoader.loadimage( "res" + sep + "tiles.jpg");
        SpriteSource tiles = new SpriteSource(tileimage);
        floorboard = tiles.crop(25,340, 285,285);
        floorboard = ImageLoader.loadimage( "res" + sep + "floorboard.png");
        rock = tiles.crop(330,20, 290,290);
        brick = tiles.crop(650,20, 290,290);
        sand = tiles.crop(960,20, 290,290);
        sand = ImageLoader.loadimage( "res" + sep + "sand.png");
        BufferedImage startnohover = ImageLoader.loadimage( "res" + sep + "startnohover.png");
        BufferedImage starthover = ImageLoader.loadimage( "res" + sep + "starthover.png");
        start = new BufferedImage[2];
        start[0] = startnohover;
        start[1] = starthover;
        BufferedImage humanimage = ImageLoader.loadimage( "res" + sep + "human.png");
        SpriteSource human = new SpriteSource(humanimage);
        humanoid = new BufferedImage[3];
        humanoid[0] = human.crop(0,0,96,96);
        humanoid[1] = human.crop(96,0, 96,96);
        humanoid[2] = human.crop(192, 0, 96,96);
        BufferedImage healthimage = ImageLoader.loadimage( "res" + sep + "healthbars.png");
        SpriteSource health = new SpriteSource(healthimage);
        healthbar = new BufferedImage[11];
        healthbar[10] = health.crop(0,0,450,122);
        healthbar[9] = health.crop(0,122,450,122);
        healthbar[8] = health.crop(0,122*2,450,122);
        healthbar[7] = health.crop(0,122*3,450,122);
        healthbar[6] = health.crop(0,122*4,450,122);
        healthbar[5] = health.crop(450,0,450,122);
        healthbar[4] = health.crop(450,122,450,122);
        healthbar[3] = health.crop(450,122*2,450,122);
        healthbar[2] = health.crop(450,122*3,450,122);
        healthbar[0] = health.crop(450,122*4,450,122);
        healthbar[1] = health.crop(450,122*5,450,122);
        handsanitizer = ImageLoader.loadimage( "res" + sep + "handsanit.png");
        retry = new BufferedImage[2];
        retry[0] = ImageLoader.loadimage( "res" + sep + "gameover.png");
        retry[1] = ImageLoader.loadimage( "res" + sep + "gameoverhover.png");
        menubackground = ImageLoader.loadimage( "res" + sep + "menubackground.jpg");
        BufferedImage redimage = ImageLoader.loadimage( "res" + sep + "redgirlidle.png");
        SpriteSource reddy = new SpriteSource(redimage);
        redgirl = new BufferedImage[4];
        redgirl[0] = reddy.crop(0,0,48,48);
        redgirl[1] = reddy.crop(48,0,48,48);
        redgirl[2] = reddy.crop(96,0,48,48);
        redgirl[3] = reddy.crop(48*3,0,48,48);
        cobblestone = ImageLoader.loadimage( "res" + sep + "32cobblestone.png");
        BufferedImage coronaimage = ImageLoader.loadimage( "res" + sep + "corona.png");
        SpriteSource beer = new SpriteSource(coronaimage);
        corona = new BufferedImage[3];
        corona[0] = beer.crop(0,0,32,32);
        corona[1] = beer.crop(32,0,32,32);
        corona[2] = beer.crop(64,0,32,32);



    }

    private static String sep = System.getProperty("file.separator");
}
