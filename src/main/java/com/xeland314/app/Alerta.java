package com.xeland314.app;

import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class Alerta {

    private String mensaje;
    private String titulo;

    public Alerta(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public void lanzar() {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(
            null,
            this.mensaje, this.titulo,
            JOptionPane.WARNING_MESSAGE
        );
    }

}
