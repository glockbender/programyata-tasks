package com.prvz.lesson4_4.service;

import com.prvz.lesson4_4.model.IdToUrlBinding;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public interface StorageService {

    Set<IdToUrlBinding> readFileAsBindingsSet() throws IOException;

    void saveBindingsToFile(Collection<IdToUrlBinding> bindings) throws IOException;

}
