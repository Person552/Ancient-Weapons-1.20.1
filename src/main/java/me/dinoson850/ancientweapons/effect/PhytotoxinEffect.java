package me.dinoson850.ancientweapons.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PhytotoxinEffect extends StatusEffect {
    public PhytotoxinEffect() {
        super(StatusEffectCategory.HARMFUL,  0x9585e6);
    }


    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().magic(), (amplifier * 3f)+3f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
