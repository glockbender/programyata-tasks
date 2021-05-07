package com.prvz.lesson4_4;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Collection;

public interface FileStorageService {

    @NotNull Path getPath();

    @NotNull Collection<Binding> readFromFile();

    void writeToFile(@NotNull Collection<Binding> bindings);

}
