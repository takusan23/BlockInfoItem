package com.takusan_23.blockinfoitem.proxy;

import com.takusan_23.blockinfoitem.blockinfoitem_items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        blockinfoitem_items.init();
        blockinfoitem_items.register();
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        blockinfoitem_items.registerRenders();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
    public static void registerItems(RegistryEvent.Register<Item> event) {
        blockinfoitem_items.init();
        blockinfoitem_items.register();
    }

    public static void registerModels(ModelRegistryEvent event) {
        blockinfoitem_items.registerRenders();
    }



}
