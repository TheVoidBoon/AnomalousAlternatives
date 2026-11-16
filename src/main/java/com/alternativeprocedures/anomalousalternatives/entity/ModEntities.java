package com.alternativeprocedures.anomalousalternatives.entity;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.custom.DeerEntity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049_2Entity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp131Entity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.createEntities(SCPAnomalousAlternatives.MODID);

    public static final ResourceKey<EntityType<?>> DEER_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "deer"));
    public static final ResourceKey<EntityType<?>> SCP131_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "scp131"));
    public static final ResourceKey<EntityType<?>> SCP049_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "scp049"));
    public static final ResourceKey<EntityType<?>> SCP049_2_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "scp049_2"));


    public static final Supplier<EntityType<DeerEntity>> DEER = ENTITY_TYPES.register("deer",
            () -> EntityType.Builder.of(DeerEntity::new, MobCategory.CREATURE).sized(1f, 2.5f).build(DEER_KEY));
    public static final Supplier<EntityType<scp131Entity>> SCP131 = ENTITY_TYPES.register("scp131",
            () -> EntityType.Builder.of(scp131Entity::new, MobCategory.CREATURE).sized( 1f,1f).build(SCP131_KEY));
    public static final Supplier<EntityType<scp049Entity>> SCP049 = ENTITY_TYPES.register("scp049",
            () -> EntityType.Builder.of(scp049Entity::new, MobCategory.CREATURE).sized( 1f,2f).build(SCP049_KEY));
    public static final Supplier<EntityType<scp049_2Entity>> SCP049_2 = ENTITY_TYPES.register("scp049_2",
            () -> EntityType.Builder.of(scp049_2Entity::new, MobCategory.MONSTER).sized( 1f,2f).build(SCP049_2_KEY));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
