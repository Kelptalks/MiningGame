package World;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WorldTextures {
    public Image stone;
    public Image resorce;
    WorldTextures(){
        this.stone = initializeStone();
        this.resorce = initializeResorce();
    }

    private Image initializeStone(){
        Image image = null;
        try {
            image = ImageIO.read(new File("src/World/worldTextures/stone.png.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return image;
    }

    private Image initializeResorce(){
        Image image = null;
        try {
            image = ImageIO.read(new File("src/World/worldTextures/Resorce.png.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return image;
    }

}
