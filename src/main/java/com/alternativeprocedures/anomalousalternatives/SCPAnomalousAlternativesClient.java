package com.alternativeprocedures.anomalousalternatives;

import com.alternativeprocedures.anomalousalternatives.entity.ModEntities;
import com.alternativeprocedures.anomalousalternatives.entity.client.deer.DeerModel;
import com.alternativeprocedures.anomalousalternatives.entity.client.deer.DeerRenderer;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp049.scp049Model;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp049.scp049Renderer;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp049_2.scp049_2Model;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp049_2.scp049_2Renderer;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp131.scp131Model;
import com.alternativeprocedures.anomalousalternatives.entity.client.scp131.scp131Renderer;
import com.alternativeprocedures.anomalousalternatives.entity.client.ModModelLayerLocations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = SCPAnomalousAlternatives.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = SCPAnomalousAlternatives.MODID, value = Dist.CLIENT)
public class SCPAnomalousAlternativesClient {
    public SCPAnomalousAlternativesClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }


    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.DEER.get(), DeerRenderer::new);
        EntityRenderers.register(ModEntities.SCP131.get(), scp131Renderer::new);
        EntityRenderers.register(ModEntities.SCP049.get(), scp049Renderer::new);
        EntityRenderers.register(ModEntities.SCP049_2.get(), scp049_2Renderer::new);

        // Some client setup code
        SCPAnomalousAlternatives.LOGGER.info("HELLO FROM CLIENT SETUP");
        SCPAnomalousAlternatives.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


    }


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayerLocations.DEER, DeerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.SCP131, scp131Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.SCP049, scp049Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.SCP049_2, scp049_2Model::createBodyLayer);
    }

}
