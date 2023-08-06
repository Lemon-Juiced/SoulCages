package lemon_juice.soul_cages.handler;

import lemon_juice.soul_cages.handler.util.FragmentFinder;
import lemon_juice.soul_cages.item.custom.SoulCarverItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class MobDropHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        var entity = event.getEntity();
        var level = event.getEntity().level();

        if (!level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) return;

        var drops = event.getDrops();
        var attacker = event.getSource().getEntity();
        int fragmentDropChance = 10; // Out of 100
        Random random = new Random();

        if (attacker instanceof Player playerEntity) {
            Item itemInHand = playerEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();
            if (itemInHand instanceof SoulCarverItem) {
                if(random.nextInt(0, 100) < fragmentDropChance){
                    double entX = entity.getX();
                    double entY = entity.getY();
                    double entZ = entity.getZ();

                    // Go through non-alphabetical inheritors first
                    if (entity instanceof MushroomCow) drops.add(itemEntityCreator(level, entX, entY, entZ, "mooshroom"));
                    else if (entity instanceof TraderLlama) drops.add(itemEntityCreator(level, entX, entY, entZ, "trader_llama"));
                    else if (entity instanceof ZombieVillager) drops.add(itemEntityCreator(level, entX, entY, entZ, "zombie_villager"));

                    // Go through alphabetical inheritors & non-inheritors second
                    else if(entity instanceof Allay) drops.add(itemEntityCreator(level, entX, entY, entZ, "allay"));
                    else if (entity instanceof Axolotl) drops.add(itemEntityCreator(level, entX, entY, entZ, "axolotl"));
                    else if (entity instanceof Bat) drops.add(itemEntityCreator(level, entX, entY, entZ, "bat"));
                    else if (entity instanceof Bee) drops.add(itemEntityCreator(level, entX, entY, entZ, "bee"));
                    else if (entity instanceof Blaze) drops.add(itemEntityCreator(level, entX, entY, entZ, "blaze"));
                    else if (entity instanceof Camel) drops.add(itemEntityCreator(level, entX, entY, entZ, "camel"));
                    else if (entity instanceof Cat) drops.add(itemEntityCreator(level, entX, entY, entZ, "cat"));
                    else if (entity instanceof CaveSpider) drops.add(itemEntityCreator(level, entX, entY, entZ, "cave_spider"));
                    else if (entity instanceof Chicken) drops.add(itemEntityCreator(level, entX, entY, entZ, "chicken"));
                    else if (entity instanceof Cod) drops.add(itemEntityCreator(level, entX, entY, entZ, "cod"));
                    else if (entity instanceof Cow) drops.add(itemEntityCreator(level, entX, entY, entZ, "cow"));
                    else if (entity instanceof Creeper) drops.add(itemEntityCreator(level, entX, entY, entZ, "creeper"));
                    else if (entity instanceof Dolphin) drops.add(itemEntityCreator(level, entX, entY, entZ, "dolphin"));
                    else if (entity instanceof Donkey) drops.add(itemEntityCreator(level, entX, entY, entZ, "donkey"));
                    else if (entity instanceof Drowned) drops.add(itemEntityCreator(level, entX, entY, entZ, "drowned"));
                    else if (entity instanceof ElderGuardian) drops.add(itemEntityCreator(level, entX, entY, entZ, "elder_guardian"));
                    else if (entity instanceof EnderMan) drops.add(itemEntityCreator(level, entX, entY, entZ, "enderman"));
                    else if (entity instanceof Endermite) drops.add(itemEntityCreator(level, entX, entY, entZ, "endermite"));
                    else if (entity instanceof Evoker) drops.add(itemEntityCreator(level, entX, entY, entZ, "evoker"));
                    else if (entity instanceof Fox) drops.add(itemEntityCreator(level, entX, entY, entZ, "fox"));
                    else if (entity instanceof Frog) drops.add(itemEntityCreator(level, entX, entY, entZ, "frog"));
                    else if (entity instanceof Ghast) drops.add(itemEntityCreator(level, entX, entY, entZ, "ghast"));
                    else if (entity instanceof GlowSquid) drops.add(itemEntityCreator(level, entX, entY, entZ, "glow_squid"));
                    else if (entity instanceof Goat) drops.add(itemEntityCreator(level, entX, entY, entZ, "goat"));
                    else if (entity instanceof Guardian) drops.add(itemEntityCreator(level, entX, entY, entZ, "guardian"));
                    else if (entity instanceof Hoglin) drops.add(itemEntityCreator(level, entX, entY, entZ, "hoglin"));
                    else if (entity instanceof Horse) drops.add(itemEntityCreator(level, entX, entY, entZ, "horse"));
                    else if (entity instanceof Husk) drops.add(itemEntityCreator(level, entX, entY, entZ, "husk"));
                    else if (entity instanceof IronGolem) drops.add(itemEntityCreator(level, entX, entY, entZ, "iron_golem"));
                    else if (entity instanceof Llama) drops.add(itemEntityCreator(level, entX, entY, entZ, "llama"));
                    else if (entity instanceof MagmaCube) drops.add(itemEntityCreator(level, entX, entY, entZ, "magma_cube"));
                    else if (entity instanceof Mule) drops.add(itemEntityCreator(level, entX, entY, entZ, "mule"));
                    else if (entity instanceof Ocelot) drops.add(itemEntityCreator(level, entX, entY, entZ, "ocelot"));
                    else if (entity instanceof Panda) drops.add(itemEntityCreator(level, entX, entY, entZ, "panda"));
                    else if (entity instanceof Parrot) drops.add(itemEntityCreator(level, entX, entY, entZ, "parrot"));
                    else if (entity instanceof Phantom) drops.add(itemEntityCreator(level, entX, entY, entZ, "phantom"));
                    else if (entity instanceof Pig) drops.add(itemEntityCreator(level, entX, entY, entZ, "pig"));
                    else if (entity instanceof Piglin) drops.add(itemEntityCreator(level, entX, entY, entZ, "piglin"));
                    else if (entity instanceof PiglinBrute) drops.add(itemEntityCreator(level, entX, entY, entZ, "piglin_brute"));
                    else if (entity instanceof Pillager) drops.add(itemEntityCreator(level, entX, entY, entZ, "pillager"));
                    else if (entity instanceof PolarBear) drops.add(itemEntityCreator(level, entX, entY, entZ, "polar_bear"));
                    else if (entity instanceof Pufferfish) drops.add(itemEntityCreator(level, entX, entY, entZ, "pufferfish"));
                    else if (entity instanceof Rabbit) drops.add(itemEntityCreator(level, entX, entY, entZ, "rabbit"));
                    else if (entity instanceof Ravager) drops.add(itemEntityCreator(level, entX, entY, entZ, "ravager"));
                    else if (entity instanceof Salmon) drops.add(itemEntityCreator(level, entX, entY, entZ, "salmon"));
                    else if (entity instanceof Sheep) drops.add(itemEntityCreator(level, entX, entY, entZ, "sheep"));
                    else if (entity instanceof Shulker) drops.add(itemEntityCreator(level, entX, entY, entZ, "shulker"));
                    else if (entity instanceof Silverfish) drops.add(itemEntityCreator(level, entX, entY, entZ, "silverfish"));
                    else if (entity instanceof Skeleton) drops.add(itemEntityCreator(level, entX, entY, entZ, "skeleton"));
                    else if (entity instanceof SkeletonHorse) drops.add(itemEntityCreator(level, entX, entY, entZ, "skeleton_horse"));
                    else if (entity instanceof Slime) drops.add(itemEntityCreator(level, entX, entY, entZ, "slime"));
                    else if (entity instanceof Sniffer) drops.add(itemEntityCreator(level, entX, entY, entZ, "sniffer"));
                    else if (entity instanceof SnowGolem) drops.add(itemEntityCreator(level, entX, entY, entZ, "snow_golem"));
                    else if (entity instanceof Spider) drops.add(itemEntityCreator(level, entX, entY, entZ, "spider"));
                    else if (entity instanceof Squid) drops.add(itemEntityCreator(level, entX, entY, entZ, "squid"));
                    else if (entity instanceof Stray) drops.add(itemEntityCreator(level, entX, entY, entZ, "stray"));
                    else if (entity instanceof Strider) drops.add(itemEntityCreator(level, entX, entY, entZ, "strider"));
                    else if (entity instanceof Tadpole) drops.add(itemEntityCreator(level, entX, entY, entZ, "tadpole"));
                    else if (entity instanceof TropicalFish) drops.add(itemEntityCreator(level, entX, entY, entZ, "tropical_fish"));
                    else if (entity instanceof Turtle) drops.add(itemEntityCreator(level, entX, entY, entZ, "turtle"));
                    else if (entity instanceof Vex) drops.add(itemEntityCreator(level, entX, entY, entZ, "vex"));
                    else if (entity instanceof Villager) drops.add(itemEntityCreator(level, entX, entY, entZ, "villager"));
                    else if (entity instanceof Vindicator) drops.add(itemEntityCreator(level, entX, entY, entZ, "vindicator"));
                    else if (entity instanceof WanderingTrader) drops.add(itemEntityCreator(level, entX, entY, entZ, "wandering_trader"));
                    else if (entity instanceof Warden) drops.add(itemEntityCreator(level, entX, entY, entZ, "warden"));
                    else if (entity instanceof Witch) drops.add(itemEntityCreator(level, entX, entY, entZ, "witch"));
                    else if (entity instanceof WitherSkeleton) drops.add(itemEntityCreator(level, entX, entY, entZ, "wither_skeleton"));
                    else if (entity instanceof Wolf) drops.add(itemEntityCreator(level, entX, entY, entZ, "wolf"));
                    else if (entity instanceof Zoglin) drops.add(itemEntityCreator(level, entX, entY, entZ, "zoglin"));
                    else if (entity instanceof Zombie) drops.add(itemEntityCreator(level, entX, entY, entZ, "zombie"));
                    else if (entity instanceof ZombieHorse) drops.add(itemEntityCreator(level, entX, entY, entZ, "zombie_horse"));
                    else drops.add(itemEntityCreator(level, entX, entY, entZ, "zombified_piglin")); //Defaults to Zombified Piglin
                }
            }
        }
    }

    public static ItemEntity itemEntityCreator(Level level, double entX, double entY, double entZ, String name){
        FragmentFinder fragmentFinder = new FragmentFinder();
        return new ItemEntity(level, entX, entY, entZ, new ItemStack(fragmentFinder.findFragment(name)));
    }
}
