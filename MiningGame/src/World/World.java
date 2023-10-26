package World;
import java.util.HashMap;

public class World {
    HashMap<Integer, Chunk> worldMap = new HashMap<>();
    WorldTextures worldTextures = new WorldTextures();
    
    public Chunk testChunk;
    public World(){
    testChunk = new Chunk(worldTextures);
    }


    //Chunk Generationtion and selection
    public Chunk loadChunk(int xCor, int yCor){
        return worldMap.get(getPackedCords(xCor, yCor));
    }

    public Chunk genChunk(int xCor, int yCor){
        int packedCords = getPackedCords(xCor, yCor);
        worldMap.put(packedCords, new Chunk(worldTextures));
        return worldMap.get(packedCords);
    }

    private int getPackedCords(int xCor, int yCor){
        int bitPackedCords = 0;
        bitPackedCords |= (xCor&0x0000FFFF);
        bitPackedCords |= (yCor << 16) & 0xFFFF0000;
        return bitPackedCords;
    }

    public void updateTile(int xCor, int yCor){
        System.out.println("Updating Tile at : " + xCor + ',' + yCor);

        Chunk chunk = loadChunk(xCor/512, yCor/512);
        System.out.println("(chunk : " + chunk + ")" + xCor/512 + ',' + yCor/512);
        chunk.updateTile(xCor%512, yCor%512);
    }

}
