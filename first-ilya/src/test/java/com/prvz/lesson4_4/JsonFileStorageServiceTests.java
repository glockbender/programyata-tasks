package com.prvz.lesson4_4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class JsonFileStorageServiceTests {

    @Test
    public void getPath_should_return_correct_path() {
        JsonFileStorageService service = new JsonFileStorageService(Path.of("contacts.json"));
        Assertions.assertEquals(Path.of("contacts.json"), service.getPath());
    }

    @Test
    public void readFromFile_should_return_expected_bindings() throws IOException {
        Path filePath = null;
        try {
            filePath = Files.createTempFile("contacts", ".json");
            Binding binding1 = new Binding("abcde", new URL("https://ya.ru"));
            Binding binding2 = new Binding("edcba", new URL("https://google.ru"));

            Collection<Binding> expected = List.of(binding1, binding2);

            ObjectMapper mapper = new ObjectMapper();
            String expectedJsonString = mapper.writeValueAsString(expected);

            Files.writeString(filePath, expectedJsonString);

            JsonFileStorageService service = new JsonFileStorageService(filePath);

            Assertions.assertIterableEquals(expected, service.readFromFile());
        } finally {
            Files.deleteIfExists(filePath);
        }

    }

    @Test
    public void writeToFile_should_write_bindings_to_file() {

    }

}
