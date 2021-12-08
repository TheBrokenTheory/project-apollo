package com.projectapollo.controllers;

import com.projectapollo.models.Item;
import com.projectapollo.repositories.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> list() {return itemRepository.findAll();}

    @GetMapping
    @RequestMapping("{id}")
    public Item get(@PathVariable Integer id) {
        return itemRepository.getById(id);
    }

    @PostMapping
    public Item create(@RequestBody final Item item) {
        return itemRepository.saveAndFlush(item);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        itemRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Item update(@PathVariable Integer id, @RequestBody Item item){
        Item existingItem = itemRepository.getById(id);
        BeanUtils.copyProperties(item, existingItem, "id");
        return itemRepository.saveAndFlush(existingItem);
    }




}
