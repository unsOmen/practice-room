package com.unsomen.springbootvaadin.gui.view;

import com.unsomen.springbootvaadin.gui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@PermitAll
@Route(value = "users", layout = MainLayout.class)
@PageTitle("Users | Practice room")
public class UserView extends VerticalLayout {

    private final Map<String, String> data = new HashMap<>();

    public UserView() {
        for (int i = 0; i < 10; i++) {
            data.put("name_" + i, "value_" + i);
        }
        createGrid();
    }

    private void createGrid() {
        Grid<Map.Entry> grid = new Grid<>(Map.Entry.class, false);
        grid.addColumn(Map.Entry::getKey).setHeader("Name");
        grid.addColumn(Map.Entry::getValue).setHeader("Phone");

        grid.setItems(data.entrySet().stream().collect(Collectors.toList()));

        grid.addItemClickListener(clickEvent -> {
            Notification.show("User: " + clickEvent.getItem().getKey());
        });

        add(grid);
    }
}
