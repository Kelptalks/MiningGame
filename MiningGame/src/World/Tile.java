package World;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class Tile {
    public Image tileTexture;
    Tile(String tyleType, WorldTextures texture){
        if (tyleType == "stone"){
            tileTexture = texture.stone;
        }
        if (tyleType == "resorce"){
            tileTexture = texture.resorce;
        }
    }
}
