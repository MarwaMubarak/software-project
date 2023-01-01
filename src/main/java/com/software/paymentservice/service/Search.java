package com.software.paymentservice.service;

import com.software.paymentservice.Data.SavedData;
import com.software.paymentservice.response.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

@Component
public class Search {


    public Response search(String id) {
        ArrayList<String> searchResult = new ArrayList<String>();

        for (Map.Entry<String, Service> service : SavedData.getObj().getServices().entrySet()) {
            String s = service.getKey().toLowerCase(Locale.ROOT);
            id = id.toLowerCase(Locale.ROOT);
            if (s.contains(id)) {
                searchResult.add(service.getKey());

            }
        }
        if (searchResult.isEmpty())
            return new Response("Not Found..", "");
        return new Response("Done..", searchResult);
    }


}
