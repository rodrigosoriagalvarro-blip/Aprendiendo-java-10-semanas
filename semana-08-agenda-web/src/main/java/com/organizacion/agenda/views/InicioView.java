package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {

    public InicioView() {
        setPadding(true);
        setSpacing(true);

        H2 bienvenida = new H2("Bienvenido a tu Agenda");
        Paragraph texto = new Paragraph("Gestiona tus contactos de manera eficiente y rapida desde esta interfaz web.");
        H3 instrucciones = new H3("Selecciona una opcion en el menu superior para comenzar.");

        add(bienvenida, texto, instrucciones);
    }
}