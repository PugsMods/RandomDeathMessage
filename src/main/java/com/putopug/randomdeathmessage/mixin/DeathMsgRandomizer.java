package com.putopug.randomdeathmessage.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DamageSource.class)
public class DeathMsgRandomizer {

    /**
     * @author: PutoPug/PugzAreCute
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        String s = "death.attack";
        String s1 = s + ".generic";
        return new TranslationTextComponent(s1);
    }
}
