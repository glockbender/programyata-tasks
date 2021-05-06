package com.prvz.lesson4_4;

import com.prvz.lesson4_4.service.InmemoryUrlShortenService;
import com.prvz.lesson4_4.service.UrlShortenService;

import java.net.MalformedURLException;
import java.net.URL;

public class TestApp {

    public static void main(String[] args) throws MalformedURLException {

        UrlShortenService shortenService = new InmemoryUrlShortenService();

        String id = shortenService.createNewBinding(new URL("https://ya.ru"));

        URL url = shortenService.getLongUrlByShort(id);

        System.out.println("ID: " + id);
        System.out.println("URL: " + url);

    }

}
