package org.jcps;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StarJamApp extends JFrame {
    Starjam sj;

    public StarJamApp() {
        super("Starjam");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the frame on the screen

        // set the frame icon to the starjam icon image
        URL iconPath = this.getClass().getResource("/");

        assert iconPath != null;
        setIconImage(new ImageIcon(iconPath.getFile().substring(1) + "1ball.png").getImage());

        setSize(400, 340);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public static void main(String[] args) {
        StarJamApp sja = new StarJamApp();
        sja.sj = new Starjam();
        sja.add(sja.sj, BorderLayout.CENTER);
        sja.sj.setSize(800, 600);
        sja.setVisible(true);
        sja.sj.init();
        Timer timer = new Timer(300 / sja.sj.fSpeed, null);
        timer.addActionListener(e -> {
            sja.sj.run();
            timer.setDelay(300 / sja.sj.fSpeed);
        });
        timer.start();
    }
}