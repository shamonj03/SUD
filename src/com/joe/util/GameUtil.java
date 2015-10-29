package com.joe.util;

import java.util.function.Consumer;

import com.joe.Game;
import com.joe.model.Loot;
import com.joe.model.entity.GameObject;

public class GameUtil {


	public static void breakPot(Loot[][] potLoot, GameObject object) {
		customBreakPot(object, p -> {
			boolean foundLoot = LootTable.basicRewardLoot(potLoot);

			if (!foundLoot) {
				Util.streamMessageLn("The pot was empty.");
				Util.pressEnterToContinue();
			}
		});
	}

	public static void customBreakPot(GameObject object, Consumer<GameObject> consume) {
		Util.streamMessageLn("You break the pot...");
		consume.accept(object);
		object.setId(0);
		Game.redrawZone();
	}

}
