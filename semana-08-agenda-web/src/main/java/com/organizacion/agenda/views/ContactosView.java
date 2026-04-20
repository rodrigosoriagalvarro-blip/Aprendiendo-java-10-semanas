package com.organizacion.agenda.views;

import com.organizacion.agenda.ui.TarjetaContacto;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {

    public ContactosView() {
        setPadding(true);
        setSpacing(true);

        H2 titulo = new H2("Contactos");
        Paragraph desc = new Paragraph("Gestiona todos tus contactos en un solo lugar.");
        H3 sub = new H3("Mis Contactos ");

        Div contenedorTarjetas = new Div();
        contenedorTarjetas.getStyle().set("display", "flex");
        contenedorTarjetas.getStyle().set("flex-wrap", "wrap");
        contenedorTarjetas.getStyle().set("gap", "10px");

        contenedorTarjetas.add(new TarjetaContacto("Juan Perez", "71234567", "juan@correo.com"));
        contenedorTarjetas.add(new TarjetaContacto("Maria Lopez", "78888888", "maria@correo.com"));
        contenedorTarjetas.add(new TarjetaContacto("Carlos Ruiz", "60011223", "carlos@correo.com"));
        contenedorTarjetas.add(new TarjetaContacto("Ana Garcia", "75544332", "ana@correo.com"));

        add(titulo, desc, sub, contenedorTarjetas);
    }
}