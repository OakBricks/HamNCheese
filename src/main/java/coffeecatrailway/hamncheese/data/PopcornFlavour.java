package coffeecatrailway.hamncheese.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * @author CoffeeCatRailway
 * Created: 10/08/2021
 */
public class PopcornFlavour
{
    public static final Codec<PopcornFlavour> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("id").forGetter(flavour -> flavour.id),
            Codec.STRING.fieldOf("name").forGetter(flavour -> flavour.name),
            ResourceLocation.CODEC.fieldOf("guiTexture").forGetter(flavour -> flavour.guiTexture),
            Registry.ITEM.fieldOf("ingredient").forGetter(flavour -> flavour.ingredient),
            Codec.INT.fieldOf("amount").forGetter(flavour -> flavour.amount)
    ).apply(instance, PopcornFlavour::new));

    private final ResourceLocation id;
    private final String name;
    private final ResourceLocation guiTexture;
    private final Item ingredient;
    private final int amount;

    public PopcornFlavour(ResourceLocation id, String name, ResourceLocation guiTexture, Item ingredient, int amount)
    {
        this.id = id;
        this.name = name;
        this.guiTexture = guiTexture;
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public ResourceLocation getId()
    {
        return this.id;
    }

    public TranslationTextComponent getName()
    {
        return new TranslationTextComponent(this.name);
    }

    public ResourceLocation getGuiTexture()
    {
        return this.guiTexture;
    }

    public Item getIngredient()
    {
        return this.ingredient;
    }

    public int getAmount()
    {
        return this.amount;
    }
}
