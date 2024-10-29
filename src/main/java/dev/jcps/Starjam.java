package dev.jcps;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Random;

import org.jetbrains.annotations.*;

/**
 * Decompiled by Procyon v0.6.0
 * <p>
 * STAR JAM 1.0, 1996-11-11, Steve A. Baker
 */
public class Starjam extends Panel implements Runnable, JavaAppletAdapter {
    public static final String KILLER = ">KILLER<";
    public static final String SWEET = "SWEET!";
    public static final String HOT = "*HOT*";
    public static final String COOL = "COOL";
    public static final String SO_SO = "SO-SO";
    public static final String NOVICE = "NOVICE";
    private final Random rnd;
    private int allImages;
    private int imgFlag;
    private int oldRiff;
    private int oldNextCount;
    private int mixer;
    private int tunes;
    private int lead;
    private int monolith;
    private int image1Flag;
    private transient Image ball;
    private int image2Flag;
    private transient Image c1;
    private int image3Flag;
    private transient Image c2;
    private int image4Flag;
    private transient Image c3;
    private int image5Flag;
    private transient Image c4;
    private int image6Flag;
    private transient Image rt;
    private int image7Flag;
    private transient Image lf;
    private int image8Flag;
    private transient Image sq;
    private int image9Flag;
    private transient Image goal;
    private int image10Flag;
    private transient Image gameOver;
    private transient Clip jam1;
    private transient Clip n1;
    private transient Clip n2;
    private transient Clip n3;
    private transient Clip n4;
    private transient Clip n5;
    private transient Clip n6;
    private transient Clip n7;
    private transient Clip n8;
    private transient Clip n9;
    private transient Clip n10;
    private transient Clip n11;
    private transient Clip n12;
    private transient Clip boing;
    private int aniClock;
    private int spriteX;
    private int spriteY;
    private int dx;
    private int dy;
    private int timeout;
    private int trigger;
    private int bufReady;
    private int red;
    private int pt;
    private int mapPtr;
    private int trapped;
    private int next;
    private int level;
    private int score;
    private int best;
    private int hitStar;
    private int hitStarTime;
    private int hitStartRap;
    private int jamOver;
    private int hSize;
    private int vSize;
    private final int iw;
    private final int ih;
    private int lives;
    private transient Image image;
    private transient Image gold;
    private final int[] map;
    private final int[] intro;
    private final int[] level1;
    private final int[] level2;
    private final int[] level3;
    private final int[] level4;
    private final int[] level5;
    private final int[] level6;


    private int fSpeed;
    protected transient Thread aniThread;
    Timer progress;
    transient Image bitmap;

