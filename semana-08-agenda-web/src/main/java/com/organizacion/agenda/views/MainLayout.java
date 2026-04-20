package com.organizacion.agenda.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 titulo = new H1("Agenda Web");
        titulo.getStyle().set("font-size", "var(--lumo-font-size-l)");
        titulo.getStyle().set("margin", "0 var(--lumo-space-m)");

        MenuBar menuBar = new MenuBar();
        menuBar.addItem(new RouterLink("Inicio", InicioView.class));
        menuBar.addItem(new RouterLink("Contactos", ContactosView.class));

        addToNavbar(titulo, menuBar);
    }
}