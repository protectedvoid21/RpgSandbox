package game.filehandle;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExcludeStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes field) {
        if(field.getName().equals("effects")) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
