package fr.lunki.sots.blocks;

import fr.lunki.sots.registry.SOTSBlocksEntities;
import fr.lunki.sots.registry.SOTSBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ObeliskBlockEntityBase extends BlockEntity {

    private boolean isBase;
    private boolean complete;

    public ObeliskBlockEntityBase(BlockPos p_155229_, BlockState p_155230_) {
        super(SOTSBlocksEntities.OBELISK_BLOCK_ENTITY.get(),p_155229_, p_155230_);
        this.isBase = false;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T t) {
        ObeliskBlockEntityBase blockEntity = (ObeliskBlockEntityBase) t;
        blockEntity.updateStructure(level,pos,state);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        this.updateStructure(level,this.worldPosition,this.getBlockState());
        return super.getUpdatePacket();
    }

    @Override
    protected void saveAdditional(CompoundTag p_187471_) {
        super.saveAdditional(p_187471_);
        p_187471_.putBoolean("isBase",isBase);
    }

    @Override
    public void load(CompoundTag p_155245_) {
        super.load(p_155245_);
        this.isBase = p_155245_.getBoolean("isBase");
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public void updateStructure(Level level,BlockPos pos,BlockState state){
        if(this.isBase){
            if(this.checkIntegrity(level,pos)==6){
                ObeliskBase.set3D(level,pos,state);
                BlockPos current = pos.above();
                for(int j=0;j<7;j++){
                    ObeliskBlock.setInvinsible(level,current,level.getBlockState(current));
                    current = current.above();
                }
            }else{
                this.isBase = false;
                ObeliskBase.setDefault(level,pos,state);
                BlockPos current = pos.above();
                for(int j=0;j<7;j++){
                    if(level.getBlockState(current).getBlock() instanceof ObeliskBlock){
                        ObeliskBlock.setVisible(level,current,level.getBlockState(current));
                    }
                    current = current.above();
                }
            }
        }
    }

    public int checkIntegrity(Level level, BlockPos pos){
        int i=0;
        BlockPos current = pos.above();
        while(i!=7 && !level.getBlockState(current).is(SOTSBlocks.OBELISK_BLOCK_TOP.get())){
            if(!level.getBlockState(current).is(SOTSBlocks.OBELISK_BLOCK_BASE.get())){
                return -1;
            }
            current = current.above();
            i++;
        }
        return i;
    }

    public void onDestroyed(Level level,BlockPos pos,BlockState state) {
        this.isBase = false;
        ObeliskBase.setDefault(level,pos,state);
        BlockPos current = pos.above();
        for(int j=0;j<7;j++){
            if(level.getBlockState(current).getBlock() instanceof ObeliskBlock){
                ObeliskBlock.setVisible(level,current,level.getBlockState(current));
            }
            current = current.above();
        }
    }
}