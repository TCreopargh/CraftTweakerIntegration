package xyz.tcreopargh.ctintegration.vanilla;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.potions.IPotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

@ZenExpansion("crafttweaker.entity.IEntityLivingBase")
@ZenRegister
public class EntityLivingBaseExpansionMC {
    @ZenMethod
    public static IPotionEffect[] getAllPotionEffects(IEntityLivingBase living) {
        EntityLivingBase mcLiving = CraftTweakerMC.getEntityLivingBase(living);
        List<IPotionEffect> iPotionEffectList = new ArrayList<>();
        for (PotionEffect effect : mcLiving.getActivePotionEffects()) {
            iPotionEffectList.add(CraftTweakerMC.getIPotionEffect(effect));
        }
        return iPotionEffectList.toArray(new IPotionEffect[0]);
    }
}
