package fr.lunki.sots.registry;

import fr.lunki.sots.Main;
import fr.lunki.sots.blocks.ObeliskBlockEntityBase;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOTSBlocksEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Main.MODID);

    public static final RegistryObject<BlockEntityType<ObeliskBlockEntityBase>> OBELISK_BLOCK_ENTITY = BLOCKS_ENTITY.register("obelisk_block_entity", () -> BlockEntityType.Builder.of(ObeliskBlockEntityBase::new, SOTSBlocks.OBELISK_BLOCK_BASE.get()).build(null));
}
