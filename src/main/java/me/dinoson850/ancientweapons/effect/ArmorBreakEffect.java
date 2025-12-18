package me.dinoson850.ancientweapons.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ArmorBreakEffect extends StatusEffect {
    public ArmorBreakEffect() {
        super(StatusEffectCategory.HARMFUL,  0x9585e6);
    }


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        return;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
