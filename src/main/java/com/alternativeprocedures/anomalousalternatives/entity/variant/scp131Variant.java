package com.alternativeprocedures.anomalousalternatives.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum scp131Variant {
    ORANGE(0),
    YELLOW(1);

    private static final scp131Variant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt
            (scp131Variant::getId)).toArray(scp131Variant[]::new);
    private final int id;

    scp131Variant(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public static scp131Variant byId(int id){
        return BY_ID[id % BY_ID.length];
    }

}
