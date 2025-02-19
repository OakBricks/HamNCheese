package coffeecatrailway.hamncheese.data.gen;

import coffeecatrailway.hamncheese.HNCMod;
import coffeecatrailway.hamncheese.registry.HNCBlocks;
import coffeecatrailway.hamncheese.registry.HNCItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

/**
 * @author CoffeeCatRailway
 * Created: 17/03/2021
 */
@SuppressWarnings("unchecked")
public class HNCItemTags extends ItemTagsProvider
{
    public static final ITag.INamedTag<Item> GEARS = ItemTags.createOptional(new ResourceLocation("forge", "gears"));
    public static final ITag.INamedTag<Item> GEARS_WOODEN = ItemTags.createOptional(new ResourceLocation("forge", "gears/wooden"));

    public static final ITag.INamedTag<Item> WHEAT = ItemTags.createOptional(new ResourceLocation("forge", "wheat"));
    public static final ITag.INamedTag<Item> SUGAR = ItemTags.createOptional(new ResourceLocation("forge", "sugar"));

    public static final ITag.INamedTag<Item> CHEESE = ItemTags.createOptional(new ResourceLocation("forge", "cheese"));

    public static final ITag.INamedTag<Item> SALT = ItemTags.createOptional(new ResourceLocation("forge", "salt"));
    public static final ITag.INamedTag<Item> FLOUR = ItemTags.createOptional(new ResourceLocation("forge", "flour"));

    public static final ITag.INamedTag<Item> DOUGH = ItemTags.createOptional(new ResourceLocation("forge", "dough"));

    public static final ITag.INamedTag<Item> PIZZA = ItemTags.createOptional(new ResourceLocation("forge", "pizza"));

    public static final ITag.INamedTag<Item> BREAD_SLICE = ItemTags.createOptional(new ResourceLocation("forge", "bread_slice"));
    public static final ITag.INamedTag<Item> BREAD = ItemTags.createOptional(new ResourceLocation("forge", "bread"));

    public static final ITag.INamedTag<Item> CRACKER = ItemTags.createOptional(new ResourceLocation("forge", "cracker"));

    public static final ITag.INamedTag<Item> EGG_MOD = ItemTags.createOptional(HNCMod.getLocation("eggs"));
    public static final ITag.INamedTag<Item> EGG = ItemTags.createOptional(new ResourceLocation("forge", "egg"));
    public static final ITag.INamedTag<Item> CRACKED_EGG = ItemTags.createOptional(new ResourceLocation("forge", "cracked_egg"));

    public static final ITag.INamedTag<Item> HAM = ItemTags.createOptional(new ResourceLocation("forge", "ham"));
    public static final ITag.INamedTag<Item> BACON = ItemTags.createOptional(new ResourceLocation("forge", "bacon"));

    public static final ITag.INamedTag<Item> PINEAPPLE = ItemTags.createOptional(new ResourceLocation("forge", "pineapple"));

    public static final ITag.INamedTag<Item> TOMATO = ItemTags.createOptional(new ResourceLocation("forge", "tomato"));
    public static final ITag.INamedTag<Item> TOMATO_SAUCE = ItemTags.createOptional(new ResourceLocation("forge", "tomato_sauce"));

    public static final ITag.INamedTag<Item> CORN_COB = ItemTags.createOptional(new ResourceLocation("forge", "corn_cob"));

    public static final ITag.INamedTag<Item> MOUSE_BLACKLIST = ItemTags.createOptional(HNCMod.getLocation("mouse_blacklist"));

    public static final ITag.INamedTag<Item> FRUITS = ItemTags.createOptional(new ResourceLocation("forge", "fruits"));
    public static final ITag.INamedTag<Item> CROPS = ItemTags.createOptional(new ResourceLocation("forge", "crops"));
    public static final ITag.INamedTag<Item> CARBS = ItemTags.createOptional(new ResourceLocation("forge", "carbs"));
    public static final ITag.INamedTag<Item> SEEDS = ItemTags.createOptional(new ResourceLocation("forge", "seeds"));

    public static final ITag.INamedTag<Item> CAMPFIRES = ItemTags.createOptional(new ResourceLocation("forge", "campfires"));

    public static final ITag.INamedTag<Item> JEI_FOOD_BLACKLIST = ItemTags.createOptional(HNCMod.getLocation("jei_food_blacklist"));

    public static final ITag.INamedTag<Item> MAPLE_LOGS = ItemTags.createOptional(HNCMod.getLocation("maple_logs"));

