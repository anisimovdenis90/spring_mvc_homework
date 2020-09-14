package homework2.anisimov.denis.repositories;

import homework2.anisimov.denis.model.Item;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ItemRepository {
    private static Long itemId;
    private final List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
        itemId = 0L;
    }

    @PostConstruct
    public void init() {
        items.add(new Item(++itemId, "Beard", 30));
        items.add(new Item(++itemId, "Cheese", 55));
        items.add(new Item(++itemId, "Eggs", 130));
        items.add(new Item(++itemId, "Chocolate", 110));
        items.add(new Item(++itemId, "Milk", 80));
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
    
    public Item getItemById(Long id) throws ResourceNotFoundException {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        throw new ResourceNotFoundException("Отсутствует товар с id: " + id);
    }

    public void save(String title, int cost) {
        items.add(new Item(++itemId, title, cost));
    }

    public void deleteItemById(Long id) {
        if (items.removeIf(item -> item.getId().equals(id))) {
            return;
        }
        throw new ResourceNotFoundException("Отсутствует товар с id: " + id);
    }
}
