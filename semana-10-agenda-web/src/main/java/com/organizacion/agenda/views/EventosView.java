package com.organizacion.agenda.views;

import com.organizacion.agenda.modelo.Evento;
import com.organizacion.agenda.service.EventoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;

@Route(value = "eventos", layout = MainLayout.class)
public class EventosView extends VerticalLayout {
    private final EventoService servicio;
    private Grid<Evento> grid = new Grid<>(Evento.class);
    private TextField titulo = new TextField("Título");
    private DatePicker fecha = new DatePicker("Fecha");
    private TextField descripcion = new TextField("Descripción");
    private Binder<Evento> binder = new Binder<>(Evento.class);

    public EventosView(EventoService servicio) {
        this.servicio = servicio;
        
        binder.forField(titulo).bind(Evento::getTitulo, Evento::setTitulo);
        binder.forField(fecha).withConverter(LocalDate::toString, LocalDate::parse).bind(Evento::getFecha, Evento::setFecha);
        binder.forField(descripcion).bind(Evento::getDescripcion, Evento::setDescripcion);

        grid.setColumns("titulo", "fecha", "descripcion");

        Button btnGuardar = new Button("Guardar", e -> {
            Evento ev = new Evento();
            try {
                binder.writeBean(ev);
                servicio.guardar(ev);
                actualizar();
            } catch (Exception ex) {}
        });

        add(new FormLayout(titulo, fecha, descripcion), btnGuardar, grid);
        actualizar();
    }

    private void actualizar() { grid.setItems(servicio.obtenerTodos()); }
}