package com.middle.demo.search;


import com.google.maps.GeoApiContext;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.PlacesSearchResponse;
import lombok.SneakyThrows;

public class GooglePlaces {
    @SneakyThrows
    static public String searchaddress(String domain){
        String API_KEY = "AIzaSyBQZksp4BmTesvoWSH6LWdo1sN8zCmt5aU";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        PlacesSearchResponse placesRespose = new TextSearchRequest(context).query(domain).await();
        String address = placesRespose.results[0].formattedAddress;
        context.shutdown();
        return address;
    }

    public static void main(String[] args) {
        String address = GooglePlaces.searchaddress("ucu.edu.ua");
        System.out.println(address);
    }
}

