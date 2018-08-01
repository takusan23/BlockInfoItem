package com.takusan_23.blockinfoitem;

import com.takusan_23.blockinfoitem.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = blockinfoitem.MOD_ID,
        name = blockinfoitem.MOD_NAME,
        version = blockinfoitem.MOD_VERSION,
        dependencies = blockinfoitem.MOD_DEPENDENCIES,
        acceptedMinecraftVersions = blockinfoitem.MOD_ACCEPTED_MC_VERSIONS,
        useMetadata = true)

@Mod.EventBusSubscriber
public class blockinfoitem
{
    public static final String MOD_ID = "blockinfoitem";
    public static final String MOD_NAME = "BlockInfoItem";
    public static final String MOD_VERSION = "1.0.0";
    public static final String MOD_DEPENDENCIES ="required-after:forge@[1.12.2-14.23.4.2705,)";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.takusan_23.blockinfoitem.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.takusan_23.blockinfoitem.proxy.CommonProxy";
    public static final String SERVER_PROXY_CLASS = "com.takusan_23.blockinfoitem.proxy.ServerProxy";

    @SidedProxy(clientSide = blockinfoitem.CLIENT_PROXY_CLASS, serverSide = blockinfoitem.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static blockinfoitem Instance;

    @Mod.EventHandler

    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    private void preInit(FMLPreInitializationEvent event){
        blockinfoitem_items.init();
        blockinfoitem_items.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

    }


}
