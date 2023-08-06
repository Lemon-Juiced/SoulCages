package lemon_juice.soul_cages.item.custom;

import net.minecraft.world.item.Item;

public class MobFragment extends Item {
    String name;
    public MobFragment(Properties properties, String name) {
        super(properties);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
