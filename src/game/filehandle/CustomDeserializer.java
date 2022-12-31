package game.filehandle;

import com.owlike.genson.Context;
import com.owlike.genson.Converter;
import com.owlike.genson.Deserializer;
import com.owlike.genson.GenericType;
import com.owlike.genson.stream.ObjectReader;
import com.owlike.genson.stream.ObjectWriter;
import game.creature.PlayerCharacter;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;

import java.util.HashMap;
import java.util.Map;

public class CustomDeserializer implements Deserializer<PlayerCharacter> {
    private GenericType<AttributeValue> attributeType = new GenericType<AttributeValue>(){};
    @Override
    public PlayerCharacter deserialize(ObjectReader reader, Context ctx) throws Exception {
        PlayerCharacter player = new PlayerCharacter();
        Map<IAttributeEnum, AttributeValue> attributes = new HashMap<>();
        
        reader.beginObject();
        
        while(reader.hasNext()) {
            reader.next();
            System.out.println("Z PC : " + reader.name());
            
            if(reader.name().equals("name")) {
                player.setName(reader.valueAsString());
            }
            if(reader.name().equals("statistics")) {
                reader.beginObject();
                while(!reader.name().equals("attributes")) {
                    reader.next();
                }
                reader.beginObject(); //reading attributes
                
                while(reader.hasNext()) {
                    reader.next();
                    IAttributeEnum attributeEnum = AttributeEnum.valueOf(reader.name());
                    //reader.beginObject();
                    
                    AttributeValue attributeValue = ctx.genson.deserialize(attributeType, reader, ctx);
                    /*System.out.println(attributeEnum);
                    while(reader.hasNext()) {
                        reader.next();
                        System.out.println(reader.name());
                    }
                    System.out.println();*/
                    
                    //reader.endObject();
                    
                    attributes.put(attributeEnum, attributeValue);
                }
                reader.endObject();
                
                reader.endObject();
            }
        }
        reader.endObject();
        
        player.setStatistics(new StatisticsWarhammer(attributes));
        return player;
    }
}
