package com.example.ejecicio4sqlite;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mock;

public class PersonaTest {

    //Hacemos una instancia simulada la de la clase persona para poder darle los valores que deseemos para cersionarnos del correcto funcionamiento de los métodos
    @Mock
    Persona personaMock = mock(Persona.class);

    @Test
    public void testGetApellido() {
        // Configuración de la persona
        when(personaMock.getApellidos()).thenReturn("Pérez");

        // Verificación
        assertEquals("Pérez", personaMock.getApellidos());
    }

    @Test
    public void testGetNombre() {
        // Configuración de la persona
        when(personaMock.getNombre()).thenReturn("Juan");

        // Verificación
        assertEquals("Juan", personaMock.getNombre());
    }

    @Test
    public void testGetEdad() {
        // Configuración de la persona
        when(personaMock.getEdad()).thenReturn(25);

        // Verificación
        assertEquals(25, personaMock.getEdad());
    }
}
