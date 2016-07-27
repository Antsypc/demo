package xyz.antsgroup.demo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateTimeDeserialize extends JsonDeserializer<Long> {
    @Override public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getValueAsString();

        if (value == null) {
            return 0L;
        } else if (value.isEmpty()) {
            return 1L;
        } else if (value.equals("null")) {
            return 2L;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException e) {
            date = new Date(0);
        }
        return date.getTime() / 1000;
    }
}
