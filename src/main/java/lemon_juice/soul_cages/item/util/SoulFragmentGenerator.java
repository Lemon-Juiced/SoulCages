package lemon_juice.soul_cages.item.util;

import lemon_juice.soul_cages.item.ModItems;
import lemon_juice.soul_cages.item.custom.MobFragment;
import net.minecraft.world.item.Item;

public class SoulFragmentGenerator {

    /**
     * Registers a shard for each given mob name
     *
     * @param name The name of the mob
     */
    public void registerMobFragment(String name){
        ModItems.ITEMS.register(name + "_fragment", () -> new MobFragment(new Item.Properties(), name));
    }
}
