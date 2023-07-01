package fr.lunki.sots;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static fr.lunki.sots.Register.*;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "sots";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Main() {

        IEventBus b = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(b);
        BLOCKS_ENTITY.register(b);
        ITEMS.register(b);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(Main.MODID, path);
    }



}
