package fr.lunki.sots.registry;

import fr.lunki.sots.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOTSItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> ANKH = ITEMS.register("ankh",()->new Item(new Item.Properties().tab(Main.MMB_CREATIVE_TAB)));

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",()->new Item(new Item.Properties().tab(Main.MMB_CREATIVE_TAB)));

    public static final RegistryObject<Item> OBELISK_TOP_ITEM = ITEMS.register("obelisk_top",()->new BlockItem(SOTSBlocks.OBELISK_BLOCK_TOP.get(),new Item.Properties().tab(Main.MMB_CREATIVE_TAB)));
    public static final RegistryObject<Item> OBELISK_BASE_ITEM = ITEMS.register("obelisk_base",()->new BlockItem(SOTSBlocks.OBELISK_BLOCK_BASE.get(),new Item.Properties().tab(Main.MMB_CREATIVE_TAB)));
}
