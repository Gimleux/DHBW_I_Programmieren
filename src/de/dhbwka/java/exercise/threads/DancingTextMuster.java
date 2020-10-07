package de.dhbwka.java.exercise.threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DancingTextMuster extends JComponent implements Runnable {
    private final static int XBASE = 30;
    private final static int XSTEP = 36;
    private final static int YBASE = 150;
    private final static Random RANDOM = new Random();

    private String text;
    private final long delay;

    private int colR = 0; // Color-Channel: red
    private int colG = 90; // Color-Channel: green
    private int colB = 180; // Color-Channel: blue
    private int yOffset = 0;

    public DancingTextMuster(String text, long delay ) {
        this.text = text;
        this.delay = delay;
        new Thread( this ).start(); // Start Thread
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        g.setFont( new Font( "Helvetica", Font.BOLD, 48 ) );
        for ( int i = 0; i < this.text.length(); i++ ) {
            char c = this.text.charAt( i );
            this.colR = (this.colR + 4 + DancingTextMuster.RANDOM.nextInt( 4 )) % 256;
            this.colG = (this.colG + 4 + DancingTextMuster.RANDOM.nextInt( 4 )) % 256;
            this.colB = (this.colB + 4 + DancingTextMuster.RANDOM.nextInt( 4 )) % 256;
            this.yOffset = DancingTextMuster.RANDOM.nextInt( 30 );
            g.setColor( new Color( this.colR, this.colG, this.colB ) );
            g.drawString( "" + c, DancingTextMuster.XBASE + i * DancingTextMuster.XSTEP,
                    DancingTextMuster.YBASE - this.yOffset );
        }
    }

    @Override
    public void run() {
        while ( true ) {
            // Repaint and wait for delay
            this.repaint();
            try {
                Thread.sleep( this.delay );
            } catch ( InterruptedException e ) {
                System.err.println( "Interrupted!" );
            }
        }
    }

    public static void main( String[] args ) {
        // Create frame and add DancingText component
        JFrame f = new JFrame( "Dancing Text" );
        f.add( new DancingTextMuster( "Dancing Text :-)", 200 ) );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( 640, 280 );
        f.setVisible( true );
    }
}
