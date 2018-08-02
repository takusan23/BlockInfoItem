package com.takusan_23.blockinfoitem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class blockinfoitem_items {

    public static Item BlockInfoItem;

    public static void init() {
        BlockInfoItem = new BlockInfoItem_Class().setUnlocalizedName("BlockInfoItem").setCreativeTab(CreativeTabs.TOOLS).setMaxStackSize(1);
    }

    public static void register() {
        registerItem(BlockInfoItem,"blockinfoitem");
    }

    public static void registerItem(Item item, String string) {
        item.setRegistryName(new ResourceLocation(blockinfoitem.MOD_ID, string));
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerRenders() {
        registerRender(BlockInfoItem);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}



