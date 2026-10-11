package com.alternativeprocedures.anomalousalternatives.event;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import com.alternativeprocedures.anomalousalternatives.entity.ModEntities;
import com.alternativeprocedures.anomalousalternatives.entity.custom.DeerEntity;
import com.alternativeprocedures.anomalousalternatives.entity.custom.scp131Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = SCPAnomalousAlternatives.MODID)

public class ModEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.DEER.get(), DeerEntity.createAttributes().build());
        event.put(ModEntities.SCP131.get(), scp131Entity.createAttributes().build());

    }

}
