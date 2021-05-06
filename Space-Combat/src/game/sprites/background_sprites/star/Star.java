package game.sprites.background_sprites.star;

import java.awt.image.BufferedImage;

import game.sprites.SimpleSprite;
import game.sprites.background_sprites.StarSize;

public class Star extends SimpleSprite{
	
	private BufferedImage starTexture;
	private StarBlink starBlink;
	private StarPassingBy starPassingBy;
	public final StarSize starSize;

	public Star(BufferedImage texture, int windowWidth, int windowHeight, int xPos, int yPos, StarSize starSize)
	{
		super(xPos, yPos);
		starTexture = texture;
		this.starSize = starSize;
		starBlink = new StarBlink(this);
		starPassingBy = new StarPassingBy(this, windowWidth, windowHeight);
	}
	
	@Override
	public void nextFrame()
	{
		starBlink.nextFrame();
		starPassingBy.nextFrame();
	}
	
	@Override
	public BufferedImage getSpriteTexture()
	{
		return starTexture;
	}
}