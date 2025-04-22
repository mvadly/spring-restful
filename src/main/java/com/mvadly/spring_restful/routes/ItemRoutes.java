package com.mvadly.spring_restful.routes;

import com.mvadly.spring_restful.common.Response;
import com.mvadly.spring_restful.controller.ItemController;

import com.mvadly.spring_restful.entity.ItemEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemRoutes {

    private final ItemController controller;

    public ItemRoutes(ItemController controller) {
        this.controller = controller;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Response> getAllItems() {
        return controller.getAll();
    }

    @PostMapping
    public ResponseEntity<Response> createItem(@RequestBody ItemEntity item) {
        return controller.create(item);
    }

}