package me.dinoson850.ancientweapons.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import me.dinoson850.ancientweapons.effect.ModEffects;
import me.dinoson850.ancientweapons.util.IPlayerEntityAttackCooldownGetter;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;

public class BoneClubItem extends ToolItem {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BoneClubItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float)attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

        if (!attacker.getWorld().isClient) {
            if (attacker.isPlayer()) {
                float prevAttackCooldown = ((IPlayerEntityAttackCooldownGetter)attacker).getPrevAttackCooldown();
                if (prevAttackCooldown < 1.0) {
                    return super.postHit(stack, target, attacker);
                }
            }
            var instance = new StatusEffectInstance(ModEffects.ARMOR_BREAK_EFFECT, 70, 0, false, true, true);
            target.addStatusEffect(instance);

            // attacker.getWorld().playSoundFromEntity(null, target, SoundEvents.BLOCK_BONE_BLOCK_BREAK, SoundCategory.PLAYERS, 2.0f, 0.7f);
        }


        return true;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
