package lemon_juice.soul_cages.handler.util;

import lemon_juice.soul_cages.item.ModItems;
import lemon_juice.soul_cages.item.custom.MobFragment;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class FragmentFinder {
    public Item findFragment(String name) {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries())
            if (item.get() instanceof MobFragment && ((MobFragment) item.get()).getName().equals(name))
                return item.get();
        return null; // Should never be reached
    }
}
