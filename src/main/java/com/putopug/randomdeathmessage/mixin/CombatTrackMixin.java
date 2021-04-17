package com.putopug.randomdeathmessage.mixin;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CombatEntry;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;
import java.util.Random;

@Mixin(CombatTracker.class)
public class CombatTrackMixin {
    private final List<CombatEntry> entries = Lists.newArrayList();
    /**
     * @author PugzAreCute/PutoPug
     */
    @Overwrite
    public ITextComponent getDeathMessage() {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid","med","404","high_sugar","f","kick","timeout","drill_forgot","no_breath","tp500","packet_fail","eol","tech","rmdir","taskkill","player_hate_world","terminator","lion","no_appointment","busted","thanos_snap","soft","aim","homework","jawdrop","lag","all_make_mistakes","hmm","did_i_mention","no_gravity","balloon","error","sigh","stone","princess","twice","no_friends","clumsy","god","detonator","destroyer3001","dumme","sethealth","rock","shock","river_end","wha","gladiator","uranium","lost_win_chance","too_hard","laugh_2_hard","noob"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        CombatEntry combatentry1 = this.entries.get(this.entries.size() - 1);
        Entity entity = combatentry1.getSource().getEntity();
       return new TranslationTextComponent(s1,entity.getDisplayName());
    }
}
