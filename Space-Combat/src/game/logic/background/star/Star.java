package game.logic.background.star;

import java.awt.image.BufferedImage;

import game.logic.Entity;
import game.logic.background.StarSize;

public class Star extends Entity{
	
	private StarBlink b;
	private StarPassingBy spb;

	public Star(BufferedImage texture, int windowWidth, int windowHeight, int xPos, int yPos, StarSize starSize)
	{
		super(texture, xPos, yPos);
		b = new StarBlink(this);
		spb = new StarPassingBy(this, windowWidth, windowHeight, starSize);
		
	}
	
	@Override
	public void nextFrame()
	{
		b.blinking();
		spb.passingBy();
	}
	

	
	@Override
	public BufferedImage getTexture()
	{
		return textures.get(0);
	}
}