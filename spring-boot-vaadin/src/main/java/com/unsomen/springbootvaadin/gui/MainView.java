package com.unsomen.springbootvaadin.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(new Button("TEST BTN", e -> Notification.show("TEST BTN CLICK!")));
    }
}
