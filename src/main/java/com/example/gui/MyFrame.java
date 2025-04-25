package com.example.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    private int width;
    private int height;
    private String title;
    
    /**
     * Initializes the JFrame with default settings.
     * Sets the visibility to true, the close operation to exit on close,
     * the resizability to false, and the background color to a dark shade.
     */
    private void init() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setBackground(new Color(0x1D1D1D));
        this.setSize(500,500);
    }

    /**
     * Prints out the parameters given to console
     */
    private void diag() {
        System.out.printf("Resolution: %sx%s\n",this.width,this.height);
    }
    
    // Default Constructor
    public MyFrame() {
        init();
        diag();
    }

    
    public MyFrame(Dimension d) {
        // Set current object's width and height
        this.width = (int) d.getWidth();
        this.height = (int) d.getHeight();
        init();
        this.setSize(d);
        diag();
    }

    /**
     * Construct a new MyFrame with the given width and height.
     * @param width the width of the frame
     * @param height the height of the frame
     * 
     * pass the width and height to constructor with dimension
     */
    public MyFrame(int width, int height) {
        this(new Dimension(width,height));
    }

    public void play() {
        JLabel one = new JLabel("Hello");
        this.add(one);
        one.setForeground(Color.white);
        ImageIcon rat = new ImageIcon("./src/main/java/com/example/rat.jpg");
        Image img = rat.getImage();  
        Image newimg = img.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);  
        rat = new ImageIcon( newimg );
        one.setIcon(rat);
    }
}