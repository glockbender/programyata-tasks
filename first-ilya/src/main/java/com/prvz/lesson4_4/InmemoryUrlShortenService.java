package com.prvz.lesson4_4;

import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class InmemoryUrlShortenService implements UrlShortenService {

    private final Map<String, URL> idToUrlStorage = new HashMap<>();
    private final Map<URL, String> urlToIdStorage = new HashMap<>();


    @Override
    public @NotNull String createNewBinding(@NotNull URL longUrl) {

        // Проверка на наличие длинного URL
        String id = urlToIdStorage.get(longUrl);

        if (id != null) {
            return id;
        }

        // Длинный URL не найден, создаем новую связку
        do {
            id = RandomStringUtils.randomAlphanumeric(6);
        } while (!idToUrlStorage.containsKey(id));

        idToUrlStorage.put(id, longUrl);
        urlToIdStorage.put(longUrl, id);

        return id;

    }

    @Override
    public @Nullable URL getLongUrlByShort(@NotNull String id) {
        return idToUrlStorage.get(id);
    }
}
