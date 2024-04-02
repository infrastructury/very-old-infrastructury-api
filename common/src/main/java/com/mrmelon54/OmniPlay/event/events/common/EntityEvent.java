package com.mrmelon54.OmniPlay.event.events.common;

import com.mrmelon54.OmniPlay.event.EventWrapper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;
import remapped.architectury.event.Event;
import remapped.architectury.event.EventResult;

public interface EntityEvent {
    interface Inner extends remapped.architectury.event.events.common.EntityEvent {
    }

    Event<LivingDeath> LIVING_DEATH = EventWrapper.of(Inner.LIVING_DEATH, livingDeath -> livingDeath::die);
    Event<LivingHurt> LIVING_HURT = EventWrapper.of(Inner.LIVING_HURT, livingHurt -> livingHurt::hurt);
    Event<LivingCheckSpawn> LIVING_CHECK_SPAWN = EventWrapper.of(Inner.LIVING_CHECK_SPAWN, livingCheckSpawn -> livingCheckSpawn::canSpawn);
    Event<Add> ADD = EventWrapper.of(Inner.ADD, add -> add::add);
    Event<EnterSection> ENTER_SECTION = EventWrapper.of(Inner.ENTER_SECTION, enterSection -> enterSection::enterSection);
    Event<AnimalTame> ANIMAL_TAME = EventWrapper.of(Inner.ANIMAL_TAME, animalTame -> animalTame::tame);

    interface LivingDeath {
        EventResult die(LivingEntity entity, DamageSource source);
    }

    interface LivingHurt {
        EventResult hurt(LivingEntity entity, DamageSource source, float amount);
    }

    interface LivingCheckSpawn {
        EventResult canSpawn(LivingEntity entity, LevelAccessor world, double x, double y, double z, MobSpawnType type, @Nullable BaseSpawner spawner);
    }

    interface Add {
        EventResult add(Entity entity, Level world);
    }

    interface EnterSection {
        void enterSection(Entity entity, int sectionX, int sectionY, int sectionZ, int prevX, int prevY, int prevZ);
    }

    interface AnimalTame {
        EventResult tame(Animal animal, Player player);
    }
}