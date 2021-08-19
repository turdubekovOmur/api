package kg.cbk.api.controller;

import kg.cbk.api.entity.Request;
import kg.cbk.api.service.impl.RequestServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class RequestController {

    private final RequestServiceImpl service;
    private final Logger logger = LoggerFactory.getLogger(RequestController.class);


    @PostMapping(path = "/save", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public Object pay(@RequestBody Request request) {
        logger.info("Вызван метод: Pay");
        return service.add(request);
    }

    @GetMapping(path = "/get", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public Object check(@Valid @RequestBody Request request) {
        logger.info("Вызван метод: Check");
        return service.check(request);
    }
}
