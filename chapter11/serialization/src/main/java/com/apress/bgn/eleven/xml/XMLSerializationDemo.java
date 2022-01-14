package com.apress.bgn.eleven.xml;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by iuliana.cosmina on 19/07/2021
 */
public class XMLSerializationDemo {

    private static final Logger log = LoggerFactory.getLogger(XMLSerializationDemo.class);
    
    public static void main(String... args) {
        LocalDate johnBd = LocalDate.of(1977, Month.OCTOBER, 16);
        Singer john = new Singer("John Mayer", 5.0, johnBd);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            String xml = xmlMapper.writeValueAsString(john);
            Files.writeString(Path.of("chapter11/serialization/src/test/resources/output/john.xml"), xml,
                    StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.info("Serialization to XML failed! ", e);
        }

        try {
            Singer copyOfJohn = xmlMapper.readValue(Path.of("chapter11/serialization/src/test/resources/output/john.xml").toFile(), Singer.class);
            log.info("Are objects equal? {}", copyOfJohn.equals(john));
            log.info("--> {}", copyOfJohn);
        } catch (IOException e) {
            log.info("Deserialization of XML failed! ", e);
        }

    }
}
