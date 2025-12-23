package me.dinoson850.ancientweapons.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.dinoson850.ancientweapons.item.custom.BoneFalxItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityShieldDisabler {
    @Shadow
    public ItemStack getMainHandStack() { return null; }

    @ModifyReturnValue(
            method = "disablesShield",
            at = @At("RETURN")
    )
    protected boolean falxShieldDisable(boolean original) {
        return this.getMainHandStack().getItem() instanceof BoneFalxItem || original;
    }
}
