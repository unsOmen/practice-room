package com.unsomen.springbootvaadin.gui.view;

import com.unsomen.springbootvaadin.gui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Custom view | Practice room")
public class CustomView extends VerticalLayout {

    public CustomView() {
        add(new Button("TEST BTN", e -> Notification.show("TEST BTN CLICK!")));
    }
}
