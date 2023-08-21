package lemon_juice.soul_cages.item.custom;

import lemon_juice.soul_cages.SoulCages;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class SoulCarverTier {

    public static final Tier SOUL_CARVER = TierSortingRegistry.registerTier(new ForgeTier(0, -1, 12.0F, 0.0F, 30, BlockTags.SWORD_EFFICIENT, () -> Ingredient.of(Items.AIR)), new ResourceLocation(SoulCages.MOD_ID, "soul_carver"), List.of(), List.of());
}
