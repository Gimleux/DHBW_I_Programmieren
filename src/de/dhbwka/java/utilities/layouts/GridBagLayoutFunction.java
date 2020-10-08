package de.dhbwka.java.utilities.layouts;

import java.awt.*;

public class GridBagLayoutFunction {
    /**
     * Adds Component using GridBagLayout to given Container
     * @param container Container
     * @param component Component
     * @param x collums
     * @param y rows
     * @param width width
     * @param height height
     * @param weightx width can be modified compared to other elements' weightx
     * @param weighty height can be modified compared to other elements' weighty
     */
    public static void addComponent(Container container, Component component, int x, int y, int width, int height, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        container.add(component, gbc);
    }
}
