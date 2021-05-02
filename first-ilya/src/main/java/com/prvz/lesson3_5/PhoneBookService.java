package com.prvz.lesson3_5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface PhoneBookService {

    /**
     * Найти контакт по имени
     * @param name имя контакта
     * @return найденный контакт или null, если не найден
     */
    @Nullable PhoneBookContact findByFullName(@NotNull String firstName, @Nullable String lastName);

    /**
     * Найти контакты по телефону
     * @param phone телефон для поиска
     * @return найденные контакты или пустой список, если не найдены
     */
    @NotNull Collection<PhoneBookContact> findByPhone(@NotNull String phone);

    Collection<PhoneBookContact> findAll();

    void addNewContact(PhoneBookContact contact);

    /**
     * Ищет контакт по имени. Если такой контакт найден, заменяет на контакт из аргумента метода.
     * Если не найден кидает ошибку
     * @param contact контакт для изменения
     * @throws ContactNotFoundException, если не нашелся контакт с тем же именем
     */
    void updateContact(PhoneBookContact contact);

}
