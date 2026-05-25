package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen screen) {
        super(store, screen);
        setTitle("Add DVD");
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfTitle    = new JTextField(); tfCategory = new JTextField();
        tfDirector = new JTextField(); tfLength   = new JTextField();
        tfCost     = new JTextField();

        panel.add(new JLabel("Title:"));    panel.add(tfTitle);
        panel.add(new JLabel("Category:")); panel.add(tfCategory);
        panel.add(new JLabel("Director:")); panel.add(tfDirector);
        panel.add(new JLabel("Length:"));   panel.add(tfLength);
        panel.add(new JLabel("Cost:"));     panel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                tfTitle.getText(), tfCategory.getText(),
                tfDirector.getText(),
                Integer.parseInt(tfLength.getText()),
                Float.parseFloat(tfCost.getText())
            );
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            dispose();
            new StoreManagerScreen(store);
        });
        panel.add(new JLabel()); panel.add(btnAdd);
        return panel;
    }
}
