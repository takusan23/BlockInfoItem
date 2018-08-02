package com.takusan_23.blockinfoitem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BlockInfoItem_Class extends Item {

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1, 1);

        //スタート
        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("---------- Block Info ----------"));
//            player.sendMessage(new TextComponentString(""));
        }


        //名前
        String blockname = block.getLocalizedName();
        //メタデータ
        int blockmetadeta = block.getMetaFromState(iblockstate);
        String blockmetadeta_string = String.valueOf(blockmetadeta);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentTranslation("Name " + blockname + " / MetaDeta " + blockmetadeta_string));
        }


        //爆破耐性取得、二行目はfloat→String
        float blockhardness = block.getExplosionResistance(player);
        String blockhardness_word = String.valueOf(blockhardness);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("Hardness " + blockhardness_word + "F"));
        }

        //最適ツール
        String blockharvesttool = block.getHarvestTool(iblockstate);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("Tool " + blockharvesttool));
        }

        //ハーベストレベル
        int blockharvestlevel = block.getHarvestLevel(iblockstate);

        if (blockharvestlevel == 3) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Diamond"));
            }
        }
        if (blockharvestlevel == 2) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Iron"));
            }
        }
        if (blockharvestlevel == 1) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Stone"));
            }
        }
        if (blockharvestlevel == 0) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Wood"));
            }
        }
        if (blockharvestlevel == -1) {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "No Tool"));
            }
        }


        //照明？
        int blocklight = block.getLightValue(iblockstate, worldIn, pos);
        String blocklight_string = String.valueOf(blocklight);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("Light Level " + blocklight_string));
        }


        //クリエタブ
        String blockcreativetab = block.getCreativeTabToDisplayOn().getTabLabel();

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("CreativeTab " + blockcreativetab));
        }


        //ドロップアイテム
        String item = block.getItem(worldIn,pos,iblockstate).getDisplayName();

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("DropItem " + item));
        }

        //エンチャントパワー
        float enchantpower = block.getEnchantPowerBonus(worldIn,pos);
        String enchantpower_string = String.valueOf(enchantpower);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("EnchantPower " + enchantpower_string));
        }


        //目印に
        if (!worldIn.isRemote) {
//            player.sendMessage(new TextComponentString(""));
            player.sendMessage(new TextComponentString("------------ Last ------------"));
        }

        return EnumActionResult.SUCCESS;

    }
}
