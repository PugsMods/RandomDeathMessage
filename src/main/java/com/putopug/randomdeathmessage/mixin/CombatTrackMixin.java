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
     * @reason Randomize Death messages
     */
    @Overwrite
    public ITextComponent getDeathMessage() {
        Random index = new Random();
        String[] arr = {"wasted","game_over","ditch","fail","stop_trying","oof","throw","eject","killed","gravity","huston","flight","cooked","stupid","med","404","high_sugar","f","kick","timeout","drill_forgot","no_breath","tp500","packet_fail","eol","tech","rmdir","taskkill","player_hate_world","terminator","lion","no_appointment","busted","thanos_snap","soft","aim","homework","jawdrop","lag","all_make_mistakes","hmm","did_i_mention","no_gravity","balloon","error","sigh","stone","princess","twice","no_friends","clumsy","god","detonator","destroyer3001","dumme","sethealth","rock","shock","river_end","wha","gladiator","uranium","lost_win_chance","too_hard","laugh_2_hard","noob","sus","reset","music","refuel","fragment","function","mutate","forge","achieve_death","claim","sold_brain","vrm_cooling","cpu_amongus","no_mobo_compat","corrupt_bios","odd_one_out","fnaf5","lightning_can_strike_2","scp-498","carve","tpltp","draw_hearts","space_forgot_suit","tos","logger","goztbuzter","lifecycle_crash","moontos_and_kola_fizzy","forgot_smalltext","BEANS","respect_beans","user-user","flex","mayday","d_death","gigaBLAST","snippety_snip","future","sharpness1000000","popped_totem","no-more_now-amoogus","tick_tock","calc_trajectory_fail","code_loop","hot","err_playerdisk","freezedry","fragile","no_life_of_own","achievement","monke","basics_of_life","breakfast","no_money_for_life","anthony","paste","slide_to_hell","piranha_plant","not_like_living_too_much","driver","ingest_plutonium","reddit","mask","too_cool","too_cursed","why","knife","ants","scared","sketchy","split","acid","impossible4player","forgot_water","THICC","air","ate_cloud","worldhate","glitch","dirty","ouch","neg_lq","too_big_dream","boil","bug","burp","learn2die","headache","2happy","doge","soa_impossible","life_license_expired","itch","2stressed","shock_world","heart","x","why_giveup","hungry","dance","bats","doge2","ganb","die_o_rite","compress","bingewatch","punch","nails","heater","broke","scam","kidney_stone","mouse","plastic","soi","ransomware","lego","end","yoow","fmllifecycle","light","smooth","square","invis","sense","rent","funn_e","sweaty","ahb","reality_stone","cease","ragequit","rpaste","lifeengine","333update","KEYBOARD","dynamite","sleep","measurement","C0LD","pro","del","planestick","TNT","lavaair","battery","offering","selfbrain?","squishy","tall","T0RE","guilty","pugs","bingbong","unlive","ssd","rick_roll","hell","captcha","morph","eyedee","scifi","int","ineff","imrunningout","run","unlife","sleep2","mic","punchscreen","cook","gun","egg","chop","rip","elastic","type","headphones","kefud?","hotclimate","dinner","joke","oil","okulus","sol","insert","beans","infel","brainvac","Water","konfused","coffee","dirt","trip","brokeleg","itchalot","forgeload","gunfire","gas","outage"};
        String s = "death.rdm.";
        String s1 = s + arr[index.nextInt(arr.length)];
        CombatEntry combatentry1 = this.entries.get(this.entries.size() - 1);
        Entity entity = combatentry1.getSource().getEntity();
        assert entity != null;
        return new TranslationTextComponent(s1,entity.getDisplayName());
    }
}
