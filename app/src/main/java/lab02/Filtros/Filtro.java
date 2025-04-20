package lab02.Filtros;

import java.util.List;

import lab02.Eventos.Evento;

public interface Filtro {
     public List<Evento> filtrar(List<Evento> eventos);
}
