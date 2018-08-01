package com.takusan_23.blockinfoitem;

import net.minecraft.block.Block;
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
import net.minecraft.world.World;

public class BlockInfoItem_Class extends Item {

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        player.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP,1,1);

        //スタート
        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("---------- Block Info ----------"));
            player.sendMessage(new TextComponentString(""));
        }


        //名前
        String blockname = block.getLocalizedName();

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("Name " + blockname));
        }


        //爆破耐性取得、二行目はfloat→String
        float blockhardness =  block.getExplosionResistance(player) ;
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

        if (blockharvestlevel == 3)
        {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Diamond"));
            }
        }
        if (blockharvestlevel == 2)
        {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Iron"));
            }
        }
        if (blockharvestlevel == 1)
        {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Stone"));
            }
        }
        if (blockharvestlevel == 0)
        {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "Tool"));
            }
        }
        if (blockharvestlevel == -1 )
        {
            if (!worldIn.isRemote) {
                player.sendMessage(new TextComponentString("HervestLevel " + "No Tool"));
            }
        }


        //照明？
        int blocklight = block.getLightValue(iblockstate,worldIn,pos);
        String blocklight_string = String.valueOf(blocklight);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("Light Level " + blocklight_string));
        }



        //経験値
        int blockexpdrop_3 = block.getExpDrop(iblockstate,worldIn,pos,3);
        String blockexpdrop_3_string = String.valueOf(blockexpdrop_3);

        int blockexpdrop_2 = block.getExpDrop(iblockstate,worldIn,pos,2);
        String blockexpdrop_2_string = String.valueOf(blockexpdrop_2);

        int blockexpdrop_1 = block.getExpDrop(iblockstate,worldIn,pos,1);
        String blockexpdrop_1_string = String.valueOf(blockexpdrop_1);

        int blockexpdrop_0 = block.getExpDrop(iblockstate,worldIn,pos,0);
        String blockexpdrop_0_string = String.valueOf(blockexpdrop_0);

        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString("ExpDrop " + "Fortune 3→" +blockexpdrop_3_string + " Fortune 2→" + blockexpdrop_2_string+ " Fortune 1→" + blockexpdrop_1_string+ " Fortune 0→" + blockexpdrop_0_string));
        }


        //目印に
        if (!worldIn.isRemote) {
            player.sendMessage(new TextComponentString(""));
            player.sendMessage(new TextComponentString("---------- Last ----------"));
        }

        return EnumActionResult.SUCCESS;

    }
}
