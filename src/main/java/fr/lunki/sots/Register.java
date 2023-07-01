package fr.lunki.sots;

import fr.lunki.sots.blocks.Obelisk;
import fr.lunki.sots.blocks.ObeliskBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Register {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Main.MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);



    /////////////////////////////

    public static final RegistryObject<Item> ANKH = ITEMS.register("ankh",()->new Item(new Item.Properties()));



    public static final MMBCreativeTab MMB_CREATIVE_TAB = new MMBCreativeTab(CreativeModeTab.TABS.length, "sots");
    public static final RegistryObject<Block> OBELISK_BLOCK = BLOCKS.register("obelisk", () -> new Obelisk(BlockBehaviour.Properties.of(Material.STONE)));

    public static final RegistryObject<BlockEntityType<ObeliskBlockEntity>> OBELISK_BLOCK_ENTITY = BLOCKS_ENTITY.register("obelisk_block_entity", () -> BlockEntityType.Builder.of(ObeliskBlockEntity::new, OBELISK_BLOCK.get()).build(null));

    public static final RegistryObject<Item> OBELISK_ITEM = ITEMS.register("obelisk",()->new BlockItem(OBELISK_BLOCK.get(),new Item.Properties().tab(Register.MMB_CREATIVE_TAB)));

}
