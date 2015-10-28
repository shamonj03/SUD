package com.joe.util;

import java.util.function.Consumer;

import com.joe.Game;
import com.joe.model.ItemContainer;
import com.joe.model.Loot;
import com.joe.model.LootTable;
import com.joe.model.entity.GameObject;
import com.joe.model.entity.Player;

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

	public static void unlockDoor(GameObject object, int x, int y, int keyId) {
		Player player = Game.getPlayer();
		ItemContainer inventory = player.getData().getInventory();

		if (player.getLocation().equals(x, y)) {
			if (inventory.contains(keyId, 1)) {
				inventory.remove(keyId, 1);
				object.setId(3);

				Game.redrawZone();
				Util.streamMessageLn("You unlock the door.");
				//Util.pressEnterToContinue();
			} else {
				Util.streamMessageLn("Looks like you need a key to unlock this door.");
				//Util.pressEnterToContinue();
			}
		}
	}
}
