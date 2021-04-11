package com.putopug.randomdeathmessage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(IndirectEntityDamageSource.class)
public class IndirectEntityDamageSrc {
    private final Entity owner;
    protected final Entity entity;
    public IndirectEntityDamageSrc(Entity owner, Entity entity) {
        this.owner = owner;
        this.entity = entity;
    }

    /**
     * @author: PutoPug/PugzAreCute
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        ITextComponent itextcomponent = this.owner == null ? this.entity.getDisplayName() : this.owner.getDisplayName();
        ItemStack itemstack = this.owner instanceof LivingEntity ? ((LivingEntity)this.owner).getMainHandItem() : ItemStack.EMPTY;
        String s = "";
        String s1 = s + "death.rdm.stupid";
        return !itemstack.isEmpty() && itemstack.hasCustomHoverName() ? new TranslationTextComponent(s1, p_151519_1_.getDisplayName(), itextcomponent, itemstack.getDisplayName()) : new TranslationTextComponent(s1, p_151519_1_.getDisplayName(), itextcomponent);
    }
}
