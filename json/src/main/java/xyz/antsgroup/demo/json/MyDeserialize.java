package xyz.antsgroup.demo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 *
 */
public class MyDeserialize extends JsonDeserializer<String> {

    @Override public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getValueAsString();
        if (value == null) {
            return "is null";
        } else if (value.isEmpty()) {
            return "is empty";
        } else if ("null".equals(value)) {
            return "is string 'null'";
        } else {
            return "other:" + value;
        }

    }
}
