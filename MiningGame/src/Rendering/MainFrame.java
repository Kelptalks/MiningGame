package Rendering;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private MapJPanel mapJPanel;
    public MainFrame(int xRez, int yRez){
        super.setSize(xRez, yRez);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateMap(MapJPanel mapJPanel){
        this.add(mapJPanel);
        this.revalidate();
        this.repaint();
    }
}
