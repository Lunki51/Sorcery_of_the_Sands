package fr.lunki.sots.registry;

import fr.lunki.sots.Main;
import fr.lunki.sots.blocks.ObeliskBase;
import fr.lunki.sots.blocks.ObeliskBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOTSBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> OBELISK_BLOCK_BASE = BLOCKS.register("obelisk_base", () -> new ObeliskBase(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> OBELISK_BLOCK_TOP = BLOCKS.register("obelisk_top", () -> new ObeliskBlock(BlockBehaviour.Properties.of(Material.STONE)));
}
