package com.organizacion.agenda.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        H1 logo = new H1("Agenda Web");
        logo.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        addToNavbar(header);

        RouterLink inicio = new RouterLink("Inicio", InicioView.class);
        RouterLink contactos = new RouterLink("Contactos", ContactosView.class);

        addToDrawer(new VerticalLayout(inicio, contactos));
    }
}