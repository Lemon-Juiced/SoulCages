package lemon_juice.soul_cages.item.custom;


import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SoulCarverTier {
    public static final ForgeTier SOUL_CARVER = new ForgeTier(0, -1, 12.0F, 0.0F, 30, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.AIR));

}
