package com.prvz.lesson4_4;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Collection;

public class JsonFileStorageService implements FileStorageService {

    private final Path path;

    public JsonFileStorageService(Path path) {
        this.path = path;
    }

    @Override
    public @NotNull Path getPath() {
        return path;
    }

    @Override
    public @NotNull Collection<Binding> readFromFile() {
        return null;
    }

    @Override
    public void writeToFile(@NotNull Collection<Binding> bindings) {

    }
}
