package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfArtist, tfDirector, tfCost;
    private JTextField tfTrackTitle, tfTrackLength;
    private DefaultListModel<String> trackListModel;
    private CompactDisc cd;

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen screen) {
        super(store, screen);
        setTitle("Add CD");
        setSize(450, 400);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel fields = new JPanel(new GridLayout(6, 2, 5, 5));
        tfTitle    = new JTextField(); tfCategory = new JTextField();
        tfArtist   = new JTextField(); tfDirector = new JTextField();
        tfCost     = new JTextField();

        fields.add(new JLabel("Title:"));    fields.add(tfTitle);
        fields.add(new JLabel("Category:")); fields.add(tfCategory);
        fields.add(new JLabel("Artist:"));   fields.add(tfArtist);
        fields.add(new JLabel("Director:")); fields.add(tfDirector);
        fields.add(new JLabel("Cost:"));     fields.add(tfCost);

        JPanel trackPanel = new JPanel(new FlowLayout());
        tfTrackTitle  = new JTextField(8);
        tfTrackLength = new JTextField(4);
        trackListModel = new DefaultListModel<>();
        JList<String> trackList = new JList<>(trackListModel);

        JButton btnAddTrack = new JButton("Add Track");
        btnAddTrack.addActionListener(e -> {
            if (cd == null) {
                cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(),
                    tfDirector.getText(), tfArtist.getText(),
                    Float.parseFloat(tfCost.getText()));
            }
            Track t = new Track(tfTrackTitle.getText(), Integer.parseInt(tfTrackLength.getText()));
            cd.addTrack(t);
            trackListModel.addElement(tfTrackTitle.getText() + " (" + tfTrackLength.getText() + " min)");
        });

        trackPanel.add(new JLabel("Track title:")); trackPanel.add(tfTrackTitle);
        trackPanel.add(new JLabel("Length:"));      trackPanel.add(tfTrackLength);
        trackPanel.add(btnAddTrack);

        JButton btnAdd = new JButton("Add CD to Store");
        btnAdd.addActionListener(e -> {
            if (cd == null) {
                cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(),
                    tfDirector.getText(), tfArtist.getText(),
                    Float.parseFloat(tfCost.getText()));
            }
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            dispose();
            new StoreManagerScreen(store);
        });

        panel.add(fields, BorderLayout.NORTH);
        panel.add(new JScrollPane(trackList), BorderLayout.CENTER);
        panel.add(trackPanel, BorderLayout.SOUTH);

        JPanel bottom = new JPanel();
        bottom.add(btnAdd);
        panel.add(bottom, BorderLayout.EAST);

        return panel;
    }
}
