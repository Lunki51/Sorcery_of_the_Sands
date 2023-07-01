package fr.lunki.sots.blocks;

import fr.lunki.sots.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ObeliskBlockEntity extends BlockEntity {

    private boolean isBase;
    private boolean complete;

    public ObeliskBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(Register.OBELISK_BLOCK_ENTITY.get(),p_155229_, p_155230_);
        this.isBase = false;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        ObeliskBlockEntity blockEntity = (ObeliskBlockEntity) t;
        if(blockEntity.isBase){
            int number = 1;
            BlockPos currentPos = blockPos.above();
            while(number !=8 && level.getBlockEntity(currentPos,Register.OBELISK_BLOCK_ENTITY.get()).isPresent()){
                ObeliskBlockEntity aboveEntity = (ObeliskBlockEntity) level.getBlockEntity(currentPos);
                aboveEntity.isBase = false;
                level.setBlockEntity(aboveEntity);
                currentPos = currentPos.above();
                number++;
            }
            if(number==8){
                blockEntity.complete = true;
                level.setBlock(blockPos,blockState.setValue(Obelisk.OBELISK_PART,1),3);
                currentPos = blockPos.above();
                for(int i=1;i<8;i++){
                    level.setBlock(currentPos,blockState.setValue(Obelisk.OBELISK_PART,2),3);
                    currentPos = currentPos.above();
                }
            }else{
                blockEntity.complete = false;
                level.setBlock(blockPos,blockState.setValue(Obelisk.OBELISK_PART,0),3);
                currentPos = blockPos.above();
                for(int i=1;i<number;i++){
                    level.setBlock(currentPos,blockState.setValue(Obelisk.OBELISK_PART,0),3);
                    currentPos = currentPos.above();
                }
            }
        }else{
            if(!level.getBlockEntity(blockPos.below(),Register.OBELISK_BLOCK_ENTITY.get()).isPresent()){
                blockEntity.isBase = true;
            }
        }

    }
}
