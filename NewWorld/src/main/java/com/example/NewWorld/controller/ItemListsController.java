package com.example.NewWorld.controller;

import com.example.NewWorld.entity.Category;
import com.example.NewWorld.entity.Items;
import com.example.NewWorld.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/itemLists/api")

public class ItemListsController {
    private final ItemService itemService;
    public ItemListsController(ItemService itemService) {
        this.itemService= itemService;
    }
    @GetMapping("/public/items") //For viewing the homepage
    public List<Items> browseItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/public/items/{id}")
        public Items getItemById(@PathVariable int id){
            return itemService.getItemById(id);
        }
    @GetMapping("/public/items/category")
    public List<Items> getItemsbyCategory(@RequestParam Category category){
        return itemService.getItemsByCategory(category);
    }

    @PostMapping("/buyer/interacting") //For buyers
    public String itemBuy(@RequestParam int itemId, @RequestParam String buyerName){
        LocalDateTime interactingTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate=interactingTime.format(format);
        return "Order placed successfully for "+itemId+" by "+buyerName+" on "+formattedDate;
    }

    @PostMapping("/seller/interacting") //For sellers
    public String itemSell(@Valid @RequestBody Items item){
        LocalDateTime interactingTime=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate=interactingTime.format(format);
//        Items it=new Items(name,description,price,category,sellerName);
        //ItemService.addItems(it);
        itemService.addItems(item);
        return "Item successfully listed with item name"+item.getName()+" by "+item.getSellerName()+" on "+formattedDate;
    }
}
