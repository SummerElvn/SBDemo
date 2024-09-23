package com.example.demo.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.argument.StructuredArgument;
import net.logstash.logback.composite.loggingevent.ArgumentsJsonProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CustomArgumentJsonProvider extends ArgumentsJsonProvider {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {
        Object[] arguments = event.getArgumentArray();

        if (arguments != null) {
            for (Object argument : arguments) {
                if (argument instanceof StructuredArgument) {
                    ((StructuredArgument) argument).writeTo(generator);
                } else {
                    // Convert the object to JSON and write it
                    String json = objectMapper.writeValueAsString(argument);
                    generator.writeStringField("arguments", json);
                }
            }
        }
    }
}
