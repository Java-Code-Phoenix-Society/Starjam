package dev.jcps;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Decompiled by Procyon v0.6.0
 * <p>
 * STAR JAM 1.0, 1996-11-11, Steve A. Baker
 */
public class Starjam extends Panel implements Runnable, JavaAppletAdapter {
    protected static int allImages;
    protected static int i;
    protected static int imgFlag;
    protected static int SOB;
    protected static int goldClock;
    protected static int oldRiff;
    protected static int oldNext;
    protected static int oldNextCount;
    protected static int mixer;
    protected static int tunes;
    protected static int lead;
    protected static int monolith;
    protected static int image1Flag;
    protected static Image ball;
    protected static int image2Flag;
    protected static Image c1;
    protected static int image3Flag;
    protected static Image c2;
    protected static int image4Flag;
    protected static Image c3;
    protected static int image5Flag;
    protected static Image c4;
    protected static int image6Flag;
    protected static Image rt;
    protected static int image7Flag;
    protected static Image lf;
    protected static int image8Flag;
    protected static Image sq;
    protected static int image9Flag;
    protected static Image goal;
    protected static int image10Flag;
    protected static Image gameOver;
    protected static Clip jam1;
    protected static Clip lead1;
    protected static Clip n1;
    protected static Clip n2;
    protected static Clip n3;
    protected static Clip n4;
    protected static Clip n5;
    protected static Clip n6;
    protected static Clip n7;
    protected static Clip n8;
    protected static Clip n9;
    protected static Clip n10;
    protected static Clip n11;
    protected static Clip n12;
    protected static Clip boing;
    protected static int aniClock;
    protected static int spriteX;
    protected static int spriteY;
    protected static int dx;
    protected static int dy;
    protected static int timeout;
    protected static int trigger;
    protected static int bufReady;
    protected static int red;
    protected static int px;
    protected static int py;
    protected static int pt;
    protected static int mapPtr;
    protected static int mapData;
    protected static int trapped;
    protected static int lastData;
    protected static int next;
    protected static int level;
    protected static int score;
    protected static int best;
    protected static int hitStar;
    protected static int hitStarTime;
    protected static int hitStartRap;
    protected static int jamOver;
    protected static int hSize;
    protected static int rhSize;
    protected static int vSize;
    protected static int rvSize;
    protected static int iw;
    protected static int ih;
    protected static int lives;
    static Image image;
    static Image gold;
    static int[] map;
    static int[] intro;
    static int[] level1;
    static int[] level2;
    static int[] level3;
    static int[] level4;
    static int[] level5;
    static int[] level6;