    public HNCItemTags(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper fileHelper)
    {
        super(generator, provider, HNCMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags()
    {
        this.tag(GEARS_WOODEN).add(HNCItems.WOODEN_GEAR.get());
        this.tag(GEARS).addTag(GEARS_WOODEN);

        this.tag(WHEAT).add(Items.WHEAT);
        this.tag(SUGAR).add(Items.SUGAR);

        this.tag(CHEESE).add(HNCBlocks.BLOCK_OF_CHEESE.get().asItem(), HNCItems.CHEESE_SLICE.get());

        this.tag(SALT).add(HNCItems.ROCK_SALT.get());
        this.tag(FLOUR).add(HNCItems.FLOUR.get());

        this.tag(DOUGH).add(HNCItems.DOUGH.get(), HNCItems.UNBAKED_PIZZA_BASE.get());

        this.tag(PIZZA).add(HNCItems.UNBAKED_PIZZA_BASE.get());

        this.tag(BREAD_SLICE).add(HNCItems.BREAD_SLICE.get());
        this.tag(BREAD).add(HNCItems.BREAD_SLICE.get());

        this.tag(CRACKER).add(HNCItems.CRACKER.get());

        this.tag(EGG_MOD).add(HNCItems.CRACKED_EGG.get(), HNCItems.COOKED_EGG.get(), HNCItems.GREEN_EGG.get());
        this.tag(Tags.Items.EGGS).addTag(EGG_MOD);
        this.tag(EGG).addTag(EGG_MOD);
        this.tag(CRACKED_EGG).addTag(EGG_MOD);

        this.tag(HAM).add(HNCItems.HAM_SLICE.get(), HNCItems.COOKED_HAM_SLICE.get(), HNCItems.GREEN_HAM_SLICE.get());
        this.tag(BACON).add(HNCItems.BACON.get(), HNCItems.COOKED_BACON.get());

        this.tag(PINEAPPLE).add(HNCItems.PINEAPPLE.get());

        this.tag(TOMATO).add(HNCItems.TOMATO.get());
        this.tag(TOMATO_SAUCE).add(HNCItems.TOMATO_SAUCE.get());

        this.tag(CORN_COB).add(HNCItems.CORN_COB.get());

        this.tag(FRUITS).addTags(PINEAPPLE, TOMATO, CORN_COB);
        this.tag(CROPS).addTags(PINEAPPLE, TOMATO, CORN_COB);
        this.tag(CARBS).add(HNCItems.BREAD_SLICE.get(), HNCItems.TOAST.get());
        this.tag(SEEDS).add(HNCItems.TOMATO_SEEDS.get());

        this.tag(MOUSE_BLACKLIST).add(Items.ROTTEN_FLESH, Items.SPIDER_EYE, Items.PUFFERFISH, HNCItems.MOUSE.get(), HNCItems.COOKED_MOUSE.get(), HNCItems.FOOD_SCRAPS.get());

        this.tag(CAMPFIRES).add(Blocks.CAMPFIRE.asItem(), Blocks.SOUL_CAMPFIRE.asItem());

        this.tag(JEI_FOOD_BLACKLIST).addTags(BREAD_SLICE, CRACKER, PIZZA, TOMATO_SAUCE).add(HNCItems.CRACKER_DUMMY.get(), HNCItems.BAKED_PIZZA_DUMMY.get());

        this.tag(ItemTags.PLANKS).add(HNCBlocks.MAPLE_PLANKS.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(HNCBlocks.MAPLE_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(HNCBlocks.MAPLE_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(HNCBlocks.MAPLE_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(HNCBlocks.MAPLE_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(HNCBlocks.MAPLE_FENCE.get().asItem());
        this.tag(ItemTags.SAPLINGS).add(HNCBlocks.MAPLE_SAPLING.get().asItem());
        this.tag(MAPLE_LOGS).add(HNCBlocks.MAPLE_LOG.get().asItem(), HNCBlocks.MAPLE_WOOD.get().asItem(), HNCBlocks.STRIPPED_MAPLE_LOG.get().asItem(), HNCBlocks.STRIPPED_MAPLE_WOOD.get().asItem());
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(MAPLE_LOGS);
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(HNCBlocks.MAPLE_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.LEAVES).add(HNCBlocks.MAPLE_LEAVES.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(HNCBlocks.MAPLE_TRAPDOOR.get().asItem());
        this.tag(ItemTags.SIGNS).add(HNCBlocks.MAPLE_SIGN.get().asItem());
        this.tag(ItemTags.BOATS).add(HNCItems.MAPLE_BOAT.get());
    }
}
