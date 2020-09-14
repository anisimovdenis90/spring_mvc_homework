package homework2.anisimov.denis.services;

import homework2.anisimov.denis.model.Item;
import homework2.anisimov.denis.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.getItems();
    }

    public Item getItemById(Long id) {
        return itemRepository.getItemById(id);
    }

    public void save(String title, int cost) {
        itemRepository.save(title, cost);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteItemById(id);
    }
}
