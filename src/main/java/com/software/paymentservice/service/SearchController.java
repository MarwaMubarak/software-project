package com.software.paymentservice.service;

import com.software.paymentservice.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class SearchController {
    private Search search;

    public SearchController(Search search) {
        this.search = search;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Response search(@PathParam("id") String id) {
        return this.search.search(id);
    }
}
