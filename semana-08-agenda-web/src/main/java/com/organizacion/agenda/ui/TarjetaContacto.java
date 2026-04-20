package com.organizacion.agenda.ui;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

public class TarjetaContacto extends Div {

    public TarjetaContacto(String nombre, String telefono, String email) {
        getStyle().set("border", "1px solid #ccc");
        getStyle().set("border-radius", "10px");
        getStyle().set("padding", "15px");
        getStyle().set("width", "300px");
        getStyle().set("margin", "10px");
        getStyle().set("box-shadow", "0 2px 4px rgba(0,0,0,0.1)");

        Avatar avatar = new Avatar(nombre);
        
        Span txtNombre = new Span(nombre);
        txtNombre.getStyle().set("font-weight", "bold");
        txtNombre.getStyle().set("font-size", "1.2em");

        Icon iconTel = new Icon(VaadinIcon.PHONE);
        iconTel.setSize("14px");
        Span txtTel = new Span(telefono);
        HorizontalLayout layoutTel = new HorizontalLayout(iconTel, txtTel);
        layoutTel.setAlignItems(FlexComponent.Alignment.CENTER);
        layoutTel.setSpacing(true);

        Icon iconEmail = new Icon(VaadinIcon.ENVELOPE);
        iconEmail.setSize("14px");
        Span txtEmail = new Span(email);
        HorizontalLayout layoutEmail = new HorizontalLayout(iconEmail, txtEmail);
        layoutEmail.setAlignItems(FlexComponent.Alignment.CENTER);
        layoutEmail.setSpacing(true);

        VerticalLayout info = new VerticalLayout(txtNombre, layoutTel, layoutEmail);
        info.setSpacing(false);
        info.setPadding(false);

        HorizontalLayout principal = new HorizontalLayout(avatar, info);
        principal.setAlignItems(FlexComponent.Alignment.CENTER);
        
        add(principal);
    }
}