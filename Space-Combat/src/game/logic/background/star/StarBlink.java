package game.logic.background.star;

public class StarBlink {

	Star star;
	private float destinationAlpha;
	private float runningSpeed;
	private int framesCount;
	private boolean increaseAlpha;
	private boolean startMakingTheStarOpaque;
	
	StarBlink(Star star)
	{
		this.star = star;
		startMakingTheStarOpaque = false;
		generateNewValues();
	}
	
	void blinking()
	{
		if(increaseAlpha == true)
		{
			if(star.currentAlpha < destinationAlpha
			&& star.currentAlpha + runningSpeed <= 1)
			{
				star.currentAlpha = star.currentAlpha + runningSpeed;
			}
			else
			{
				generateNewValues();
			}
		}
		else
		{
			if(star.currentAlpha > destinationAlpha
			&& star.currentAlpha - runningSpeed > 0)
			{
				star.currentAlpha = star.currentAlpha - runningSpeed;
			}
			else
			{
				startMakingTheStarOpaque = true;
				generateNewValues();
			}
		}
	}
	
	private void generateNewValues() {
		//cyclically changes the value of currentAlpha to a random value and back to 1f
		if(startMakingTheStarOpaque == true)
		{
			destinationAlpha = 1f;
			startMakingTheStarOpaque = false;
		}
		else
		{
			destinationAlpha = (float) (Math.random());
		}
		
		framesCount = (int) (Math.random() * 50) + 50;
		runningSpeed = (float) (Math.abs(destinationAlpha - star.currentAlpha)) / framesCount;
		if(star.currentAlpha < destinationAlpha)
		{
			increaseAlpha = true;
		}
		else
		{
			increaseAlpha = false;
		}
	}
}
