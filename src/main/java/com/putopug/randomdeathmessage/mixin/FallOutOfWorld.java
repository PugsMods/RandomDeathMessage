package com.putopug.randomdeathmessage.mixin;

import com.google.gson.JsonObject;
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
     * @reason Randomize death messages
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid","med","404","high_sugar","f","kick","timeout","drill_forgot","no_breath","tp500","packet_fail","eol","tech","rmdir","taskkill","player_hate_world","terminator","lion","no_appointment","busted","thanos_snap","soft","aim","homework","jawdrop","lag","all_make_mistakes","hmm","did_i_mention","no_gravity","balloon","error","sigh","stone","princess","twice","no_friends","clumsy","god","detonator","destroyer3001","dumme","sethealth","rock","shock","river_end","wha","gladiator","uranium","lost_win_chance","too_hard","laugh_2_hard","noob","sus","reset","music","refuel","fragment","function","mutate","forge","achieve_death","claim","sold_brain","vrm_cooling","cpu_amongus","no_mobo_compat","corrupt_bios","odd_one_out","fnaf5","lightning_can_strike_2","scp-498","carve"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        return new TranslationTextComponent(s1, p_151519_1_.getDisplayName());
    }
}