    static {
        Starjam.oldRiff = -1;
        Starjam.oldNext = -1;
        Starjam.mixer = 1;
        Starjam.tunes = 1;
        Starjam.lead = 1;
        Starjam.jam1 = null;
        Starjam.lead1 = null;
        Starjam.n1 = null;
        Starjam.n2 = null;
        Starjam.n3 = null;
        Starjam.n4 = null;
        Starjam.n5 = null;
        Starjam.n6 = null;
        Starjam.n7 = null;
        Starjam.n8 = null;
        Starjam.n9 = null;
        Starjam.n10 = null;
        Starjam.n11 = null;
        Starjam.n12 = null;
        Starjam.boing = null;
        Starjam.aniClock = 450;
        Starjam.spriteX = 36;
        Starjam.spriteY = 252;
        Starjam.dx = 6;
        Starjam.best = 1500;
        Starjam.iw = 240;
        Starjam.ih = 120;
        Starjam.map = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Starjam.intro = new int[]{4, 5, 1, 5, 2, 4, 5, 3, 0, 5, 5, 3, 1, 3, 0, 5, 0, 5, 8, 5, 0, 5, 8, 2, 5, 2, 0, 5, 0, 2, 0, 1, 0, 5, 0, 3, 0, 0, 4, 0, 4, 5, 3, 0, 4, 3, 4, 3, 0, 0, 5, 0, 5, 8, 5, 0, 5, 1, 2, 5, 1, 5, 5, 0, 2, 0, 1, 0, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 1, 2, 0, 1, 2, 0, 1, 2, 6, 0, 0, 4, 3, 4, 0, 3, 4, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Starjam.level1 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Starjam.level2 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 2, 8, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Starjam.level3 = new int[]{4, 3, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 0, 4, 3, 0, 0, 0, 0, 4, 3, 0, 5, 5, 0, 1, 2, 0, 0, 0, 0, 1, 2, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 2, 8, 4, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 4, 3, 0, 0, 0, 0, 4, 3, 0, 5, 5, 0, 1, 2, 0, 0, 0, 0, 1, 2, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 1, 2};
        Starjam.level4 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 8, 0, 0, 0, 0, 0, 0, 8, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 8, 0, 0, 0, 0, 0, 0, 8, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Starjam.level5 = new int[]{5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 0, 0, 0, 0, 0, 4, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 8, 5, 8, 0, 3, 0, 0, 0, 0, 0, 5, 0, 5, 8, 5, 0, 5, 0, 0, 0, 0, 0, 1, 0, 8, 5, 8, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5};
        Starjam.level6 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public int fSpeed;
    protected Thread aniThread;
    Timer progress;
    Image bitmap;

    public Starjam() {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setSize(400, 340);
    }

    public Image getImage(String o, String fileName) {
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
                    iconPath = this.getClass().getResource("/" + fileName);
                    assert iconPath != null;
                    bi = ImageIO.read(iconPath);
                } catch (Exception eb) {
                    check = true;
                    msg += eb.getMessage();
                }
                msg += " | " + ex.getMessage();
                System.out.println("getImage error2: " + msg);
            }
            if (check) {
                System.out.println("getImage error1: " + e.getMessage());
            }
        }
        return bi;
    }

    public void init() {
        fSpeed = 2;
        progress = new Timer(1500, e -> imgFlag = 1);
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        Starjam.oldNextCount = 4;
        Starjam.spriteX = 36;
        Starjam.spriteY = 204;
        Starjam.dx = 0;
        Starjam.dy = -6;
        Starjam.trapped = 0;
        Starjam.trigger = 0;
        Starjam.hitStar = 0;
        Starjam.hitStarTime = 0;
        Starjam.jamOver = 0;
        Starjam.oldRiff = -1;
        Starjam.oldNext = -1;
        Starjam.jam1 = this.getAudioClip(this.getDocumentBase(), "jam4.wav");
        if (Starjam.tunes == 1) {
            if (!Starjam.jam1.isActive()) {
                Starjam.jam1.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        Starjam.ball = this.getImage(this.getCodeBase().toString(), "1ball.png");
        Starjam.c1 = this.getImage(this.getCodeBase().toString(), "1bc1.gif");
        Starjam.c2 = this.getImage(this.getCodeBase().toString(), "1bc2.gif");
        Starjam.c3 = this.getImage(this.getCodeBase().toString(), "1bc3.gif");
        Starjam.c4 = this.getImage(this.getCodeBase().toString(), "1bc4.gif");
        Starjam.rt = this.getImage(this.getCodeBase().toString(), "1brt.gif");
        Starjam.lf = this.getImage(this.getCodeBase().toString(), "1blf.gif");
        Starjam.sq = this.getImage(this.getCodeBase().toString(), "1bsq.gif");
        Starjam.goal = this.getImage(this.getCodeBase().toString(), "1bgl.gif");
        Starjam.gameOver = this.getImage(this.getCodeBase().toString(), "1star.gif");
        Starjam.n1 = this.getAudioClip(this.getDocumentBase(), "note1.wav");
        Starjam.n2 = this.getAudioClip(this.getDocumentBase(), "note2.wav");
        Starjam.n3 = this.getAudioClip(this.getDocumentBase(), "note3.wav");
        Starjam.n4 = this.getAudioClip(this.getDocumentBase(), "note4.wav");
        Starjam.n5 = this.getAudioClip(this.getDocumentBase(), "note5.wav");
        Starjam.n6 = this.getAudioClip(this.getDocumentBase(), "note6.wav");
        Starjam.n7 = this.getAudioClip(this.getDocumentBase(), "note7.wav");
        Starjam.n8 = this.getAudioClip(this.getDocumentBase(), "note8.wav");
        Starjam.n9 = this.getAudioClip(this.getDocumentBase(), "note9.wav");
        Starjam.n10 = this.getAudioClip(this.getDocumentBase(), "note10.wav");
        Starjam.n11 = this.getAudioClip(this.getDocumentBase(), "note11.wav");
        Starjam.n12 = this.getAudioClip(this.getDocumentBase(), "note12.wav");
        Starjam.boing = this.getAudioClip(this.getDocumentBase(), "boing.wav");
        if (Starjam.bufReady == 0) {
            this.bitmap = this.createImage(288, 288);
            Starjam.image = this.createImage(288, 288);
            Starjam.gold = this.createImage(288, 288);
            Starjam.bufReady = 1;
        }
        Graphics graphics = Starjam.image.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 288, 288);
        if (Starjam.score > Starjam.best) {
            Starjam.best = Starjam.score;
        }
        if (Starjam.lives == 0) {
            Starjam.level = 0;
        }
        if (Starjam.lives > 0) {
            if (Starjam.score >= 1500) {
                Starjam.level = 2;
            }
            if (Starjam.score >= 10000) {
                Starjam.level = 3;
            }
            if (Starjam.score >= 30000) {
                Starjam.level = 4;
            }
            if (Starjam.score >= 60000) {
                Starjam.level = 5;
            }
            if (Starjam.score >= 1000000) {
                Starjam.level = 6;
            }
        }
        switch (Starjam.level) {
            case 0 -> {
                Starjam.score = 0;
                Starjam.lives = 6;
                System.arraycopy(Starjam.intro, 0, Starjam.map, 0, 144);
            }
            case 2 -> System.arraycopy(Starjam.level2, 0, Starjam.map, 0, 144);
            case 3 -> System.arraycopy(Starjam.level3, 0, Starjam.map, 0, 144);
            case 4 -> System.arraycopy(Starjam.level4, 0, Starjam.map, 0, 144);
            case 5 -> System.arraycopy(Starjam.level5, 0, Starjam.map, 0, 144);
            case 6 -> System.arraycopy(Starjam.level6, 0, Starjam.map, 0, 144);
            default -> System.arraycopy(Starjam.level1, 0, Starjam.map, 0, 144);
        }
        final Graphics graphics2 = this.getGraphics();
        graphics2.setColor(Color.black);
        graphics2.fillRect(318, 12, 48, 48);
        graphics2.setColor(Color.black);
        graphics2.fillRect(310, 265, 64, 20);
        graphics2.fillRect(310, 230, 64, 20);
        Starjam.next = (int) (Math.random() * 7.0) + 1;
        Starjam.oldNextCount = 3;
        graphics2.dispose();
        graphics.dispose();
        graphics = gold.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 288, 288);
        graphics.dispose();
        Starjam.monolith = 0;
    }

    public boolean imageUpdate(Image img, int infoFlags, int x, int y, int w, int h) {
        if ((infoFlags & 0x20) != 0x0) {
            Starjam.imgFlag = 1;
            return false;
        }
        return true;
    }

    public synchronized void update(final Graphics graphics) {
        this.paint(graphics);
    }

    public void paint(final Graphics graphics) {
        if (Starjam.allImages == 0) {
            Starjam.trigger = 0;
            Starjam.goldClock = 0;
            Starjam.aniClock = 450;
            Starjam.SOB = 1;
            if (Starjam.image1Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("When the game is running...", 20, 20);
                graphics.drawImage(Starjam.ball, 600, 0, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image1Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image2Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Click on the 'NEXT' box to mix sounds...", 20, 40);
                graphics.drawImage(Starjam.c1, 600, 0, null);
                graphics.drawImage(Starjam.c1, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image2Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image3Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Click left or right end of 'TEMPO' bar", 20, 60);
                graphics.drawImage(Starjam.c2, 600, 0, null);
                graphics.drawImage(Starjam.c2, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image3Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image4Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("to change the speed of the riff ball...", 20, 72);
                graphics.drawImage(Starjam.c3, 600, 0, null);
                graphics.drawImage(Starjam.c3, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image4Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image5Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Remember the riff blocks drop in FRONT of", 20, 92);
                graphics.drawImage(Starjam.c4, 600, 0, null);
                graphics.drawImage(Starjam.c4, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image5Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image6Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("the riff ball's path...", 20, 104);
                graphics.drawImage(Starjam.rt, 600, 0, null);
                graphics.drawImage(Starjam.rt, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image6Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image7Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Use care when dropping the square riff block", 20, 124);
                graphics.drawImage(Starjam.lf, 600, 0, null);
                graphics.drawImage(Starjam.lf, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image7Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image8Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("against a wall or flat spot...", 20, 136);
                graphics.drawImage(Starjam.sq, 600, 0, null);
                graphics.drawImage(Starjam.sq, 600, 0, 48, 48, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image8Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image9Flag == 0) {
                graphics.setColor(Color.cyan);
                graphics.drawString("Keyboard will also drop riff block...", 20, 156);
                graphics.drawImage(Starjam.goal, 600, 0, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image9Flag = 1;
                    Starjam.imgFlag = 0;
                }
                return;
            }
            if (Starjam.image10Flag == 0) {
                graphics.setColor(Color.red);
                graphics.drawString("Starting Rendering Daemon...", 20, 176);
                graphics.drawImage(Starjam.gameOver, 600, 0, this);
                if (Starjam.imgFlag == 1) {
                    Starjam.image10Flag = 1;
                    Starjam.imgFlag = 0;
                    Starjam.allImages = 1;
                }
                return;
            }
        } else if (Starjam.jamOver == 1) {
            final Graphics graphics2 = Starjam.image.getGraphics();
            final Graphics graphics3 = Starjam.gold.getGraphics();
            graphics3.drawImage(Starjam.image, 0, 0, null);
            if (Starjam.hitStar == 1) {
                if (Starjam.hitStarTime > 0) {
                    --Starjam.hitStarTime;
                }
                Starjam.dx = 0;
                Starjam.dy = 0;
                graphics3.drawImage(Starjam.ball, Starjam.spriteX - 7, Starjam.spriteY - 7, null);
                Starjam.red = Starjam.aniClock * 16 % 256;
                if (Starjam.red > 127) {
                    Starjam.red = 255 - Starjam.red;
                }
                Starjam.red += 127;
                switch (Starjam.hitStartRap / 17) {
                    case 5 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("KILLER ENDING: 5,000 BONUS", 70, 100);
                        graphics3.drawString("Perfect riff! You scored a NEW guitar!", 40, 160);
                        if (Starjam.score < 1000000 && Starjam.level == 5) {
                            Starjam.score = 1000000;
                        }
                        setLevelScore();
                    }
                    case 4 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("SWEET ENDING: 4,000 BONUS", 70, 100);
                        setLevelScore();
                    }
                    case 3 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("HOT ENDING: 3,000 BONUS", 70, 100);
                        if (Starjam.score < 30000 && Starjam.level == 3) {
                            Starjam.score = 30000;
                        }
                        if (Starjam.score < 10000 && Starjam.level == 2) {
                            Starjam.score = 10000;
                        }
                    }
                    case 2 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("COOL ENDING: 2,000 BONUS", 70, 100);
                        if (Starjam.score < 10000 && Starjam.level == 2) {
                            Starjam.score = 10000;
                        }
                    }
                    case 1 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("SO-SO ENDING: 1,000 BONUS", 70, 100);
                        if (Starjam.score < 1500 && Starjam.level == 1) {
                            Starjam.score = 1500;
                        }
                    }
                    case 0 -> {
                        graphics3.setColor(new Color(Starjam.red, Starjam.red, 0));
                        graphics3.drawString("NOVICE ENDING: 250 BONUS", 70, 100);
                    }
                }
            } else {
                Starjam.hSize = (Starjam.hSize + 7) % (Starjam.iw * 2);
                Starjam.rhSize = Starjam.hSize;
                if (Starjam.rhSize > Starjam.iw) {
                    Starjam.rhSize = Starjam.iw * 2 - Starjam.hSize;
                }
                Starjam.vSize = (Starjam.vSize + 11) % (Starjam.ih * 2);
                Starjam.rvSize = Starjam.vSize;
                if (Starjam.rvSize > Starjam.ih) {
                    Starjam.rvSize = Starjam.ih * 2 - Starjam.vSize;
                }
                if (Starjam.lives == 0 && Starjam.aniClock / 16 % 2 == 0) {
                    graphics3.drawImage(Starjam.gameOver, 30, 80, null);
                    Starjam.level = 0;
                } else {
                    graphics3.setColor(Color.yellow);
                    if (Starjam.aniClock / 8 % 2 == 1) {
                        graphics3.setColor(Color.red);
                    }
                    graphics3.drawString("Bummer, broken string. You have " + Starjam.lives + " left!", 30, 160);
                }
            }
            graphics.drawImage(Starjam.gold, 6, 6, null);
            graphics3.dispose();
            graphics2.dispose();
            if (Starjam.aniClock < 550) {
                Starjam.trigger = 0;
            }
            if (Starjam.aniClock >= 550 && Starjam.trigger == 1) {
                if (Starjam.tunes == 1) {
                    Starjam.jam1.stop();
                }
                Starjam.aniClock = 425;
                Starjam.jamOver = 0;
                this.init();
                Starjam.SOB = 1;
                return;
            }
        } else if (Starjam.aniClock < 500) {
            final Graphics graphics4 = Starjam.image.getGraphics();
            for (int i = 0; i < 144; ++i) {
                Starjam.py = i / 12;
                Starjam.px = i - Starjam.py * 12;
                Starjam.py *= 24;
                Starjam.px *= 24;
                switch (Starjam.map[i]) {
                    case 1 -> graphics4.drawImage(Starjam.c1, Starjam.px, Starjam.py, null);
                    case 2 -> graphics4.drawImage(Starjam.c2, Starjam.px, Starjam.py, null);
                    case 3 -> graphics4.drawImage(Starjam.c3, Starjam.px, Starjam.py, null);
                    case 4 -> graphics4.drawImage(Starjam.c4, Starjam.px, Starjam.py, null);
                    case 5 -> graphics4.drawImage(Starjam.sq, Starjam.px, Starjam.py, null);
                    case 6 -> graphics4.drawImage(Starjam.rt, Starjam.px, Starjam.py, null);
                    case 7 -> graphics4.drawImage(Starjam.lf, Starjam.px, Starjam.py, null);
                    case 8 -> graphics4.drawImage(Starjam.goal, Starjam.px, Starjam.py, null);
                }
                graphics4.setColor(Color.darkGray);
                graphics4.drawRect(Starjam.px, Starjam.py, 24, 24);
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
            graphics.drawString(">KILLER<", 314, 130);
            graphics.drawString("SWEET!", 314, 144);
            graphics.drawString("*HOT*", 314, 158);
            graphics.drawString("COOL", 314, 172);
            graphics.drawString("SO-SO", 314, 186);
            graphics.drawString("NOVICE", 314, 200);
            graphics.setColor(Color.red);
            graphics.drawRect(310, 230, 64, 20);
            graphics.drawString("BEST AXE", 314, 262);
            graphics.drawString(String.valueOf(Starjam.best), 314, 246);
            graphics.setColor(Color.yellow);
            graphics.drawRect(310, 265, 64, 20);
            graphics.drawString("SCORE", 314, 297);
            graphics.drawString(String.valueOf(Starjam.score), 314, 280);
            Starjam.trigger = 0;
            final Graphics graphics5 = Starjam.gold.getGraphics();
            if (Starjam.level != 0) {
                graphics5.drawImage(Starjam.image, 0, 0, null);
            }
            Starjam.spriteX = 36;
            Starjam.spriteY = 204;
            calculateAnimationTime(graphics5);
            switch (Starjam.level) {
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
                    graphics5.drawImage(Starjam.image, 0, 0, null);
                }
                case 1 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("BASIC TRAINING", 100, 80);
                        graphics5.drawString("Next tour stop at 1,500", 80, 94);
                        graphics5.drawString("SO-SO ending warps to next level", 60, 108);
                    }
                }
                case 2 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("CORNER GIG", 100, 80);
                        graphics5.drawString("Next tour stop at 10,000", 80, 94);
                        graphics5.drawString("COOL ending warps to next level", 60, 108);
                    }
                }
                case 3 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("DIAMOND CLUB", 100, 80);
                        graphics5.drawString("Next tour stop at 30,000", 80, 94);
                        graphics5.drawString("HOT ending warps to next level", 60, 108);
                    }
                }
                case 4 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("PACKED HOUSE", 100, 80);
                        graphics5.drawString("Next tour stop at 60,000", 80, 94);
                        graphics5.drawString("SWEET ending warps to next level", 60, 108);
                    }
                }
                case 5 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("STAR STADIUM", 100, 80);
                        graphics5.drawString("Next tour stop at 1,000,000", 80, 94);
                        graphics5.drawString("KILLER ending warps to final level", 60, 108);
                    }
                }
                case 6 -> {
                    if (Starjam.aniClock < 490) {
                        graphics5.drawString("FINAL LEVEL", 110, 80);
                        graphics5.drawString("Excellent picking, original, top notch", 50, 94);
                        graphics5.drawString("The world is yours!", 90, 108);
                    }
                }
            }
            graphics.drawImage(Starjam.gold, 6, 6, null);
            graphics5.dispose();
            graphics4.dispose();
        } else {
            Starjam.spriteX += Starjam.dx;
            Starjam.spriteY += Starjam.dy;
            if (Starjam.spriteX < 0) {
                Starjam.spriteX += 288;
            }
            if (Starjam.spriteX >= 288) {
                Starjam.spriteX -= 288;
            }
            if (Starjam.spriteY < 0) {
                Starjam.spriteY += 288;
            }
            if (Starjam.spriteY >= 288) {
                Starjam.spriteY -= 288;
            }
            final Graphics graphics6 = Starjam.image.getGraphics();
            if (Starjam.level == 0) {
                calculateAnimationTime(graphics6);
                graphics6.drawString("CORNER", 117, 239);
                graphics6.drawString("RIGHT Turn", 211, 275);
                graphics6.drawString("LEFT Turn", 4, 275);
            }
            Starjam.lastData = Starjam.mapPtr;
            Starjam.mapPtr = Starjam.spriteY / 24 * 12 + Starjam.spriteX / 24;
            Starjam.mapData = Starjam.map[Starjam.mapPtr];
            Starjam.px = Starjam.spriteX / 24 * 24;
            Starjam.py = Starjam.spriteY / 24 * 24;
            if (Starjam.mapData != 0 && Starjam.hitStar == 0) {
                ++Starjam.trapped;
            } else if (Starjam.trapped > 1) {
                Starjam.trapped -= 2;
            }
            if (Starjam.trapped > 100 && Starjam.hitStar == 0) {
                Starjam.jamOver = 1;
                Starjam.aniClock = 475;
                if (Starjam.lead == 1) {
                    Starjam.boing.start();
                }
                if (Starjam.lives > 0) {
                    --Starjam.lives;
                }
            }
            if (Starjam.aniClock < 550) {
                Starjam.trigger = 0;
            }
            if (Starjam.trigger == 1 && Starjam.mapData == 0 && Starjam.lastData == Starjam.mapPtr) {
                Starjam.trigger = 0;
                Starjam.timeout = 0;
                Starjam.map[Starjam.mapPtr] = Starjam.next;
                Starjam.spriteX = Starjam.px + 12 - Starjam.dx;
                Starjam.spriteY = Starjam.py + 12 - Starjam.dy;
                Starjam.score += 10;
                switch (Starjam.next) {
                    case 1 -> graphics6.drawImage(Starjam.c1, Starjam.px, Starjam.py, null);
                    case 2 -> graphics6.drawImage(Starjam.c2, Starjam.px, Starjam.py, null);
                    case 3 -> graphics6.drawImage(Starjam.c3, Starjam.px, Starjam.py, null);
                    case 4 -> graphics6.drawImage(Starjam.c4, Starjam.px, Starjam.py, null);
                    case 5 -> graphics6.drawImage(Starjam.sq, Starjam.px, Starjam.py, null);
                    case 6 -> graphics6.drawImage(Starjam.rt, Starjam.px, Starjam.py, null);
                    case 7 -> graphics6.drawImage(Starjam.lf, Starjam.px, Starjam.py, null);
                }
                graphics6.setColor(Color.darkGray);
                graphics6.drawRect(Starjam.px, Starjam.py, 24, 24);
                graphics.setColor(Color.black);
                graphics.fillRect(318, 12, 48, 48);
                Starjam.next = (int) (Math.random() * 7.0) + 1;
                Starjam.oldNextCount = 1;
            }
            if (Starjam.oldNextCount > 0) {
                Starjam.oldNextCount = 0;
                switch (Starjam.next) {
                    case 1 -> graphics.drawImage(Starjam.c1, 318, 12, 48, 48, null);
                    case 2 -> graphics.drawImage(Starjam.c2, 318, 12, 48, 48, null);
                    case 3 -> graphics.drawImage(Starjam.c3, 318, 12, 48, 48, null);
                    case 4 -> graphics.drawImage(Starjam.c4, 318, 12, 48, 48, null);
                    case 5 -> graphics.drawImage(Starjam.sq, 318, 12, 48, 48, null);
                    case 6 -> graphics.drawImage(Starjam.rt, 318, 12, 48, 48, null);
                    case 7 -> graphics.drawImage(Starjam.lf, 318, 12, 48, 48, null);
                }
            }
            final Graphics graphics7 = Starjam.gold.getGraphics();
            graphics7.drawImage(Starjam.image, 0, 0, null);
            if (Starjam.trapped < 101 && Starjam.aniClock > 550) {
                graphics7.drawImage(Starjam.ball, Starjam.spriteX - 7, Starjam.spriteY - 7, null);
            }
            if (Starjam.mapData == 8 && Starjam.timeout == 0 && Starjam.level != 0 && Starjam.hitStar == 0) {
                Starjam.hitStar = 1;
                Starjam.hitStarTime = 100;
                Starjam.hitStartRap = Starjam.trapped;
                Starjam.jamOver = 1;
                Starjam.score += 1000 * (Starjam.hitStartRap / 17);
                if (Starjam.hitStartRap / 17 == 0) {
                    Starjam.score += 250;
                }
            }
            if (Starjam.mapData > 0 && Starjam.timeout == 0 && Starjam.lastData == Starjam.mapPtr) {
                if (Starjam.mapData != 8 && Starjam.aniClock > 550 && Starjam.lead == 1) {
                    switch ((Starjam.spriteX / 24 + Starjam.spriteY / 24) % 12) {
                        case 0 -> Starjam.n1.start();
                        case 1 -> Starjam.n2.start();
                        case 2 -> Starjam.n3.start();
                        case 3 -> Starjam.n4.start();
                        case 4 -> Starjam.n5.start();
                        case 5 -> Starjam.n6.start();
                        case 6 -> Starjam.n7.start();
                        case 7 -> Starjam.n8.start();
                        case 8 -> Starjam.n9.start();
                        case 9 -> Starjam.n10.start();
                        case 10 -> Starjam.n11.start();
                        case 11 -> Starjam.n12.start();
                    }
                }
                switch (Starjam.mapData) {
                    case 1 -> {
                        if (Starjam.dx < 0) {
                            Starjam.dx = -Starjam.dx;
                            break;
                        }
                        if (Starjam.dy > 0) {
                            Starjam.dy = -Starjam.dy;
                            break;
                        }
                        calculatePoints();
                    }
                    case 2 -> {
                        if (Starjam.dx > 0) {
                            Starjam.dx = -Starjam.dx;
                            break;
                        }
                        if (Starjam.dy > 0) {
                            Starjam.dy = -Starjam.dy;
                            break;
                        }
                        calculatePoints2();
                    }
                    case 3 -> {
                        if (Starjam.dx > 0) {
                            Starjam.dx = -Starjam.dx;
                            break;
                        }
                        if (Starjam.dy < 0) {
                            Starjam.dy = -Starjam.dy;
                            break;
                        }
                        calculatePoints();
                    }
                    case 4 -> {
                        if (Starjam.dx < 0) {
                            Starjam.dx = -Starjam.dx;
                            break;
                        }
                        if (Starjam.dy < 0) {
                            Starjam.dy = -Starjam.dy;
                            break;
                        }
                        calculatePoints2();
                    }
                    case 5 -> {
                        Starjam.dx = -Starjam.dx;
                        Starjam.dy = -Starjam.dy;
                    }
                    case 6 -> {
                        if (Starjam.dx != 0) {
                            Starjam.pt = Starjam.dy;
                            Starjam.dy = Starjam.dx;
                            Starjam.dx = Starjam.pt;
                            break;
                        }
                        Starjam.pt = Starjam.dx;
                        Starjam.dx = -Starjam.dy;
                        Starjam.dy = Starjam.pt;
                    }
                    case 7 -> {
                        if (Starjam.dx != 0) {
                            Starjam.pt = Starjam.dy;
                            Starjam.dy = -Starjam.dx;
                            Starjam.dx = Starjam.pt;
                            break;
                        }
                        Starjam.pt = Starjam.dx;
                        Starjam.dx = Starjam.dy;
                        Starjam.dy = Starjam.pt;
                    }
                }
                Starjam.timeout = 4;
            }
            if (Starjam.timeout > 0) {
                --Starjam.timeout;
            }
            graphics.drawImage(Starjam.gold, 6, 6, null);
            graphics7.dispose();
            graphics6.dispose();
            switch (Starjam.trapped / 17) {
                case 5 -> {
                    if (Starjam.oldRiff != 5) {
                        graphics.setColor(Color.white);
                        graphics.drawString(">KILLER<", 314, 130);
                        Starjam.oldRiff = 5;
                    }
                }
                case 4 -> {
                    if (Starjam.oldRiff != 4) {
                        graphics.setColor(Color.orange);
                        graphics.drawString("SWEET!", 314, 144);
                        graphics.setColor(Color.black);
                        graphics.drawString(">KILLER<", 314, 130);
                        Starjam.oldRiff = 4;
                    }
                }
                case 3 -> {
                    if (Starjam.oldRiff != 3) {
                        graphics.setColor(Color.red);
                        graphics.drawString("*HOT*", 314, 158);
                        graphics.setColor(Color.black);
                        graphics.drawString("SWEET!", 314, 144);
                        Starjam.oldRiff = 3;
                    }
                }
                case 2 -> {
                    if (Starjam.oldRiff != 2) {
                        graphics.setColor(Color.blue);
                        graphics.drawString("COOL", 314, 172);
                        graphics.setColor(Color.black);
                        graphics.drawString("*HOT*", 314, 158);
                        Starjam.oldRiff = 2;
                    }
                }
                case 1 -> {
                    if (Starjam.oldRiff != 1) {
                        graphics.setColor(Color.green);
                        graphics.drawString("SO-SO", 314, 186);
                        graphics.setColor(Color.black);
                        graphics.drawString("COOL", 314, 172);
                        Starjam.oldRiff = 1;
                    }
                }
                case 0 -> {
                    if (Starjam.oldRiff != 0) {
                        graphics.setColor(Color.magenta);
                        graphics.drawString("NOVICE", 314, 200);
                        graphics.setColor(Color.black);
                        graphics.drawString("SO-SO", 314, 186);
                        Starjam.oldRiff = 0;
                    }
                }
            }
        }
        if (Starjam.monolith == 0) {
            Starjam.monolith = 1;
            graphics.setColor(Color.black);
            graphics.drawString("TEMPO", 315, 226);
            Starjam.i = 1;
            while (Starjam.i <= 16) {
                graphics.setColor(Color.red);
                if (Starjam.i <= fSpeed) {
                    graphics.setColor(Color.orange);
                }
                graphics.fillOval(305 + Starjam.i * 4, 210, 5, 5);
                graphics.setColor(Color.black);
                graphics.drawOval(305 + Starjam.i * 4, 210, 5, 5);
                ++Starjam.i;
            }
        }
    }

    private void calculatePoints2() {
        if (Starjam.dx != 0) {
            Starjam.pt = Starjam.dy;
            Starjam.dy = -Starjam.dx;
            Starjam.dx = Starjam.pt;
            return;
        }
        Starjam.pt = Starjam.dx;
        Starjam.dx = -Starjam.dy;
        Starjam.dy = Starjam.pt;
    }

    private void calculatePoints() {
        if (Starjam.dx != 0) {
            Starjam.pt = Starjam.dy;
            Starjam.dy = Starjam.dx;
            Starjam.dx = Starjam.pt;
            return;
        }
        Starjam.pt = Starjam.dx;
        Starjam.dx = Starjam.dy;
        Starjam.dy = Starjam.pt;
    }

    private void calculateAnimationTime(Graphics graphics) {
        Starjam.red = Starjam.aniClock * 16 % 256;
        if (Starjam.red > 127) {
            Starjam.red = 255 - Starjam.red;
        }
        Starjam.red += 127;
        graphics.setColor(new Color(Starjam.red, 0, 0));
    }

    private void setLevelScore() {
        if (Starjam.score < 60000 && Starjam.level == 4) {
            Starjam.score = 60000;
        }
        if (Starjam.score < 30000 && Starjam.level == 3) {
            Starjam.score = 30000;
        }
        if (Starjam.score < 10000 && Starjam.level == 2) {
            Starjam.score = 10000;
        }
    }

    public void start() {
        this.aniThread = new Thread(this);
        this.aniThread.start();
    }

    public void stop() {
        Starjam.jam1.stop();
        this.progress.stop();
    }

    public void run() {
        SOB = 0;
        ++aniClock;
        this.repaint();
        if (!progress.isRunning() && allImages != 1) {
            progress.start();
        }

    }

    public void processEvent(final AWTEvent evt) {
        if (evt.getID() == 201) {
            System.exit(0);
        }
    }

    public boolean keyDown(final Event event, final int n) {
        if (Starjam.level == 0) {
            ++Starjam.level;
            this.init();
            Starjam.aniClock = 425;
        } else if (Starjam.aniClock > 500) {
            Starjam.trigger = 1;
        }
        return true;
    }

    public boolean mouseDown(final Event event, final int n, final int n2) {
        if (n > 300 && n < 320 && n2 < 240 && n2 > 180) {
            Starjam.monolith = 0;
            --fSpeed;
            if (fSpeed < 1) {
                fSpeed = 1;
            }
            return true;
        }
        if (n >= 360 && n2 < 240 && n2 > 180) {
            Starjam.monolith = 0;
            ++fSpeed;
            if (fSpeed > 16) {
                fSpeed = 16;
            }
            return true;
        }
        if (n >= 304 && n2 < 70) {
            switch (Starjam.mixer = (Starjam.mixer + 1) % 3) {
                case 0 -> {
                    Starjam.lead = 0;
                    Starjam.tunes = 0;
                    Starjam.jam1.stop();
                }
                case 1 -> {
                    Starjam.lead = 1;
                    Starjam.tunes = 0;
                    Starjam.n5.start();
                    Starjam.n7.start();
                    Starjam.n9.start();
                }
                case 2 -> {
                    Starjam.lead = 1;
                    Starjam.tunes = 1;
                    Starjam.n5.start();
                    Starjam.jam1.stop();
                    Starjam.jam1.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
            return true;
        }
        if (Starjam.level == 0 && n < 300) {
            ++Starjam.level;
            this.init();
            Starjam.aniClock = 425;
        } else if (Starjam.aniClock > 500 && n < 300) {
            Starjam.trigger = 1;
        }
        return true;
    }
}
