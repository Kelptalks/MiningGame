package Rendering;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import World.Chunk;
import World.Tile;
import World.World;

public class MapJPanel extends JPanel{
    private Image mainMap;
    public int xCamCor=32;
    public int yCamCor=32;
    public MapJPanel(int xRez, int yRez){
        super.setSize(xRez, yRez);
        this.mainMap = new BufferedImage(xRez, yRez, BufferedImage.TYPE_4BYTE_ABGR);
    }

    public void updateCam(char direction){
        if (direction == 'l'){
            this.xCamCor++;
        }
        if (direction == 'r'){
            this.xCamCor--;
        }
        if (direction == 'u'){
            this.yCamCor++;
        }
        if (direction == 'd'){
            this.yCamCor--;
        }
    }

    public void drawWorld(World world){
        //Identify what chunks need to be loaded
        int topLeftChunkX = Math.abs(xCamCor/512);
        int topleftChunkY = Math.abs(yCamCor/512);

        int cLoadingDimentionsX = 1;
        int cLoadingDimentionsY = 1;
        
        //Check if there loaded,
        for (int x = -1; x<cLoadingDimentionsX; x++){
            for (int y = -1; y<cLoadingDimentionsY; y++){
                Chunk chunkToDraw = world.loadChunk(x+topLeftChunkX, y+topleftChunkY);
                if (chunkToDraw == null){
                    chunkToDraw = world.genChunk(x+topLeftChunkX, y+topleftChunkY);
                }
                drawChunk(chunkToDraw, x*512+xCamCor%512, y*512+yCamCor%512);
            }
        }

    }

    public void drawTile(Tile tile){
        Graphics2D g2D = (Graphics2D) this.mainMap.getGraphics();
        g2D.drawImage(tile.tileTexture, 0, 0, null);
        g2D.dispose();
        this.revalidate();
        this.repaint();
    }

    public void drawChunk(Chunk chunk, int xCor, int yCor){
        Graphics2D g2D = (Graphics2D) this.mainMap.getGraphics();
        for(int x = 0; x<chunk.chunkData.length; x++){
            for(int y = 0; y<chunk.chunkData.length; y++){
                g2D.drawImage(chunk.chunkData[x][y].tileTexture, x*32+xCor, y*32+yCor, null);
            }
        }
        g2D.dispose();
        this.revalidate();
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mainMap != null) {
            g.drawImage(mainMap, 0, 0, this); // Draws the image at (0, 0)
        }
    }

}
