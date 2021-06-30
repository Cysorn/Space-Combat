package game.objects.spaceship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.logic.ObjectSpawn;
import game.objects.logic.SpaceshipExplosion;
import game.objects.spaceship.SpaceshipSprite;

//TODO create new classes for Spaceship, stars, etc. and create logic classes
public class SpaceshipLogic{

	public SpaceshipSprite spaceshipSprite;
	public ObjectSpawn spawnSpaceship;
	public SpaceshipMove spaceshipMove;
	public SpaceshipExplosion spaceshipExplosion;
	public HealthBarLogic healthBarLogic;
	public boolean freezeSpaceship;
	public SpaceshipShoot spaceshipShoot;
	
	public SpaceshipLogic(int winWidth, int winHeight) throws IOException {
		spaceshipSprite = new SpaceshipSprite(winWidth, winHeight);
		freezeSpaceship = true;
		spaceshipMove = new SpaceshipMove(spaceshipSprite, winWidth, winHeight);
		spawnSpaceship = new ObjectSpawn(spaceshipSprite, spaceshipSprite.xPos, spaceshipSprite.yPos);
		healthBarLogic = new HealthBarLogic(spaceshipSprite, 100, true);
		spaceshipExplosion = new SpaceshipExplosion(spaceshipSprite, healthBarLogic.healthBarSprite, 1f);
		spaceshipShoot = new SpaceshipShoot(this);
		
	}
	
	public void nextFrame() {
	
		if(freezeSpaceship == false)
		{
			spaceshipMove.nextFrame();
		}
		spawnSpaceship.nextFrame();
		ifNecassaryPlayDieAnimationAndRespawn();
		if(spawnSpaceship.spawnIsDone() == true)
		{
			freezeSpaceship = false;
		}
		if(spawnSpaceship.animationPlays() == false)
		{
			spaceshipShoot.nextFrame();
		}
	}
	
	private void ifNecassaryPlayDieAnimationAndRespawn()
	{
		if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			if(spaceshipExplosion.spaceshipIsExploded == false)
			{
				if(spaceshipExplosion.animationPlays() == false)
				{
					freezeSpaceship = true;
					spaceshipExplosion.startExplosion();
					spaceshipMove.resetTexture();
				}
			}
			else
			{
				spaceshipExplosion.spaceshipIsExploded = false;
				healthBarLogic.healthBarSpawn.startSpawn();
				spawnSpaceship.startSpawn();
				healthBarLogic.setHpAndBarToFull();
			}
		}
	}
	
	public BufferedImage getSpriteTexture() {
		
		return spaceshipMove.getSpriteTexture();
	}
	
	public boolean spaceshipShotDown()
	{
		if(spaceshipExplosion.explosionAnimation.getCurrentFrame() >= 1 || spaceshipExplosion.spaceshipIsExploded)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}