    public Starjam() {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setSize(400, 340);
        rnd = new Random();
        this.oldRiff = -1;
        this.mixer = 1;
        this.tunes = 1;
        this.lead = 1;

        this.jam1 = null;
        this.n1 = null;
        this.n2 = null;
        this.n3 = null;
        this.n4 = null;
        this.n5 = null;
        this.n6 = null;
        this.n7 = null;
        this.n8 = null;
        this.n9 = null;
        this.n10 = null;
        this.n11 = null;
        this.n12 = null;
        this.boing = null;
        this.aniClock = 450;
        this.spriteX = 36;
        this.spriteY = 252;
        this.dx = 6;
        this.best = 1500;
        this.iw = 240;
        this.ih = 120;
        this.map = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.intro = new int[]{4, 5, 1, 5, 2, 4, 5, 3, 0, 5, 5, 3, 1, 3, 0, 5, 0, 5, 8, 5, 0, 5, 8, 2, 5, 2, 0, 5, 0, 2, 0, 1, 0, 5, 0, 3, 0, 0, 4, 0, 4, 5, 3, 0, 4, 3, 4, 3, 0, 0, 5, 0, 5, 8, 5, 0, 5, 1, 2, 5, 1, 5, 5, 0, 2, 0, 1, 0, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 1, 2, 0, 1, 2, 0, 1, 2, 6, 0, 0, 4, 3, 4, 0, 3, 4, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.level1 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        this.level2 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 2, 8, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        this.level3 = new int[]{4, 3, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 0, 4, 3, 0, 0, 0, 0, 4, 3, 0, 5, 5, 0, 1, 2, 0, 0, 0, 0, 1, 2, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 2, 8, 4, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 4, 3, 0, 0, 0, 0, 4, 3, 0, 5, 5, 0, 1, 2, 0, 0, 0, 0, 1, 2, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 1, 2};
        this.level4 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 8, 0, 0, 0, 0, 0, 0, 8, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 8, 0, 0, 0, 0, 0, 0, 8, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        this.level5 = new int[]{5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 0, 0, 0, 0, 0, 4, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 8, 5, 8, 0, 3, 0, 0, 0, 0, 0, 5, 0, 5, 8, 5, 0, 5, 0, 0, 0, 0, 0, 1, 0, 8, 5, 8, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5};
        this.level6 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    }

    @Override
    public Image getImage(@NotNull String o, String fileName) {
        Image bi = null;
        if (o.lastIndexOf("/") != o.length() - 1) {
            o = o + "/";
        }
        if (o.lastIndexOf(File.separator) != o.length() - 1) {
            o = o + File.separator;
        }
        try {
            File file = new File(o + fileName);
            bi = ImageIO.read(file);

        } catch (Exception e) {
            boolean check = false;
            URL iconPath;
            try {
                iconPath = this.getClass().getResource("/");
                assert iconPath != null;
                bi = ImageIO.read(new File((iconPath.getFile() + fileName).substring(1)));
            } catch (Exception ex) {
                String msg = null;
                try {
                    iconPath = this.getClass().getResource(File.separatorChar + fileName);
                    assert iconPath != null;
                    bi = ImageIO.read(iconPath);
                } catch (Exception eb) {
                    check = true;
                    msg += eb.getMessage();
                }
                msg += " | " + ex.getMessage();
                if (check) {
                    System.out.println("getImage error2: " + msg);
                }
            }
            if (check) {
                System.out.println("getImage error1: " + e.getMessage());
            }
        }
        return bi;
    }

    public void init() {
        setfSpeed(2);
        progress = new Timer(1500, e -> imgFlag = 1);
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        this.oldNextCount = 4;
        this.spriteX = 36;
        this.spriteY = 204;
        this.dx = 0;
        this.dy = -6;
        this.trapped = 0;
        this.trigger = 0;
        this.hitStar = 0;
        this.hitStarTime = 0;
        this.jamOver = 0;
        this.oldRiff = -1;
        this.jam1 = this.getAudioClip(this.getDocumentBase(), "jam4.wav");
        if (this.tunes == 1 && !this.jam1.isActive()) {
            this.jam1.loop(Clip.LOOP_CONTINUOUSLY);
        }

        this.ball = this.getImage(this.getCodeBase().toString(), "1ball.png");
        this.c1 = this.getImage(this.getCodeBase().toString(), "1bc1.gif");
        this.c2 = this.getImage(this.getCodeBase().toString(), "1bc2.gif");
        this.c3 = this.getImage(this.getCodeBase().toString(), "1bc3.gif");
        this.c4 = this.getImage(this.getCodeBase().toString(), "1bc4.gif");
        this.rt = this.getImage(this.getCodeBase().toString(), "1brt.gif");
        this.lf = this.getImage(this.getCodeBase().toString(), "1blf.gif");
        this.sq = this.getImage(this.getCodeBase().toString(), "1bsq.gif");
        this.goal = this.getImage(this.getCodeBase().toString(), "1bgl.gif");
        this.gameOver = this.getImage(this.getCodeBase().toString(), "1star.gif");
        this.n1 = this.getAudioClip(this.getDocumentBase(), "note1.wav");
        this.n2 = this.getAudioClip(this.getDocumentBase(), "note2.wav");
        this.n3 = this.getAudioClip(this.getDocumentBase(), "note3.wav");
        this.n4 = this.getAudioClip(this.getDocumentBase(), "note4.wav");
        this.n5 = this.getAudioClip(this.getDocumentBase(), "note5.wav");
        this.n6 = this.getAudioClip(this.getDocumentBase(), "note6.wav");
        this.n7 = this.getAudioClip(this.getDocumentBase(), "note7.wav");
        this.n8 = this.getAudioClip(this.getDocumentBase(), "note8.wav");
        this.n9 = this.getAudioClip(this.getDocumentBase(), "note9.wav");
        this.n10 = this.getAudioClip(this.getDocumentBase(), "note10.wav");
        this.n11 = this.getAudioClip(this.getDocumentBase(), "note11.wav");
        this.n12 = this.getAudioClip(this.getDocumentBase(), "note12.wav");
        this.boing = this.getAudioClip(this.getDocumentBase(), "boing.wav");
        if (this.bufReady == 0) {
            this.bitmap = this.createImage(288, 288);
            this.image = this.createImage(288, 288);
            this.gold = this.createImage(288, 288);
            this.bufReady = 1;
        }
        Graphics graphics = this.image.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 288, 288);
        if (this.score > this.best) {
            this.best = this.score;
        }
        if (this.lives == 0) {
            this.level = 0;
        }
        if (this.lives > 0) {
            livesScoreCheck();
        }
        switch (this.level) {
            case 0 -> {
                this.score = 0;
                this.lives = 6;
                System.arraycopy(this.intro, 0, this.map, 0, 144);
            }
            case 2 -> System.arraycopy(this.level2, 0, this.map, 0, 144);
            case 3 -> System.arraycopy(this.level3, 0, this.map, 0, 144);
            case 4 -> System.arraycopy(this.level4, 0, this.map, 0, 144);
            case 5 -> System.arraycopy(this.level5, 0, this.map, 0, 144);
            case 6 -> System.arraycopy(this.level6, 0, this.map, 0, 144);
            default -> System.arraycopy(this.level1, 0, this.map, 0, 144);
        }
        final Graphics graphics2 = this.getGraphics();
        graphics2.setColor(Color.black);
        graphics2.fillRect(318, 12, 48, 48);
        graphics2.setColor(Color.black);
        graphics2.fillRect(310, 265, 64, 20);
        graphics2.fillRect(310, 230, 64, 20);
        this.next = rnd.nextInt(7) + 1;
        this.oldNextCount = 3;
        graphics2.dispose();
        graphics.dispose();
        graphics = gold.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 288, 288);
        graphics.dispose();
        this.monolith = 0;
    }

    private void livesScoreCheck() {
        if (this.score >= 1500) {
            this.level = 2;
        }
        if (this.score >= 10000) {
            this.level = 3;
        }
        if (this.score >= 30000) {
            this.level = 4;
        }
        if (this.score >= 60000) {
            this.level = 5;
        }
        if (this.score >= 1000000) {
            this.level = 6;
        }
    }

    @Override
    public boolean imageUpdate(Image img, int infoFlags, int x, int y, int w, int h) {
        if ((infoFlags & 0x20) != 0x0) {
            this.imgFlag = 1;
            return false;
        }
        return true;
    }

    @Override
    public synchronized void update(final Graphics graphics) {
        this.paint(graphics);
    }

    @Override
    public void paint(final Graphics graphics) {
        int py;
        int px;
        if (this.allImages == 0) {
            this.trigger = 0;
            this.aniClock = 450;
            if (this.image1Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("When the game is running...", 20, 20);
                graphics.drawImage(this.ball, 600, 0, this);
                if (this.imgFlag == 1) {
                    this.image1Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image2Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Click on the 'NEXT' box to mix sounds...", 20, 40);
                graphics.drawImage(this.c1, 600, 0, null);
                graphics.drawImage(this.c1, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image2Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image3Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Click left or right end of 'TEMPO' bar", 20, 60);
                graphics.drawImage(this.c2, 600, 0, null);
                graphics.drawImage(this.c2, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image3Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image4Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("to change the speed of the riff ball...", 20, 72);
                graphics.drawImage(this.c3, 600, 0, null);
                graphics.drawImage(this.c3, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image4Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image5Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Remember the riff blocks drop in FRONT of", 20, 92);
                graphics.drawImage(this.c4, 600, 0, null);
                graphics.drawImage(this.c4, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image5Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image6Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("the riff ball's path...", 20, 104);
                graphics.drawImage(this.rt, 600, 0, null);
                graphics.drawImage(this.rt, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image6Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image7Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Use care when dropping the square riff block", 20, 124);
                graphics.drawImage(this.lf, 600, 0, null);
                graphics.drawImage(this.lf, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image7Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image8Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("against a wall or flat spot...", 20, 136);
                graphics.drawImage(this.sq, 600, 0, null);
                graphics.drawImage(this.sq, 600, 0, 48, 48, this);
                if (this.imgFlag == 1) {
                    this.image8Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image9Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Keyboard will also drop riff block...", 20, 156);
                graphics.drawImage(this.goal, 600, 0, this);
                if (this.imgFlag == 1) {
                    this.image9Flag = 1;
                    this.imgFlag = 0;
                }
                return;
            }
            if (this.image10Flag == 0) {
                graphics.setColor(Color.red);
                graphics.drawString("Starting Rendering Daemon...", 20, 176);
                graphics.drawImage(this.gameOver, 600, 0, this);
                if (this.imgFlag == 1) {
                    this.image10Flag = 1;
                    this.imgFlag = 0;
                    this.allImages = 1;
                }
                return;
            }
        } else if (this.jamOver == 1) {
            final Graphics graphics2 = this.image.getGraphics();
            final Graphics graphics3 = this.gold.getGraphics();
            graphics3.drawImage(this.image, 0, 0, null);
            if (this.hitStar == 1) {
                if (this.hitStarTime > 0) {
                    --this.hitStarTime;
                }
                this.dx = 0;
                this.dy = 0;
                graphics3.drawImage(this.ball, this.spriteX - 7, this.spriteY - 7, null);
                this.red = this.aniClock * 16 % 256;
                if (this.red > 127) {
                    this.red = 255 - this.red;
                }
                this.red += 127;
                switch (this.hitStartRap / 17) {
                    case 5: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("KILLER ENDING: 5,000 BONUS", 70, 100);
                        graphics3.drawString("Perfect riff! You scored a NEW guitar!", 40, 160);
                        if (this.score < 1000000 && this.level == 5) {
                            this.score = 1000000;
                        }
                        setLevelScore();
                        break;
                    }
                    case 4: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("SWEET ENDING: 4,000 BONUS", 70, 100);
                        setLevelScore();
                        break;
                    }
                    case 3: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("HOT ENDING: 3,000 BONUS", 70, 100);
                        if (this.score < 30000 && this.level == 3) {
                            this.score = 30000;
                        }
                        if (this.score < 10000 && this.level == 2) {
                            this.score = 10000;
                        }
                        break;
                    }
                    case 2: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("COOL ENDING: 2,000 BONUS", 70, 100);
                        if (this.score < 10000 && this.level == 2) {
                            this.score = 10000;
                        }
                        break;
                    }
                    case 1: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("SO-SO ENDING: 1,000 BONUS", 70, 100);
                        if (this.score < 1500 && this.level == 1) {
                            this.score = 1500;
                        }
                        break;
                    }
                    case 0:
                    default: {
                        graphics3.setColor(new Color(this.red, this.red, 0));
                        graphics3.drawString("NOVICE ENDING: 250 BONUS", 70, 100);
                    }
                }
            } else {
                this.hSize = (this.hSize + 7) % (this.iw * 2);
                int rhSize = this.hSize;
                if (rhSize > this.iw) {
                    rhSize = this.iw * 2 - this.hSize;
                }
                this.vSize = (this.vSize + 11) % (this.ih * 2);
                int rvSize = this.vSize;
                if (rvSize > this.ih) {
                    rvSize = this.ih * 2 - this.vSize;
                }
                if (this.lives == 0 && this.aniClock / 16 % 2 == 0) {
                    graphics3.drawImage(this.gameOver, 30, 80, null);
                    this.level = 0;
                } else {
                    graphics3.setColor(Color.yellow);
                    if (this.aniClock / 8 % 2 == 1) {
                        graphics3.setColor(Color.red);
                    }
                    graphics3.drawString("Bummer, broken string. You have " + this.lives + " left!", 30, 160);
                }
            }
            graphics.drawImage(this.gold, 6, 6, null);
            graphics3.dispose();
            graphics2.dispose();
            if (this.aniClock < 550) {
                this.trigger = 0;
            }
            if (this.aniClock >= 550 && this.trigger == 1) {
                if (this.tunes == 1) {
                    this.jam1.stop();
                }
                this.aniClock = 425;
                this.jamOver = 0;
                this.init();
                return;
            }
        } else if (this.aniClock < 500) {
            final Graphics graphics4 = this.image.getGraphics();
            for (int i = 0; i < 144; ++i) {
                py = i / 12;
                px = i - py * 12;
                py *= 24;
                px *= 24;
                switch (this.map[i]) {
                    case 1 -> graphics4.drawImage(this.c1, px, py, null);
                    case 2 -> graphics4.drawImage(this.c2, px, py, null);
                    case 3 -> graphics4.drawImage(this.c3, px, py, null);
                    case 4 -> graphics4.drawImage(this.c4, px, py, null);
                    case 5 -> graphics4.drawImage(this.sq, px, py, null);
                    case 6 -> graphics4.drawImage(this.rt, px, py, null);
                    case 7 -> graphics4.drawImage(this.lf, px, py, null);
                    case 8 -> graphics4.drawImage(this.goal, px, py, null);
                    default -> {/* empty  */}
                }
                graphics4.setColor(Color.darkGray);
                graphics4.drawRect(px, py, 24, 24);
            }
            graphics.setColor(Color.orange);
            graphics.drawRect(310, 6, 64, 60);
            graphics.drawString("NEXT", 328, 80);
            graphics.setColor(Color.red);
            graphics.drawString("RIFF", 310, 100);
            graphics.drawString("RATING", 310, 112);
            graphics.setColor(Color.red);
            graphics.drawRect(310, 116, 64, 90);
            graphics.setColor(Color.black);
            graphics.drawString(KILLER, 314, 130);
            graphics.drawString(SWEET, 314, 144);
            graphics.drawString(HOT, 314, 158);
            graphics.drawString(COOL, 314, 172);
            graphics.drawString(SO_SO, 314, 186);
            graphics.drawString(NOVICE, 314, 200);
            graphics.setColor(Color.red);
            graphics.drawRect(310, 230, 64, 20);
            graphics.drawString("BEST AXE", 314, 262);
            graphics.drawString(String.valueOf(this.best), 314, 246);
            graphics.setColor(Color.yellow);
            graphics.drawRect(310, 265, 64, 20);
            graphics.drawString("SCORE", 314, 297);
            graphics.drawString(String.valueOf(this.score), 314, 280);
            this.trigger = 0;
            final Graphics graphics5 = this.gold.getGraphics();
            if (this.level != 0) {
                graphics5.drawImage(this.image, 0, 0, null);
            }
            this.spriteX = 36;
            this.spriteY = 204;
            calculateAnimationTime(graphics5);
            switch (this.level) {
                case 0 -> {
                    graphics4.drawString("CORNER", 117, 239);
                    graphics4.drawString("RIGHT Turn", 211, 275);
                    graphics4.drawString("LEFT Turn", 4, 275);
                    graphics4.setColor(Color.yellow);
                    graphics4.drawString("So you wanna be a Rock and Roll Star.", 10, 154);
                    graphics4.drawString("Just JAM the blocks, both near and far,", 10, 166);
                    graphics4.drawString("When the Riff is Sweet'n Hot. End it in", 10, 178);
                    graphics4.drawString("the STAR and See what you Got.........", 10, 190);
                    graphics4.setColor(Color.red);
                    graphics4.drawString("Adjust the tempo of Riff Ball before Jamming! --> ", 10, 206);
                    graphics4.setColor(Color.orange);
                    graphics4.drawString("(c)19961111, Steve A. Baker, All Rights Reserved", 2, 288);
                    graphics5.drawImage(this.image, 0, 0, null);
                }
                case 1 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("BASIC TRAINING", 100, 80);
                        graphics5.drawString("Next tour stop at 1,500", 80, 94);
                        graphics5.drawString("SO-SO ending warps to next level", 60, 108);
                    }
                }
                case 2 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("CORNER GIG", 100, 80);
                        graphics5.drawString("Next tour stop at 10,000", 80, 94);
                        graphics5.drawString("COOL ending warps to next level", 60, 108);
                    }
                }
                case 3 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("DIAMOND CLUB", 100, 80);
                        graphics5.drawString("Next tour stop at 30,000", 80, 94);
                        graphics5.drawString("HOT ending warps to next level", 60, 108);
                    }
                }
                case 4 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("PACKED HOUSE", 100, 80);
                        graphics5.drawString("Next tour stop at 60,000", 80, 94);
                        graphics5.drawString("SWEET ending warps to next level", 60, 108);
                    }
                }
                case 5 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("STAR STADIUM", 100, 80);
                        graphics5.drawString("Next tour stop at 1,000,000", 80, 94);
                        graphics5.drawString("KILLER ending warps to final level", 60, 108);
                    }
                }
                case 6 -> {
                    if (this.aniClock < 490) {
                        graphics5.drawString("FINAL LEVEL", 110, 80);
                        graphics5.drawString("Excellent picking, original, top notch", 50, 94);
                        graphics5.drawString("The world is yours!", 90, 108);
                    }
                }
                default -> {/* empty */}
            }
            graphics.drawImage(this.gold, 6, 6, null);
            graphics5.dispose();
            graphics4.dispose();
        } else {
            this.spriteX += this.dx;
            this.spriteY += this.dy;
            if (this.spriteX < 0) {
                this.spriteX += 288;
            }
            if (this.spriteX >= 288) {
                this.spriteX -= 288;
            }
            if (this.spriteY < 0) {
                this.spriteY += 288;
            }
            if (this.spriteY >= 288) {
                this.spriteY -= 288;
            }
            final Graphics graphics6 = this.image.getGraphics();
            if (this.level == 0) {
                calculateAnimationTime(graphics6);
                graphics6.drawString("CORNER", 117, 239);
                graphics6.drawString("RIGHT Turn", 211, 275);
                graphics6.drawString("LEFT Turn", 4, 275);
            }
            int lastData = this.mapPtr;
            this.mapPtr = this.spriteY / 24 * 12 + this.spriteX / 24;
            int mapData = this.map[this.mapPtr];
            px = this.spriteX / 24 * 24;
            py = this.spriteY / 24 * 24;
            if (mapData != 0 && this.hitStar == 0) {
                ++this.trapped;
            } else if (this.trapped > 1) {
                this.trapped -= 2;
            }
            if (this.trapped > 100 && this.hitStar == 0) {
                this.jamOver = 1;
                this.aniClock = 475;
                if (this.lead == 1) {
                    this.boing.start();
                }
                if (this.lives > 0) {
                    --this.lives;
                }
            }
            if (this.aniClock < 550) {
                this.trigger = 0;
            }
            if (this.trigger == 1 && mapData == 0 && lastData == this.mapPtr) {
                this.trigger = 0;
                this.timeout = 0;
                this.map[this.mapPtr] = this.next;
                this.spriteX = px + 12 - this.dx;
                this.spriteY = py + 12 - this.dy;
                this.score += 10;
                switch (this.next) {
                    case 1 -> graphics6.drawImage(this.c1, px, py, null);
                    case 2 -> graphics6.drawImage(this.c2, px, py, null);
                    case 3 -> graphics6.drawImage(this.c3, px, py, null);
                    case 4 -> graphics6.drawImage(this.c4, px, py, null);
                    case 5 -> graphics6.drawImage(this.sq, px, py, null);
                    case 6 -> graphics6.drawImage(this.rt, px, py, null);
                    case 7 -> graphics6.drawImage(this.lf, px, py, null);
                    default -> {/* empty */}
                }
                graphics6.setColor(Color.darkGray);
                graphics6.drawRect(px, py, 24, 24);
                graphics.setColor(Color.black);
                graphics.fillRect(318, 12, 48, 48);
                this.next = rnd.nextInt(7) + 1;
                this.oldNextCount = 1;
            }
            if (this.oldNextCount > 0) {
                this.oldNextCount = 0;
                switch (this.next) {
                    case 1 -> graphics.drawImage(this.c1, 318, 12, 48, 48, null);
                    case 2 -> graphics.drawImage(this.c2, 318, 12, 48, 48, null);
                    case 3 -> graphics.drawImage(this.c3, 318, 12, 48, 48, null);
                    case 4 -> graphics.drawImage(this.c4, 318, 12, 48, 48, null);
                    case 5 -> graphics.drawImage(this.sq, 318, 12, 48, 48, null);
                    case 6 -> graphics.drawImage(this.rt, 318, 12, 48, 48, null);
                    case 7 -> graphics.drawImage(this.lf, 318, 12, 48, 48, null);
                    default -> {/* empty */}
                }
            }
            final Graphics graphics7 = this.gold.getGraphics();
            graphics7.drawImage(this.image, 0, 0, null);
            if (this.trapped < 101 && this.aniClock > 550) {
                graphics7.drawImage(this.ball, this.spriteX - 7, this.spriteY - 7, null);
            }
            if (mapData == 8 && this.timeout == 0 && this.level != 0 && this.hitStar == 0) {
                this.hitStar = 1;
                this.hitStarTime = 100;
                this.hitStartRap = this.trapped;
                this.jamOver = 1;
                this.score += 1000 * (this.hitStartRap / 17);
                if (this.hitStartRap / 17 == 0) {
                    this.score += 250;
                }
            }
            if (mapData > 0 && this.timeout == 0 && lastData == this.mapPtr) {
                if (mapData != 8 && this.aniClock > 550 && this.lead == 1) {
                    switch ((this.spriteX / 24 + this.spriteY / 24) % 12) {
                        case 0 -> this.n1.start();
                        case 1 -> this.n2.start();
                        case 2 -> this.n3.start();
                        case 3 -> this.n4.start();
                        case 4 -> this.n5.start();
                        case 5 -> this.n6.start();
                        case 6 -> this.n7.start();
                        case 7 -> this.n8.start();
                        case 8 -> this.n9.start();
                        case 9 -> this.n10.start();
                        case 10 -> this.n11.start();
                        case 11 -> this.n12.start();
                        default -> {/* empty */}
                    }
                }
                switch (mapData) {
                    case 1 -> {
                        if (this.dx < 0) {
                            this.dx = -this.dx;
                            break;
                        }
                        if (this.dy > 0) {
                            this.dy = -this.dy;
                            break;
                        }
                        calculatePoints();
                    }
                    case 2 -> {
                        if (this.dx > 0) {
                            this.dx = -this.dx;
                            break;
                        }
                        if (this.dy > 0) {
                            this.dy = -this.dy;
                            break;
                        }
                        calculatePoints2();
                    }
                    case 3 -> {
                        if (this.dx > 0) {
                            this.dx = -this.dx;
                            break;
                        }
                        if (this.dy < 0) {
                            this.dy = -this.dy;
                            break;
                        }
                        calculatePoints();
                    }
                    case 4 -> {
                        if (this.dx < 0) {
                            this.dx = -this.dx;
                            break;
                        }
                        if (this.dy < 0) {
                            this.dy = -this.dy;
                            break;
                        }
                        calculatePoints2();
                    }
                    case 5 -> {
                        this.dx = -this.dx;
                        this.dy = -this.dy;
                    }
                    case 6 -> {
                        if (this.dx != 0) {
                            this.pt = this.dy;
                            this.dy = this.dx;
                            this.dx = this.pt;
                            break;
                        }
                        this.pt = this.dx;
                        this.dx = -this.dy;
                        this.dy = this.pt;
                    }
                    case 7 -> {
                        if (this.dx != 0) {
                            this.pt = this.dy;
                            this.dy = -this.dx;
                            this.dx = this.pt;
                            break;
                        }
                        this.pt = this.dx;
                        this.dx = this.dy;
                        this.dy = this.pt;
                    }
                    default -> {/*empty*/}
                }
                this.timeout = 4;
            }
            if (this.timeout > 0) {
                --this.timeout;
            }
            graphics.drawImage(this.gold, 6, 6, null);
            graphics7.dispose();
            graphics6.dispose();
            switch (this.trapped / 17) {
                case 5 -> {
                    if (this.oldRiff != 5) {
                        graphics.setColor(Color.white);
                        graphics.drawString(KILLER, 314, 130);
                        this.oldRiff = 5;
                    }
                }
                case 4 -> {
                    if (this.oldRiff != 4) {
                        graphics.setColor(Color.orange);
                        graphics.drawString(SWEET, 314, 144);
                        graphics.setColor(Color.black);
                        graphics.drawString(KILLER, 314, 130);
                        this.oldRiff = 4;
                    }
                }
                case 3 -> {
                    if (this.oldRiff != 3) {
                        graphics.setColor(Color.red);
                        graphics.drawString(HOT, 314, 158);
                        graphics.setColor(Color.black);
                        graphics.drawString(SWEET, 314, 144);
                        this.oldRiff = 3;
                    }
                }
                case 2 -> {
                    if (this.oldRiff != 2) {
                        graphics.setColor(Color.blue);
                        graphics.drawString(COOL, 314, 172);
                        graphics.setColor(Color.black);
                        graphics.drawString(HOT, 314, 158);
                        this.oldRiff = 2;
                    }
                }
                case 1 -> {
                    if (this.oldRiff != 1) {
                        graphics.setColor(Color.green);
                        graphics.drawString(SO_SO, 314, 186);
                        graphics.setColor(Color.black);
                        graphics.drawString(COOL, 314, 172);
                        this.oldRiff = 1;
                    }
                }
                case 0 -> {
                    if (this.oldRiff != 0) {
                        graphics.setColor(Color.magenta);
                        graphics.drawString(NOVICE, 314, 200);
                        graphics.setColor(Color.black);
                        graphics.drawString(SO_SO, 314, 186);
                        this.oldRiff = 0;
                    }
                }
                default -> {/* empty */}
            }
        }
        if (this.monolith == 0) {
            this.monolith = 1;
            graphics.setColor(Color.black);
            graphics.drawString("TEMPO", 315, 226);
            int i = 1;
            while (i <= 16) {
                graphics.setColor(Color.red);
                if (i <= getfSpeed()) {
                    graphics.setColor(Color.orange);
                }
                graphics.fillOval(305 + i * 4, 210, 5, 5);
                graphics.setColor(Color.black);
                graphics.drawOval(305 + i * 4, 210, 5, 5);
                ++i;
            }
        }
    }

    private void calculatePoints2() {
        if (this.dx != 0) {
            this.pt = this.dy;
            this.dy = -this.dx;
            this.dx = this.pt;
            return;
        }
        this.pt = this.dx;
        this.dx = -this.dy;
        this.dy = this.pt;
    }

    private void calculatePoints() {
        if (this.dx != 0) {
            this.pt = this.dy;
            this.dy = this.dx;
            this.dx = this.pt;
            return;
        }
        this.pt = this.dx;
        this.dx = this.dy;
        this.dy = this.pt;
    }

    private void calculateAnimationTime(Graphics graphics) {
        this.red = this.aniClock * 16 % 256;
        if (this.red > 127) {
            this.red = 255 - this.red;
        }
        this.red += 127;
        graphics.setColor(new Color(this.red, 0, 0));
    }

    private void setLevelScore() {
        if (this.score < 60000 && this.level == 4) {
            this.score = 60000;
        }
        if (this.score < 30000 && this.level == 3) {
            this.score = 30000;
        }
        if (this.score < 10000 && this.level == 2) {
            this.score = 10000;
        }
    }

    public void start() {
        this.aniThread = new Thread(this);
        this.aniThread.start();
    }

    public void stop() {
        this.jam1.stop();
        this.progress.stop();
    }

    public void run() {
        ++aniClock;
        this.repaint();
        if (!progress.isRunning() && allImages != 1) {
            progress.start();
        }

    }

    @Override
    public void processEvent(final AWTEvent evt) {
        if (evt.getID() == 201) {
            System.exit(0);
        }
    }

    @Override
    public boolean keyDown(final Event event, final int n) {
        if (this.level == 0) {
            ++this.level;
            this.init();
            this.aniClock = 425;
        } else if (this.aniClock > 500) {
            this.trigger = 1;
        }
        return true;
    }

    @Override
    public boolean mouseDown(final Event event, final int n, final int n2) {
        if (n > 300 && n < 320 && n2 < 240 && n2 > 180) {
            this.monolith = 0;
            setfSpeed(getfSpeed() - 1);
            if (getfSpeed() < 1) {
                setfSpeed(1);
            }
            return true;
        }
        if (n >= 360 && n2 < 240 && n2 > 180) {
            this.monolith = 0;
            setfSpeed(getfSpeed() + 1);
            if (getfSpeed() > 16) {
                setfSpeed(16);
            }
            return true;
        }
        if (n >= 304 && n2 < 70) {
            n304();
            return true;
        }
        if (this.level == 0 && n < 300) {
            ++this.level;
            this.init();
            this.aniClock = 425;
        } else if (this.aniClock > 500 && n < 300) {
            this.trigger = 1;
            return true;
        }
        return false;
    }

    private void n304() {
        this.mixer = (this.mixer + 1) % 3;
        switch (this.mixer) {
            case 0 -> {
                this.lead = 0;
                this.tunes = 0;
                this.jam1.stop();
            }
            case 1 -> {
                this.lead = 1;
                this.tunes = 0;
                this.n5.start();
                this.n7.start();
                this.n9.start();
            }
            case 2 -> {
                this.lead = 1;
                this.tunes = 1;
                this.n5.start();
                this.jam1.stop();
                this.jam1.loop(Clip.LOOP_CONTINUOUSLY);
            }
            default -> {/* empty */}
        }
    }

    public int getfSpeed() {
        return fSpeed;
    }

    public void setfSpeed(int fSpeed) {
        this.fSpeed = fSpeed;
    }
}
