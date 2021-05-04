####Задачи

- [ ] работаем с map (планируем сокращатель ссылок)
- [ ] пробуем начать проектирование с тестов (TDD)

####homework

- phoneBookContact - все поля private final. Создать геттеры. Геттер для phones должен возвращать копию сета
- phoneBookContact - addPhones(Collection<String> phones) - метод добавления номеров в контакт
- inmemoryPhoneBookService - поменять хранилище на мапу <String, PhoneBookContact>
- inmemoryPhoneBookService - findByName -> findByFullName(String firstName, String lastName)
- inmemoryPhoneBookService - Collection<PhoneBookContact> findByPhone(@NotNull String phone)
- inmemoryPhoneBookService - findAll
- inmemoryPhoneBookService - addNewContact. Если новый контакт содержит существующие в мапе first & last name - нужно в существующий контакт добавить новые номера телефонов
- phoneBookContact.getPhones() - тест, возвращает копию внутреннего сета, а не его самого
- phoneBookContact.addPhones() - тест, корректно добавляет номера
- inmemoryPhoneBookService.findByFullName() - тесты
- inmemoryPhoneBookService.findByPhone() - тесты
- inmemoryPhoneBookService.findAll() - тесты
- inmemoryPhoneBookService.addNewContact() - тесты (то что не осуществилась перезапись на новый объект, а то что остался старый объект, но у него обновились номера)
  переопределенный equals сравнивает поля, а `==` сравнивает объекты
  
- UrlShortenService - тесты
  
- разгрести тех долг