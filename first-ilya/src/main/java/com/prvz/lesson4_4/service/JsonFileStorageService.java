package com.prvz.lesson4_4.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prvz.lesson4_4.model.IdToUrlBinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonFileStorageService implements StorageService {

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
    private final Path path;

    public JsonFileStorageService(Path path) {
        this.path = path;
        if (!Files.exists(this.path)) {
            try {
                Files.createFile(this.path);
                Files.writeString(this.path, "[]");
            } catch (IOException e) {
                throw new RuntimeException("Unexpected error", e);
            }
        }
        System.out.println(this.path.toAbsolutePath().toString());
    }

    @Override
    public Set<IdToUrlBinding> readFileAsBindingsSet() throws IOException {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
            List<IdToUrlBinding> bindings = objectMapper.readerForListOf(IdToUrlBinding.class).readValue(reader);
            return new HashSet<>(bindings);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Unexpected error. Cannot close reader for file: " + path);
                }
            }
        }
    }

    @Override
    public void saveBindingsToFile(Collection<IdToUrlBinding> bindings) throws IOException {

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            objectMapper.writeValue(writer, bindings);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Unexpected error. Cannot close writer for file: " + path);
                }
            }
        }

    }
}
