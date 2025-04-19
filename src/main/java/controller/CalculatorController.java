package controller;

import model.Operatii;
import model.Polinom;
import view.CalculatorView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view){
        this.view=view;
    }

    public void aduna(){
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
            p2 = new Polinom(view.getTextPolinom2());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect " , "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Polinom rezultat=new Polinom();
        if (p2.getMonoame().isEmpty() || p1.getMonoame().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu au fost adaugate polinoamele", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        rezultat= Operatii.adunaPolinoame(p1,p2);
        view.getTextRezultat().setText(String.valueOf(rezultat));
        view.getTextRest().setText("");

    }


    public void scade() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
            p2 = new Polinom(view.getTextPolinom2());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect ", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Polinom rezultat = new Polinom();
        if (p2.getMonoame().isEmpty() || p1.getMonoame().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu au fost adaugate polinoamele", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        rezultat = Operatii.scadePolinoame(p1, p2);
        view.getTextRezultat().setText(String.valueOf(rezultat));
        view.getTextRest().setText("");

    }


    public void inmulteste(){
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
            p2 = new Polinom(view.getTextPolinom2());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect " , "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Polinom rezultat=new Polinom();
        if (p2.getMonoame().isEmpty() || p1.getMonoame().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu au fost adaugate polinoamele", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        rezultat= Operatii.inmultestePolinoame(p1,p2);
        view.getTextRezultat().setText(String.valueOf(rezultat));
        view.getTextRest().setText("");

    }

    public void imparte(){
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
            p2 = new Polinom(view.getTextPolinom2());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect " , "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Polinom> rezultat=new ArrayList<>();
        if (p2.getMonoame().isEmpty() || p2.getMonoame().firstEntry().getValue() == 0) {
            JOptionPane.showMessageDialog(null, "Polinomul împărțitor nu poate fi zero.", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        rezultat= Operatii.impartePolinoame(p1,p2);
        view.getTextRezultat().setText(String.valueOf(rezultat.get(0)));
        view.getTextRest().setText(String.valueOf(rezultat.get(1)));
    }

    public void deriveaza(){
        Polinom p1=new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect " , "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Polinom rezultat=new Polinom();
        rezultat= Operatii.deriveazaPolinom(p1);
        if (p1.getMonoame().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu a fost adaugat polinomul", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        view.getTextRezultat().setText(String.valueOf(rezultat));
        view.getTextRest().setText("");

    }

    public void integreaza(){
        Polinom p1=new Polinom();
        try {
            p1 = new Polinom(view.getTextPolinom1());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Polinom introdus incorect " , "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Polinom rezultat=new Polinom();
        if (p1.getMonoame().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu a fost adaugat polinomul", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        rezultat= Operatii.integreazaPolinom(p1);
        view.getTextRezultat().setText(String.valueOf(rezultat));
        view.getTextRest().setText("");

    }


}
