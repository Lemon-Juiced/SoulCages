package lemon_juice.soul_cages.item;

import lemon_juice.soul_cages.SoulCages;
import lemon_juice.soul_cages.item.custom.EchoEggItem;
import lemon_juice.soul_cages.item.custom.SoulCarverItem;
import lemon_juice.soul_cages.item.util.SoulFragmentGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoulCages.MOD_ID);

    // Soul Carver
    public static final RegistryObject<Item> SOUL_CARVER = ITEMS.register("soul_carver", () -> new SoulCarverItem(new Item.Properties()));

    // Echo Egg
    public static final RegistryObject<Item> ECHO_EGG = ITEMS.register("echo_egg", () -> new EchoEggItem(new Item.Properties()));

    // Cage Metal
    public static final RegistryObject<Item> CAGE_METAL_BLEND = ITEMS.register("cage_metal_blend", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAGE_METAL_INGOT = ITEMS.register("cage_metal_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){

        // Create a SoulShardGenerator
        SoulFragmentGenerator soulFragmentGenerator = new SoulFragmentGenerator();

        // Create an alphabetical array containing all mob names
        String[] mobNames = {"allay", "axolotl", "bat", "bee", "blaze", "camel", "cat", "cave_spider", "chicken", "cod",
                "cow", "creeper", "dolphin", "donkey", "drowned", "elder_guardian", "enderman", "endermite", "evoker",
                "fox", "frog", "ghast", "glow_squid", "goat", "guardian", "hoglin", "horse", "husk", "iron_golem",
                "llama", "magma_cube", "mooshroom", "mule", "ocelot", "panda", "parrot", "phantom", "pig", "piglin",
                "piglin_brute", "pillager", "polar_bear", "pufferfish", "rabbit", "ravager", "salmon", "sheep",
                "shulker", "silverfish", "skeleton", "skeleton_horse", "slime", "sniffer", "snow_golem", "spider",
                "squid", "stray", "strider", "tadpole", "trader_llama", "tropical_fish", "turtle", "vex", "villager",
                "vindicator", "wandering_trader", "warden", "witch", "wither_skeleton", "wolf", "zoglin", "zombie",
                "zombie_horse", "zombie_villager", "zombified_piglin"};

        // Run soulShardGenerator on all mob names
        for (int i = 0; i < mobNames.length; i++) {
            soulFragmentGenerator.registerMobFragment(mobNames[i]);
        }

        // Register Everything Not Done Through SoulShardGenerator
        ITEMS.register(eventBus);
    }
}
