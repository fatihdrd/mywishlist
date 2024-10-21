package com.fd.wishlistservice.controller;

import com.fd.wishlistservice.services.OpenGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Map;

@RestController
public class OpenGraphController {

    @Autowired
    private OpenGraphService openGraphService;

    @GetMapping("/api/ogdata")
    public Map<String, String> fetchOgData(@RequestParam String url) throws IOException {
        return openGraphService.getOpenGraphData(url);
    }
}
