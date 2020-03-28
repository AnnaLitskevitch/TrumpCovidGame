package Display;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends Canvas{

    private static final int default_width = 800;
    private static final int default_height = 600;


    public Panel() {
        super();
        this.setPreferredSize(new Dimension(default_width, default_height));
        this.setMaximumSize(new Dimension(default_width, default_height));
        this.setMinimumSize(new Dimension(default_width, default_height));
        this.setVisible(true);
        this.setBackground(Color.cyan);

    }

    public static int getDefault_width() {
        return default_width;
    }

    public static int getDefault_height() {
        return default_height;
    }
}
