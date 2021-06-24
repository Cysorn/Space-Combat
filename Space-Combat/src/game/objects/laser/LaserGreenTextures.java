package game.objects.laser;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LaserGreenTextures extends LaserTextures{
	
	public LaserGreenTextures() throws IOException
	{
		laserTexture = ImageIO.read(new File("src/textures/spaceship/laser.png"));
	}
}