package game.filehandle;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import game.equipment.Inventory;

public class ExclusionStrategyBuilder {
    public ExclusionStrategy create() {
        return new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes field) {
                if(field.getName().equals("inventory") || field.getName().equals("effects")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        };
    }
}
