package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.execption.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<LibraryItem> availableItems = new ArrayList<>();
    private final HashMap<LibraryItem, User> userCheckOutItemList = new HashMap<>();

    public Library(List<Book> books, List<Movie> movies) {
        availableItems.addAll(books);
        availableItems.addAll(movies);
        items.addAll(books);
        items.addAll(movies);
    }

    public List<LibraryItem> getAvailableItems() {
        return availableItems;
    }

    public void checkoutItem(LibraryItem item, User user) throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
        if (item == null || !isBelongToLibrary(item)) {
            throw new ItemDoesNotBelongToLibrary();
        }
        if (isAvailable(item)) {
            availableItems.remove(item);
            userCheckOutItemList.put(item, user);
            return;
        }
        throw new ItemIsNotAvailable();
    }

    public void returnItem(LibraryItem item, User user) throws ItemDoesNotBelongToLibrary, ItemIsNotCheckout {
        if (item == null || !isBelongToLibrary(item)) {
            throw new ItemDoesNotBelongToLibrary();
        }
        if (!isAvailable(item) && (userCheckOutItemList.get(item) == user)) {
            availableItems.add(item);
            userCheckOutItemList.remove(item);
            return;
        }
        throw new ItemIsNotCheckout();
    }

    public HashMap<LibraryItem, User> getUserCheckOutItemList() {
        return userCheckOutItemList;
    }

    private boolean isBelongToLibrary(LibraryItem book) {
        return items.contains(book);
    }

    private boolean isAvailable(LibraryItem book) {
        return availableItems.contains(book);
    }
}
