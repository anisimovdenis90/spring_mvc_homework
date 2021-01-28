package homework2.anisimov.denis.controllers;

import homework2.anisimov.denis.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String showAllItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "all_items";
    }

    @PostMapping("/add")
    public String addNewItem(@RequestParam String title, @RequestParam int cost) {
        itemService.save(title, cost);
        return "redirect:/items";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

}
