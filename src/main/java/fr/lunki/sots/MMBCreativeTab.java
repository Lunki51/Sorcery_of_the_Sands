package fr.lunki.sots;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MMBCreativeTab extends CreativeModeTab {


    public MMBCreativeTab(int p_40773_, String p_40774_) {
        super(p_40773_, p_40774_);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Register.ANKH.get());
    }
}
