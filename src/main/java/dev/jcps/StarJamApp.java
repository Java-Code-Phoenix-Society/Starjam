package dev.jcps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class StarJamApp extends JFrame implements WindowListener {
    static Timer timer;
    Starjam sj;

    public StarJamApp() {
        super("StarJam");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the frame on the screen

        // set the frame icon to the StarJam icon image
        URL iconPath = this.getClass().getResource("/1ball.png");

        assert iconPath != null;
        setIconImage(new ImageIcon(iconPath).getImage());

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
        sja.requestFocus();
        sja.sj.init();
        timer = new Timer(300 / sja.sj.getfSpeed(), null);
        timer.addActionListener(e -> {
            sja.sj.run();
            timer.setDelay(300 / sja.sj.getfSpeed());
        });
        timer.start();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // nothing needs to happen.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        timer.stop();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // nothing needs to happen.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // nothing needs to happen.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // nothing needs to happen.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // nothing needs to happen.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // nothing needs to happen.
    }
}