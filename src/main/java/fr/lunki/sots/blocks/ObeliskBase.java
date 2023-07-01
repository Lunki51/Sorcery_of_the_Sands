package fr.lunki.sots.blocks;

import fr.lunki.sots.registry.SOTSBlocksEntities;
import fr.lunki.sots.registry.SOTSItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ObeliskBase extends ObeliskBlock implements EntityBlock {
    public static final BooleanProperty OBELISK_3D = BooleanProperty.create("3d");

    public ObeliskBase(Properties prop) {
        super(prop);
        this.registerDefaultState(this.defaultBlockState().setValue(OBELISK_3D,false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(OBELISK_3D);
        super.createBlockStateDefinition(p_49915_);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        ((ObeliskBlockEntityBase)level.getBlockEntity(pos)).onDestroyed(level,pos,state);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        ((ObeliskBlockEntityBase)level.getBlockEntity(pos)).onDestroyed(level,pos,state);
        super.onBlockExploded(state, level, pos, explosion);
    }

    public static void set3D(Level level, BlockPos pos, BlockState state){
        level.setBlock(pos,state.setValue(OBELISK_3D,true),3);
    }

    public static void setDefault(Level level, BlockPos pos, BlockState state){
        level.setBlock(pos,state.setValue(OBELISK_3D,false),3);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return SOTSBlocksEntities.OBELISK_BLOCK_ENTITY.get().create(pos,state);
    }



    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return p_153214_ == SOTSBlocksEntities.OBELISK_BLOCK_ENTITY.get() ? ObeliskBlockEntityBase::tick : null;
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(player.getItemInHand(hand).getItem().equals(SOTSItems.HAMMER.get())){
            ObeliskBlockEntityBase blockEntity = (ObeliskBlockEntityBase)level.getBlockEntity(pos);
            if(blockEntity.checkIntegrity(level,pos)==6){
                blockEntity.setBase(true);
            }
        }
        return super.use(state,level,pos,player,hand,result);
    }




}
