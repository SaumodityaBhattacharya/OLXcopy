package com.example.NewWorld.service;

import com.example.NewWorld.Exception.InvalidPriceException;
import com.example.NewWorld.entity.Category;
import com.example.NewWorld.entity.Items;
import com.example.NewWorld.Exception.ItemNotFoundException;
import com.example.NewWorld.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }
//    private List<Items> itemsList=new ArrayList<>();
//    public ItemService(){
//        itemsList.add(new Items("iPhone","256GB", 40000, Category.ELECTRONICS,"default"));
//        itemsList.add(new Items("AC","1.5 Tonne",35000,Category.ELECTRONICS,"default"));
//    }
    public List<Items> getAllItems(){
        return itemRepository.findAll();
    }
    public void addItems(Items items){

        if(items.getPrice()<0){
            throw new InvalidPriceException("Item price cannot be negative");
        }
        itemRepository.save(items);
    }
    public Items getItemById(int id){
        return itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException("Item with ID "+id+" not found"));
    }
    public List<Items> getItemsByCategory(Category category){
        return Collections.singletonList((Items) itemRepository.findByCategory(category));
    }

}