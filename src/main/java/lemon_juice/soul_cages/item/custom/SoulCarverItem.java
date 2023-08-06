package lemon_juice.soul_cages.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulCarverItem extends SwordItem {

    public SoulCarverItem(Properties properties) {
        super(SoulCarverTier.SOUL_CARVER, 0, 0, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.soul_cages.soul_carver"));
    }
}
