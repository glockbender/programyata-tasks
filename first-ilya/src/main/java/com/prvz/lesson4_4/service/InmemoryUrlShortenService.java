package com.prvz.lesson4_4.service;

import com.prvz.lesson4_4.model.IdToUrlBinding;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InmemoryUrlShortenService implements UrlShortenService {

    public static final String PATH_TO_STORAGE = "storage.json";

    private final StorageService fs = new JsonFileStorageService(Path.of(PATH_TO_STORAGE));
    private final Map<String, IdToUrlBinding> idToUrlStorage = new HashMap<>();
    private final Map<URL, IdToUrlBinding> urlToIdStorage = new HashMap<>();

    {
        try {
            Set<IdToUrlBinding> bindings = fs.readFileAsBindingsSet();
            for (IdToUrlBinding binding : bindings) {
                idToUrlStorage.put(binding.getId(), binding);
                urlToIdStorage.put(binding.getLongUrl(), binding);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unexpected error", e);
        }
    }

    @Override
    public @NotNull String createNewBinding(@NotNull URL longUrl) {

        // Проверка на наличие длинного URL
        IdToUrlBinding binding = urlToIdStorage.get(longUrl);

        if (binding != null) {
            return binding.getId();
        }

        // Длинный URL не найден, создаем новую связку
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(6);
        } while (idToUrlStorage.containsKey(id));

        binding = new IdToUrlBinding(id, longUrl, LocalDateTime.now());
        idToUrlStorage.put(id, binding);
        urlToIdStorage.put(longUrl, binding);

        try {
            fs.saveBindingsToFile(idToUrlStorage.values());
        } catch (IOException e) {
            throw new RuntimeException("Cannot save bindings");
        }

        return id;

    }

    @Override
    public @Nullable URL getLongUrlByShort(@NotNull String id) {
        IdToUrlBinding binding = idToUrlStorage.get(id);
        if (binding == null) {
            return null;
        } else {
            return binding.getLongUrl();
        }
    }
}
