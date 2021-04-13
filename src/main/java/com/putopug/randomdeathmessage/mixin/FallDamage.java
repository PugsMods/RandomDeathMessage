/*
NOTICE: CURRENTLY NOT WORKING
package com.putopug.randomdeathmessage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ServerPlayerEntity.class)
@SuppressWarnings("all")
public class FallDamage {
    @Overwrite
    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (this.isInvulnerableTo(p_70097_1_)) {
            return false;
        } else {
            boolean flag = this.server.isDedicatedServer() && this.isPvpAllowed() && "fall".equals(p_70097_1_.msgId);
            if (!flag && this.spawnInvulnerableTime > 0 && p_70097_1_ != DamageSource.OUT_OF_WORLD) {
                return false;
            } else {
                if (p_70097_1_ instanceof EntityDamageSource) {
                    Entity entity = p_70097_1_.getEntity();
                    if (entity instanceof PlayerEntity && !this.canHarmPlayer((PlayerEntity)entity)) {
                        return false;
                    }

                    if (entity instanceof AbstractArrowEntity) {
                        AbstractArrowEntity abstractarrowentity = (AbstractArrowEntity)entity;
                        Entity entity1 = abstractarrowentity.getOwner();
                        if (entity1 instanceof PlayerEntity && !this.canHarmPlayer((PlayerEntity)entity1)) {
                            return false;
                        }
                    }
                }

                return super.hurt(p_70097_1_, p_70097_2_);
            }
        }
    }

}
*/