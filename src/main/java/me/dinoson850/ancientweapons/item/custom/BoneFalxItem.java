package me.dinoson850.ancientweapons.item.custom;

import me.dinoson850.ancientweapons.effect.ModEffects;
import me.dinoson850.ancientweapons.util.IPlayerEntityAttackCooldownGetter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BoneFalxItem extends SwordItem {
    public BoneFalxItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient) {
            if (attacker.isPlayer()) {
                float prevAttackCooldown = ((IPlayerEntityAttackCooldownGetter)attacker).getPrevAttackCooldown();
                if (prevAttackCooldown < 1.0) {
                    return super.postHit(stack, target, attacker);
                }
            }
            var instance = new StatusEffectInstance(ModEffects.PHYTOTOXIN_EFFECT, 35, 0, false, true, true);
            target.addStatusEffect(instance);
        }

        return super.postHit(stack, target, attacker);
    }
}
