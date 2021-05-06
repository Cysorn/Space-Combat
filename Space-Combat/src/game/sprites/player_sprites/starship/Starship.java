package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.sprites.Sprite;

public class Starship extends Sprite{

	private StarshipTextures starshipTextures;

	private Spawn spawnStarship;
	public StarshipMove starshipMove;
	public StarshipExplosion starshipExplosion;
	
	public Starship(int winWidth, int winHeight) throws IOException {
		super(winWidth / 2 - 40, winHeight / 2f, 80, 110);
		starshipTextures = new StarshipTextures();
		starshipMove = new StarshipMove(this, starshipTextures, winWidth, winHeight);
		spawnStarship = new Spawn(this);
		starshipExplosion = new StarshipExplosion();
	}
	
	@Override
	public void nextFrame() {
	
		starshipMove.nextFrame();
		spawnStarship.nextFrame();
	}
	
	@Override
	public BufferedImage getSpriteTexture() {
		
		return starshipMove.getSpriteTexture();
	}
}