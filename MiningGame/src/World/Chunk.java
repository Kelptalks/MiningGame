package World;
import java.util.Random;
public class Chunk {
    WorldTextures worldTextures;

    public Tile[][] chunkData = new Tile[16][16];
    private Tile testTile, testTile2;

    Chunk(WorldTextures worldTextures){
        this.worldTextures = worldTextures;
        testTile = new Tile("stone", worldTextures);
        testTile2 = new Tile("resorce", worldTextures);

        Random random = new Random();
        for(int x = 0; x<chunkData.length; x++){
            for(int y = 0; y<chunkData.length; y++){
                if (random.nextInt(50) == 1){
                    this.chunkData[x][y] = testTile2;
                }
                else{
                    this.chunkData[x][y] = testTile;
                }
            }
        }
    }

    public void updateTile(int xCor, int yCor){
        int tileCorX = (xCor/32);
        int tileCorY = (yCor/32);
        chunkData[tileCorX-1][tileCorY-1] = testTile2;
        System.out.println("Updating Tile In chunk at : " + tileCorX + ',' + tileCorY);
    }
}
