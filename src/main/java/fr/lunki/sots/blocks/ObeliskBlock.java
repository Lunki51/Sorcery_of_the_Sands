package fr.lunki.sots.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ObeliskBlock extends Block {

    public static final BooleanProperty OBELISK_INVISIBLE = BooleanProperty.create("invisible");
    public ObeliskBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.defaultBlockState().setValue(OBELISK_INVISIBLE,false));
    }

    public static void setVisible(Level level, BlockPos pos, BlockState state) {
        level.setBlock(pos,state.setValue(OBELISK_INVISIBLE,false),3);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(OBELISK_INVISIBLE);
        super.createBlockStateDefinition(p_49915_);
    }

    public static void setInvinsible(Level level, BlockPos pos, BlockState state){
        level.setBlock(pos,state.setValue(OBELISK_INVISIBLE,true),3);
    }
}
