package lemon_juice.soul_cages.creativetab;

import lemon_juice.soul_cages.SoulCages;
import lemon_juice.soul_cages.block.ModBlocks;
import lemon_juice.soul_cages.item.ModItems;
import lemon_juice.soul_cages.item.custom.MobFragment;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SoulCages.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SOUL_CAGES_TAB = CREATIVE_MODE_TABS.register("soul_cages", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.soul_cages"))
            .icon(() -> new ItemStack(ModItems.SOUL_CARVER.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SOUL_CAGES_TAB.get()) {
            event.accept(ModItems.SOUL_CARVER);
            event.accept(ModItems.ECHO_EGG);
            event.accept(ModItems.CAGE_METAL_BLEND);
            event.accept(ModItems.CAGE_METAL_INGOT);
            event.accept(ModBlocks.CAGE_METAL_BARS);
            event.accept(ModBlocks.EMPTY_SOUL_CAGE);

            for(RegistryObject<Item> item : ModItems.ITEMS.getEntries())
                if(item.get() instanceof MobFragment)
                    event.accept(item.get());
        }
    }

    /******************************** Registry ********************************/

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
