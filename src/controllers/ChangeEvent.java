package controllers;

import view.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEvent implements ActionListener {

    private Ventana ventana;

    public ChangeEvent(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventana.getBtnSearch()){
            System.out.println("Hola desde search y controller");
        } else if(e.getSource()==ventana.getBtnAdd()){
            System.out.println("Hola desde add y controller");
        } else if(e.getSource()==ventana.getBtnUpdate()){
            System.out.println("Hola desde update y controller");
        } else if(e.getSource()==ventana.getBtnDelete()){
            System.out.println("Hola desde delete y controller");
        }
    }
}
