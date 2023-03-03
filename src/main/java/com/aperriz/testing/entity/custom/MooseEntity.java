package com.aperriz.testing.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;


public class MooseEntity<T extends EntityType> extends Animal implements GeoEntity, NeutralMob {

    private UUID persistentAngerTarget;
    private int attackAnimationTick;
    private int remainingPersistentAngerTime;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);



    public MooseEntity(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1D, 32.0F));
        this.goalSelector.addGoal(10, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0D, 1.2D));
        super.registerGoals();
    }

    public void die(DamageSource p_30384_) {
        super.die(p_30384_);
    }

    public boolean hurt(DamageSource p_28848_, float p_28849_) {
        boolean flag = super.hurt(p_28848_, p_28849_);
        return flag;
    }

    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }

        if (this.getDeltaMovement().horizontalDistanceSqr() > (double)2.5000003E-7F && this.random.nextInt(5) == 0) {
            int i = Mth.floor(this.getX());
            int j = Mth.floor(this.getY() - (double)0.2F);
            int k = Mth.floor(this.getZ());
            BlockPos pos = new BlockPos(i, j, k);
            BlockState blockstate = this.level.getBlockState(pos);
            if (!blockstate.isAir()) {
                this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
            }
        }

        if (!this.level.isClientSide) {
            this.updatePersistentAnger((ServerLevel)this.level, true);
        }

    }

    public boolean canAttackType(EntityType<?> p_28851_) {

        return p_28851_ == EntityType.CREEPER ? false : super.canAttackType(p_28851_);

    }

    public void addAdditionalSaveData(CompoundTag p_28867_) {
        super.addAdditionalSaveData(p_28867_);
        this.addPersistentAngerSaveData(p_28867_);
    }

    public void readAdditionalSaveData(CompoundTag p_28857_) {
        super.readAdditionalSaveData(p_28857_);
        this.readPersistentAngerSaveData(this.level, p_28857_);
    }

    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    protected void playStepSound(BlockPos p_30415_, BlockState p_30416_) {
        this.playSound(SoundEvents.HORSE_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {return SoundEvents.HORSE_AMBIENT;}

    protected SoundEvent getHurtSound(DamageSource p_30424_) {
        return SoundEvents.HORSE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HORSE_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean doHurtTarget(Entity p_30372_) {
        boolean flag = p_30372_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, p_30372_);
        }

        return flag;
    }


    public void setRemainingPersistentAngerTime(int p_28859_) {
        this.remainingPersistentAngerTime = p_28859_;
    }

    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }


    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }


    public void setPersistentAngerTarget(@Nullable UUID p_21672_) {
        this.persistentAngerTarget = p_21672_;
    }


    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.ATTACK_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 4F)
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25D).build();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(DefaultAnimations.genericWalkIdleController(this));
        controllers.add(DefaultAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE));


    }

}

