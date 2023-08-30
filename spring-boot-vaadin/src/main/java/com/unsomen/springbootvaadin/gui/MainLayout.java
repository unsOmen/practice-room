package com.unsomen.springbootvaadin.gui;

import com.unsomen.springbootvaadin.gui.view.CustomView;
import com.unsomen.springbootvaadin.gui.view.UserView;
import com.unsomen.springbootvaadin.service.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;

        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Practice room");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Log out", e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink customViewRoute = new RouterLink("Custom view", CustomView.class);
        customViewRoute.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink userViewRoute = new RouterLink("Users view", UserView.class);
        customViewRoute.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                customViewRoute,
                userViewRoute
        ));
    }
}
