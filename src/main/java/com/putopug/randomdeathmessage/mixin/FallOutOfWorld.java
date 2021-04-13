package com.putopug.randomdeathmessage.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(DamageSource.class)
public class FallOutOfWorld {

    /**
     * @author PutoPug/PugzAreCute
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        return new TranslationTextComponent(s1, p_151519_1_.getDisplayName());
    }
}
