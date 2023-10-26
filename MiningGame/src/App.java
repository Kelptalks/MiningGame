import Rendering.MapJPanel;
import Rendering.myMouseListener;
import Rendering.MainFrame;
import World.World;

public class App {

    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame(1920,1080);
        MapJPanel mapJPanel = new MapJPanel(1920,1080);
        myMouseListener mouseListener = new myMouseListener();
        mapJPanel.addMouseListener(mouseListener);

        World world = new World();
        
        while(true){
            mapJPanel.drawWorld(world);   
            frame.updateMap(mapJPanel);
     
            //check for mouse inputs see if theres a new input.
            if(mouseListener.ifPressed()){
                System.out.println("true");
                world.updateTile(mouseListener.x(), mouseListener.y());
            }
        }

    }

    
}
