package Display;

import Display.Panel;

import javax.swing.JFrame;
import java.awt.Canvas;


public class Visual extends JFrame{

    private Panel mycanvas;

    public Visual() {
        super("Pandemic");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setLocationRelativeTo(null);
        mycanvas = new Panel();
        mycanvas.setFocusable(false);
        addPanel();

    }
    public void addPanel() {
        this.add(mycanvas);
        pack();
    }

    public Canvas getcanvas() {
        return mycanvas;
    }

    public JFrame getjframe() {
        return this;
    }
}
