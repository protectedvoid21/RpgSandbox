package game.filehandle;

import com.google.gson.*;
import game.generals.AttributeValue;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IStatistics;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class StatisticsDeserializer implements JsonDeserializer<IStatistics> {
    @Override
    public IStatistics deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject statisticsObject = jsonElement.getAsJsonObject();

        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        
        JsonObject attributeObject = statisticsObject.get("attributes").getAsJsonObject();
        
        for(var enumKey : AttributeEnum.values()) {
            JsonElement att = attributeObject.get(enumKey.toString());
            AttributeValue attributeValue = context.deserialize(att, AttributeValue.class);
            attributes.put(enumKey, attributeValue);
        }
        
        StatisticsWarhammer stats = new StatisticsWarhammer(attributes);
        return stats;
    }
}
