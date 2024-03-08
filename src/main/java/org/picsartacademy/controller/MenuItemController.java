package org.picsartacademy.controller;

import org.picsartacademy.entity.MenuItem;
import org.picsartacademy.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/add")
    public ResponseEntity<String> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.addMenuItem(menuItem);
        return ResponseEntity.ok("Menu item added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        return ResponseEntity.ok(menuItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        if (menuItem != null) {
            return ResponseEntity.ok(menuItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem existingMenuItem = menuItemService.getMenuItemById(menuItem.getId());
        if (existingMenuItem != null) {
            menuItemService.updateMenuItem(menuItem);
            return ResponseEntity.ok("Menu item updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        MenuItem existingMenuItem = menuItemService.getMenuItemById(id);
        if (existingMenuItem != null) {
            menuItemService.deleteMenuItem(id);
            return ResponseEntity.ok("Menu item deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
