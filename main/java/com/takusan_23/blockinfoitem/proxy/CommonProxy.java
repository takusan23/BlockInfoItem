package com.takusan_23.blockinfoitem.proxy;

import com.takusan_23.blockinfoitem.blockinfoitem_items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        blockinfoitem_items.init();
        blockinfoitem_items.register();
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
