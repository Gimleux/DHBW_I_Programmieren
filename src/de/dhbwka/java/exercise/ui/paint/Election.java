package de.dhbwka.java.exercise.ui.paint;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import de.dhbwka.java.utilities.search.Biggest;

import javax.swing.*;
import java.awt.*;

public class Election extends JComponent{
    private final static int MARGIN_LEFT = 10;
    private final static int MARGIN_RIGHT = 10;
    private final static int MARGIN_TOP = 50;
    private final static Color TOP_COL = new Color( 0, 71, 129 );
    private final static Color BG_COL = new Color( 121, 170, 211 );
    private final static Color RULER_COL = new Color( 62, 133, 192 );
    private final static Font FONT = new Font( Font.SANS_SERIF, Font.BOLD, 16 );
    private final static String INFO_TEXT = "in %";

    private final Party[] parties;
    private final String title;
    private double maxPercentage;

    public Election(String title, Party[] parties){
        this.title = title.toUpperCase();
        this.parties = parties;
        maxPercentage = sortPartiesAndReturnBestVoted().getPercent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setFont(FONT);

        //Max bar height -> 2/3 height
        int totalBarHeight = height * 2 / 3;
        //height per %
        double heightPerPercent = totalBarHeight/maxPercentage;
        //add topMargin to biggestBarHeight to get the point for writing below
        int belowBars = totalBarHeight + MARGIN_TOP;

        //drawBackground
        g.setColor(BG_COL);
        g.fillRect(0,0,width,height);
        //drawHeading
        g.setColor(TOP_COL);
        g.fillRect(0,0,width,30);
        g.setColor(Color.white);
        g.drawString(title, MARGIN_LEFT, 23);
        g.drawString("in %", width-40, 23 );
        g.setColor(RULER_COL);
        g.fillRect(0,30,width,2);

        //Draw white block with darkBlue line
        //Ruler above white
        g.setColor(RULER_COL);
        g.fillRect(0,belowBars,width,10);
        //small line below white block
        g.fillRect(0,belowBars+40,width,2);
        //small line in middle of white block and bottom end of frame
        g.fillRect(0,(((height-(belowBars+40+2))/2-1)+(belowBars+40+2)),width, 2);
        //white block
        g.setColor(Color.white);
        g.fillRect(0,belowBars+10, width,30);

        //white helping lines a 10%
        g.setColor(Color.white);
        for (int i = 1; i<=(height-(height-belowBars)-42); i++){
            g.fillRect(0,(int) (height-(height-belowBars)-i*10*heightPerPercent), width, 1);
        }

        //drawParties
        drawParties(g, width, height, heightPerPercent, belowBars);
    }

    private void drawParties(Graphics g, int width, int height, double heightPerPercent, int belowBars){
        int maxBarWidth = (width - MARGIN_LEFT - MARGIN_RIGHT) / this.parties.length;


        for (int i = 0; i<parties.length; i++){
            //main bar
            g.setColor(parties[i].getColor());
            g.fillRect((MARGIN_LEFT+10+maxBarWidth*i), (belowBars-(int)(heightPerPercent*parties[i].getPercent())), maxBarWidth-20, (int)(heightPerPercent*parties[i].getPercent()));

            //mini color bar above name
            g.fillRect((MARGIN_LEFT+10+maxBarWidth*i), belowBars+10, maxBarWidth-20, 10);

            //name
            g.setColor(Color.BLACK);
            g.drawString(parties[i].getName(), MARGIN_LEFT+10+i*maxBarWidth, belowBars+36); //10-darkblueHorizontalBar 10-mini color bar above name 20-AllRemainingWhiteSpace -4-setToMiddleOfWhiteSpace
            //percentage
            g.drawString(Double.toString(parties[i].getPercent()), MARGIN_LEFT+10+i*maxBarWidth, belowBars+62); //40-seeAbove 2-darkblue small horizontal bar below white bar 20-small space between bars(4) and number(16)
        }
    }

    private Party sortPartiesAndReturnBestVoted(){
        Party help;
        if (parties.length>=2) {
            for (int i = 1; i < parties.length; i++) {
                int j = i;
                while (j>=1 && (parties[j].getPercent() > parties[j - 1].getPercent())) {
                    System.out.println(parties[j].toString());
                    System.out.println(parties[j-1].toString());
                    System.out.println("-----");
                    help = parties[j];
                    parties[j] = parties[j - 1];
                    parties[j - 1] = help;
                    j--;
                }
            }
        }
        return parties[0];
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setTitle("Wahl");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Election("Bundestagswahl 2021", new Party[] {
                new Party( 18.9, "Union", Color.BLACK ),
                new Party( 14.5, "SPD", Color.RED ),
                new Party( 16.6, "Linke", Color.MAGENTA ),
                new Party( 10.7, "FDP", Color.YELLOW ),
                new Party( 9.2, "Piraten", Color.ORANGE ),
                new Party( 25, "Gr\u00FCne", Color.GREEN ),
                new Party( 5.1, "Andere", Color.DARK_GRAY ),
        }));

        frame.setSize(640,480);
        frame.setVisible(true);
    }
}

class Party{
    private String name;
    private double percent;
    private Color color;

    public Party(double percent, String name, Color color) {
        this.color = color;
        this.name = name;
        this.percent = percent;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", percent=" + percent +
                ", color=" + color +
                '}';
    }
}