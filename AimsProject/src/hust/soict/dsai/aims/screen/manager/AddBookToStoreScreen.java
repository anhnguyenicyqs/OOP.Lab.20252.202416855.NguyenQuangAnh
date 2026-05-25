package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost, tfAuthors;

    public AddBookToStoreScreen(Store store, StoreManagerScreen screen) {
        super(store, screen);
        setTitle("Add Book");
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfTitle    = new JTextField(); tfCategory = new JTextField();
        tfCost     = new JTextField(); tfAuthors  = new JTextField();

        panel.add(new JLabel("Title:"));    panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Cost:"));     panel.add(tfCost);
        panel.add(new JLabel("Authors (comma separated):")); panel.add(tfAuthors);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            Book book = new Book(tfTitle.getText(), tfCategory.getText(),
                Float.parseFloat(tfCost.getText()));
            for (String author : tfAuthors.getText().split(",")) {
                book.addAuthor(author.trim());
            }
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            dispose();
            new StoreManagerScreen(store);
        });
        panel.add(new JLabel()); panel.add(btnAdd);
        return panel;
    }
}
