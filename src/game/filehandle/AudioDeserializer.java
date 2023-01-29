package game.filehandle;

import com.google.gson.*;
import controllers.audio.ICustomEnumAudio;
import controllers.audio.WarhammerEnumAudio;
import game.generals.AttributeValue;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.struggleWarhammer.Aiming;
import game.interfaces.IAttributeEnum;
import game.interfaces.IStatistics;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class AudioDeserializer implements JsonDeserializer<ICustomEnumAudio> {
    @Override
    public ICustomEnumAudio deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        var audioEnumText = jsonElement.getAsString();

        return WarhammerEnumAudio.valueOf(audioEnumText);
    }
}
