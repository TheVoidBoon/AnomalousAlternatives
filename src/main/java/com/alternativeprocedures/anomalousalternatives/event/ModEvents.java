package com.alternativeprocedures.anomalousalternatives.event;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.ModEntities;
import com.alternativeprocedures.anomalousalternatives.entity.custom.DeerEntity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp049Entity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp131Entity;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = SCPAnomalousAlternatives.MODID)

public class ModEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.DEER.get(), DeerEntity.createAttributes().build());
        event.put(ModEntities.SCP131.get(), scp131Entity.createAttributes().build());
        event.put(ModEntities.SCP049.get(), scp049Entity.createAttributes().build());
        event.put(ModEntities.SCP049_2.get(), scp049Entity.createAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event){
        event.register(ModEntities.DEER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Animal::checkMobSpawnRules,RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }


}
