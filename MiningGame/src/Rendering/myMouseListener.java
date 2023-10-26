package Rendering;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class myMouseListener extends MouseAdapter {
    private int mouseX;
    private int mouseY;
    private boolean pressed = false;
    public myMouseListener() {
        System.out.println("Adding listener");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
        this.pressed = true;
    }

    public int x(){
        return this.mouseX;
    }

    public int y(){
        return this.mouseY;
    }

    public boolean ifPressed(){
        Boolean ifPressed = pressed;
        if (pressed == true){
            pressed = false;
        }
        return ifPressed;
    }

}