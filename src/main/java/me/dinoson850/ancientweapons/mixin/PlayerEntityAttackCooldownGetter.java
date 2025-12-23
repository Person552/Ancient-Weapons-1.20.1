package me.dinoson850.ancientweapons.mixin;

import me.dinoson850.ancientweapons.util.IPlayerEntityAttackCooldownGetter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityAttackCooldownGetter implements IPlayerEntityAttackCooldownGetter {
    public float prevAttackCooldown;

    @Override
    public float getPrevAttackCooldown() {
        return prevAttackCooldown;
    }

    @Shadow
    public abstract float getAttackCooldownProgress(float baseTime);

    @Inject( method="attack", at = @At("HEAD") )
    protected void logAttackCooldown(Entity target, CallbackInfo info) {
        prevAttackCooldown = this.getAttackCooldownProgress(0.5F);
    }
}
