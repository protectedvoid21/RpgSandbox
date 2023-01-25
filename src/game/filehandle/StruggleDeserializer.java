package game.filehandle;

import com.google.gson.*;
import game.generals.AttributeValue;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleAtributeEnum;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IStatistics;
import game.interfaces.IStruggleAtributeEnum;
import game.interfaces.IStruggleStatistics;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class StruggleDeserializer implements JsonDeserializer<IStruggleStatistics> {
    @Override
    public IStruggleStatistics deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject struggleObject = jsonElement.getAsJsonObject();

        Map<IStruggleAtributeEnum, AttributeValue> struggleAttributes = new HashMap<>();
        
        JsonObject attributeObject = struggleObject.get("struggleAttributes").getAsJsonObject();

        for(var enumKey : StruggleAtributeEnum.values()) {
            JsonElement att = attributeObject.get(enumKey.toString());
            AttributeValue attributeValue = context.deserialize(att, AttributeValue.class);
            struggleAttributes.put(enumKey, attributeValue);
        }
        
        return new StruggleStatisticsWarhammer();
    }
}
