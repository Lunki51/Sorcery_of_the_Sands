package fr.lunki.sots.blocks;

import fr.lunki.sots.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class Obelisk extends DirectionalBlock implements EntityBlock {

    public static final IntegerProperty OBELISK_PART = IntegerProperty.create("complete",0,2);
    public Obelisk(Properties prop) {
        super(prop);
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(OBELISK_PART);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return Register.OBELISK_BLOCK_ENTITY.get().create(pos,state.setValue(OBELISK_PART,0));
    }



    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return p_153214_ == Register.OBELISK_BLOCK_ENTITY.get() ? ObeliskBlockEntity::tick : null;
    }
}
