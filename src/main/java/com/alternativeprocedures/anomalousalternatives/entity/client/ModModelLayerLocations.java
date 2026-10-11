package com.alternativeprocedures.anomalousalternatives.entity.client;

import com.alternativeprocedures.anomalousalternatives.SCPAnomalousAlternatives;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayerLocations {
    public static final ModelLayerLocation DEER =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "deer"), "main");
    public static final ModelLayerLocation SCP131 =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(SCPAnomalousAlternatives.MODID, "scp131"), "main");
}
