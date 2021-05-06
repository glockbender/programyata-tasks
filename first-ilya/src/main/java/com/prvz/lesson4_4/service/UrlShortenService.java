package com.prvz.lesson4_4.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

public interface UrlShortenService {

    /**
     * Возвращает идентификатор (короткую ссылку)
     * В метод приходят валидные данные.
     * Если связка с данной длинной ссылкой уже существует - возвращаем существующую короткую ссылку
     *
     * @param longUrl - длинная ссылка
     * @return коротка ссылка
     */
    @NotNull
    String createNewBinding(@NotNull URL longUrl);

    /**
     * Получить длинный URL по идентификатору
     *
     * @param id короткий URL
     * @return длинный URL
     */
    @Nullable
    URL getLongUrlByShort(@NotNull String id);

}
