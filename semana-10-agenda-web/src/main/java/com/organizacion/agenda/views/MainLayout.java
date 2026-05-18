package com.organizacion.agenda.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        H1 logo = new H1("Agenda FINALLLLLL");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        addToNavbar(header);
        
        VerticalLayout menu = new VerticalLayout(
            new RouterLink("Inicio", InicioView.class),
            new RouterLink("Contactos", ContactosView.class),
            new RouterLink("Eventos", EventosView.class)
        );
        addToDrawer(menu);
    }
}