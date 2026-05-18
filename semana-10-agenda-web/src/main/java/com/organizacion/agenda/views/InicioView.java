package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {
    public InicioView() {
        add(new H2("Bienvenido a la Agenda de Contactos"));
    }
}