package com.putopug.randomdeathmessage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(EntityDamageSource.class)
public class EntityDamageSrc {
    protected final Entity entity;

    public EntityDamageSrc(Entity entity) {
        this.entity = entity;
    }
    /**
     * @author PutoPug/PugzAreCute
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        ItemStack itemstack = this.entity instanceof LivingEntity ? ((LivingEntity)this.entity).getMainHandItem() : ItemStack.EMPTY;
        return !itemstack.isEmpty() && itemstack.hasCustomHoverName() ? new TranslationTextComponent(s1 , p_151519_1_.getDisplayName(), this.entity.getDisplayName(), itemstack.getDisplayName()) : new TranslationTextComponent(s1, p_151519_1_.getDisplayName(), this.entity.getDisplayName());
    }
}
