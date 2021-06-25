package game.field.logic.enemies.stages;

import java.util.ArrayList;

public class LevelA extends Level{
	@SuppressWarnings("serial")
	public LevelA()
	{
		super(300, 300);
		enemySpaceshipTypes = new ArrayList<>(){{
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
		}};
	}
}