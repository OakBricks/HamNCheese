package coffeecatrailway.hamncheese.integration.top;

import coffeecatrailway.hamncheese.HNCMod;
import coffeecatrailway.hamncheese.common.block.ChoppingBoardBlock;
import coffeecatrailway.hamncheese.common.tileentity.GrillTileEntity;
import coffeecatrailway.hamncheese.common.tileentity.PizzaOvenTileEntity;
import coffeecatrailway.hamncheese.common.tileentity.PopcornMachineTileEntity;
import coffeecatrailway.hamncheese.data.gen.HNCLanguage;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.function.Function;

/**
 * @author CoffeeCatRailway
 * Created: 15/06/2021
 */
public class HNCTheOneProbe implements Function<ITheOneProbe, Void>, IProbeInfoProvider
{
    @Override
    public Void apply(ITheOneProbe top)
    {
        top.registerProvider(this);
        return null;
    }

    @Override
    public String getID()
    {
        return HNCMod.getLocation("theoneprobe").toString();
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo info, PlayerEntity player, World level, BlockState blockState, IProbeHitData hitData)
    {
        final Block block = blockState.getBlock();
        TileEntity tile = null;
        if (block.hasTileEntity(blockState))
            tile = level.getBlockEntity(hitData.getPos());

        if (tile instanceof PizzaOvenTileEntity)
        {
            PizzaOvenTileEntity oven = (PizzaOvenTileEntity) tile;
            addProgress(info, 0xff4c3811, 0xffbc8927, 0xffdac192, oven.data.get(2), oven.data.get(3));
        }
        if (tile instanceof GrillTileEntity)
        {
            GrillTileEntity grill = (GrillTileEntity) tile;
            addProgress(info, 0xff301b00, 0xff916e2f, 0xffae8b4c, grill.data.get(2), grill.data.get(3));
        }
        if (tile instanceof PopcornMachineTileEntity)
        {
            PopcornMachineTileEntity popcornMachine = (PopcornMachineTileEntity) tile;
            ItemStack result = popcornMachine.getItem(PopcornMachineTileEntity.SLOT_DOWN);
            if (!result.isEmpty())
                info.item(result.copy());
            if (popcornMachine.data.get(0) > 0)
                addProgress(info, 0xffb26411, 0xfff5dd5d, 0xff752802, popcornMachine.data.get(0), PopcornMachineTileEntity.MAX_FLAVOUR_TIME);
            if (popcornMachine.data.get(1) > 0)
                addProgress(info, 0xffffffff, 0xfffae99f, 0xffce3723, popcornMachine.data.get(1), PopcornMachineTileEntity.MAX_POPCORN, style -> style.numberFormat(NumberFormat.NONE).prefix(HNCLanguage.getPopcorn(popcornMachine.data.get(1))));
        }

        if (block instanceof ChoppingBoardBlock)
            info.text(new TranslationTextComponent("top.hamncheese.chop_chop"));
    }

    private static void addProgress(IProbeInfo info, int border, int filled, int background, float amount, float total)
    {
        addProgress(info, border, filled, background, amount, total, style -> style.prefix(new TranslationTextComponent("top.hamncheese.progress")).suffix("%"));
    }

    private static void addProgress(IProbeInfo info, int border, int filled, int background, float amount, float total, Function<IProgressStyle, IProgressStyle> style)
    {
        float progressTotal = 0f;
        if (amount > 0 && total > 0)
            progressTotal = amount / total * 100f;
        info.progress((int) progressTotal, 100, style.apply(info.defaultProgressStyle().copy().color(border, filled, background).alternateFilledColor(filled)));
    }
}
