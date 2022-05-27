package game.field.logic.levels;

import java.util.ArrayList;

public class LevelA extends Level{
	private int additionalYDistanceForIntroducing;
	
	@SuppressWarnings("serial")
	public LevelA()
	{
		additionalYDistanceForIntroducing = 1000;
		levelObjectInformation = new ArrayList<>(){{
			add(new LevelObjectInformation('A', additionalYDistanceForIntroducing + 50));
		}};
		for(int i = 0; i < 6; ++i)
		{
			levelObjectInformation.add(new LevelObjectInformation('A', 400));
		}
	}
}