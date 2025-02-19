package coffeecatrailway.hamncheese;

import coffeecatrailway.hamncheese.client.entity.HNCBoatEntityRenderer;
import coffeecatrailway.hamncheese.client.entity.MouseRenderer;
import coffeecatrailway.hamncheese.client.gui.screen.GrillScreen;
import coffeecatrailway.hamncheese.client.gui.screen.PizzaOvenScreen;
import coffeecatrailway.hamncheese.client.gui.screen.PopcornMachineScreen;
import coffeecatrailway.hamncheese.registry.*;
import net.minecraft.block.WoodType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @author CoffeeCatRailway
 * Created: 7/04/2021
 */
@OnlyIn(Dist.CLIENT)
public class ClientEvents
{
    public static void init(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            renderLayers();
            Atlases.addWoodType(HNCBlocks.MAPLE_WOOD_TYPE);
        });
        entityRenderers();
        registerScreen();

        ClientRegistry.bindTileEntityRenderer(HNCTileEntities.SIGN.get(), SignTileEntityRenderer::new);
    }

    private static void renderLayers()
    {
        RenderType cutoutMipped = RenderType.cutoutMipped();

        RenderTypeLookup.setRenderLayer(HNCBlocks.PINEAPPLE_PLANT.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.TOMATO_PLANT.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.CORN_PLANT.get(), cutoutMipped);

        RenderTypeLookup.setRenderLayer(HNCBlocks.POPCORN_MACHINE.get(), cutoutMipped);

        RenderTypeLookup.setRenderLayer(HNCBlocks.MAPLE_LEAVES.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.MAPLE_SAPLING.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.POTTED_MAPLE_SAPLING.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.MAPLE_TRAPDOOR.get(), cutoutMipped);
        RenderTypeLookup.setRenderLayer(HNCBlocks.MAPLE_DOOR.get(), cutoutMipped);

        RenderTypeLookup.setRenderLayer(HNCBlocks.TREE_TAP.get(), cutoutMipped);

        RenderType translucent = RenderType.translucent();

        RenderTypeLookup.setRenderLayer(HNCFluids.MAPLE_SAP.get(), translucent);
        RenderTypeLookup.setRenderLayer(HNCFluids.MAPLE_SAP_FLOWING.get(), translucent);
    }

    private static void entityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(HNCEntities.MOUSE.get(), MouseRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HNCEntities.MAPLE_BOAT.get(), HNCBoatEntityRenderer::new);
    }

    private static void registerScreen()
    {
        ScreenManager.register(HNCContainers.PIZZA_OVEN.get(), PizzaOvenScreen::new);
        ScreenManager.register(HNCContainers.GRILL.get(), GrillScreen::new);
        ScreenManager.register(HNCContainers.POPCORN_MACHINE.get(), PopcornMachineScreen::new);
    }
}
