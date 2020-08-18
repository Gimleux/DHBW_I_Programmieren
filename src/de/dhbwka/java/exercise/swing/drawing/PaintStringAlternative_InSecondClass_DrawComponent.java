package de.dhbwka.java.exercise.swing.drawing;

import javax.swing.*;
import java.awt.*;

public class PaintStringAlternative_InSecondClass_DrawComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello World", 25,50);
    }
}
