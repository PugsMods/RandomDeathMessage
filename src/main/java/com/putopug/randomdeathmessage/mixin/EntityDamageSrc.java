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
     * @reason Randomize death messages
     */
    @Overwrite
    public ITextComponent getLocalizedDeathMessage(LivingEntity p_151519_1_) {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid","med","404","high_sugar","f","kick","timeout","drill_forgot","no_breath","tp500","packet_fail","eol","tech","rmdir","taskkill","player_hate_world","terminator","lion","no_appointment","busted","thanos_snap","soft","aim","homework","jawdrop","lag","all_make_mistakes","hmm","did_i_mention","no_gravity","balloon","error","sigh","stone","princess","twice","no_friends","clumsy","god","detonator","destroyer3001","dumme","sethealth","rock","shock","river_end","wha","gladiator","uranium","lost_win_chance","too_hard","laugh_2_hard","noob","sus","reset","music","refuel","fragment","function","mutate","forge","achieve_death","claim","sold_brain","vrm_cooling","cpu_amongus","no_mobo_compat","corrupt_bios","odd_one_out","fnaf5","lightning_can_strike_2","scp-498","carve","tpltp","draw_hearts","space_forgot_suit","tos","logger","goztbuzter","lifecycle_crash","moontos_and_kola_fizzy","forgot_smalltext","BEANS","respect_beans","user-user","flex","mayday","d_death","gigaBLAST","snippety_snip","future","sharpness1000000","popped_totem","no-more_now-amoogus","tick_tock","calc_trajectory_fail","code_loop","hot","err_playerdisk","freezedry","fragile","no_life_of_own"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        ItemStack itemstack = this.entity instanceof LivingEntity ? ((LivingEntity)this.entity).getMainHandItem() : ItemStack.EMPTY;
        return !itemstack.isEmpty() && itemstack.hasCustomHoverName() ? new TranslationTextComponent(s1 , p_151519_1_.getDisplayName(), this.entity.getDisplayName(), itemstack.getDisplayName()) : new TranslationTextComponent(s1, p_151519_1_.getDisplayName(), this.entity.getDisplayName());
    }
}
