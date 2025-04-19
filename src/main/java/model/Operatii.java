package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Operatii {
    public static Polinom adunaPolinoame(Polinom p1, Polinom p2){
        Polinom rezultat=new Polinom();

        for(Map.Entry<Integer, Double>entry:p1.getMonoame().entrySet()){
            int grad=entry.getKey();
            double coeficient;
            if(p2.getMonoame().containsKey(grad)) {
                coeficient = entry.getValue() + p2.getMonoame().get(grad);
            }else{
                coeficient=entry.getValue();
            }
            rezultat.adaugaMonom(grad, coeficient);
        }
        for(Map.Entry<Integer, Double>entry: p2.getMonoame().entrySet()){
            int grad=entry.getKey();
            if(rezultat.getMonoame().containsKey(grad)==false){
                double coeficient=entry.getValue();
                rezultat.adaugaMonom(grad, coeficient);
            }
        }
        return rezultat;
    }

    public static Polinom scadePolinoame(Polinom p1, Polinom p2){
        Polinom rezultat=new Polinom();
        for(Map.Entry<Integer, Double>entry:p1.getMonoame().entrySet()){
            int grad=entry.getKey();
            double coeficient;
            if(p2.getMonoame().containsKey(grad)) {
                coeficient = entry.getValue() - p2.getMonoame().get(grad);
            }else{
                coeficient=entry.getValue();
            }
            rezultat.adaugaMonom(grad, coeficient);
        }
        for(Map.Entry<Integer, Double>entry: p2.getMonoame().entrySet()){
            int grad=entry.getKey();
            if(rezultat.getMonoame().containsKey(grad)==false){
                double coeficient=-entry.getValue();
                rezultat.adaugaMonom(grad, coeficient);
            }
        }
        return rezultat;
    }

    public static Polinom integreazaPolinom(Polinom p1){
        Polinom rezultat=new Polinom();

        for(Map.Entry<Integer, Double>entry:p1.getMonoame().entrySet()){

            int grad=entry.getKey()+1;
            double coeficient=entry.getValue()/grad;

            rezultat.adaugaMonom(grad, coeficient);
        }

        return rezultat;
    }

    public static Polinom deriveazaPolinom(Polinom p1){
        Polinom rezultat=new Polinom();

        for(Map.Entry<Integer, Double>entry:p1.getMonoame().entrySet()){
            double coeficient;
            int grad;
            if(entry.getKey()!=0){
                grad = entry.getKey() - 1;
                coeficient = entry.getValue() * entry.getKey();}
            else {
                coeficient=0;
                grad=0;

            }
            rezultat.adaugaMonom(grad, coeficient);
        }

        return rezultat;
    }

    public static List<Polinom> impartePolinoame(Polinom p1, Polinom p2) {
        List<Polinom> rezultat = new ArrayList<>();
        TreeMap<Integer, Double> restMonoame = new TreeMap<>(p1.getMonoame().descendingMap());
        Polinom rest = new Polinom(restMonoame);
        TreeMap<Integer, Double> divizorMonoame = new TreeMap<>(p2.getMonoame().descendingMap());
        Polinom divizor = new Polinom(divizorMonoame);
        Polinom cat = new Polinom();
        if (rest.getMonoame().isEmpty() || rest.getMonoame().firstKey() < divizor.getMonoame().firstKey()) {
            rezultat.add(new Polinom());
            rezultat.add(p1);
            return rezultat;
        }
        else {
            while (!rest.getMonoame().isEmpty() && rest.getMonoame().firstKey() >= divizor.getMonoame().firstKey()) {
                int grad = rest.getMonoame().firstKey() - divizor.getMonoame().firstKey();
                double coeficient = rest.getMonoame().firstEntry().getValue() / divizor.getMonoame().firstEntry().getValue();
                cat.adaugaMonom(grad, coeficient);
                Polinom termen = new Polinom();
                termen.adaugaMonom(grad, coeficient);
                termen = inmultestePolinoame(termen, divizor);
                rest = scadePolinoame(rest, termen);
                rest.eliminaMonoameZero();
                rest= rest.sorteazaDescrescator();
            }
            rezultat.add(cat);
            rezultat.add(rest);
        }
        return rezultat;
    }


    public static Polinom inmultestePolinoame(Polinom p1, Polinom p2){
        Polinom rezultat=new Polinom();

        for(Map.Entry<Integer, Double>entry1:p1.getMonoame().entrySet()){
            int grad1=entry1.getKey();
            double coeficient1=entry1.getValue();
            for(Map.Entry<Integer, Double>entry2: p2.getMonoame().entrySet()){
                int grad2=entry2.getKey();
                double coeficient2=entry2.getValue();
                int gradProdus=grad1+grad2;
                double coeficientProdus=coeficient1*coeficient2;
                if(rezultat.getMonoame().containsKey(gradProdus)){
                    coeficientProdus +=rezultat.getMonoame().get(gradProdus);
                }
                rezultat.adaugaMonom(gradProdus, coeficientProdus);
            }

        }
        return rezultat;
    }



}
