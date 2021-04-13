package com.putopug.randomdeathmessage.mixin;

import com.google.gson.JsonObject;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;
import java.util.Random;

@Mixin(DamageSource.class)
public class FallOutOfWorld {

    /**
     * @author PutoPug/PugzAreCute
     * @reason Randomize death messages
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        Random index = new Random();
        File file = new File("src/main/java/resources/assets/randomdeathmessage/lang/en_us.json");
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid","med","404","high_sugar","f","kick","timeout","drill_forgot","no_breath","tp500"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        return new TranslationTextComponent(s1, p_151519_1_.getDisplayName());
    }
}
