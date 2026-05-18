package com.organizacion.agenda.views;

import com.organizacion.agenda.modelo.Contacto;
import com.organizacion.agenda.service.ContactoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {
    private final ContactoService servicio;
    private Grid<Contacto> grid = new Grid<>(Contacto.class);
    private TextField nombre = new TextField("Nombre");
    private EmailField email = new EmailField("Email");
    private TextField telefono = new TextField("Teléfono");
    private Binder<Contacto> binder = new Binder<>(Contacto.class);
    private Contacto seleccionado;

    public ContactosView(ContactoService servicio) {
        this.servicio = servicio;
        binder.bindInstanceFields(this);
        
        FormLayout form = new FormLayout(nombre, email, telefono);
        form.setColspan(nombre, 2);

        grid.setColumns("nombre", "email", "telefono");
        grid.asSingleSelect().addValueChangeListener(e -> {
            seleccionado = e.getValue();
            binder.readBean(seleccionado);
        });

        Button btnGuardar = new Button("Guardar", e -> {
            Contacto c = seleccionado != null ? seleccionado : new Contacto();
            try {
                binder.writeBean(c);
                servicio.guardar(c);
                actualizar();
                limpiar();
            } catch (Exception ex) {
                Notification.show("Error en datos");
            }
        });

        Button btnEliminar = new Button("Eliminar", e -> {
            if (seleccionado == null) return;
            ConfirmDialog dialog = new ConfirmDialog("Confirmar", "¿Eliminar contacto?", "Sí", ev -> {
                servicio.eliminar(seleccionado);
                actualizar();
                limpiar();
            }, "No", ev -> {});
            dialog.open();
        });

        add(form, new HorizontalLayout(btnGuardar, btnEliminar), grid);
        actualizar();
    }

    private void actualizar() { grid.setItems(servicio.obtenerTodos()); }
    private void limpiar() { binder.readBean(new Contacto()); seleccionado = null; }
}