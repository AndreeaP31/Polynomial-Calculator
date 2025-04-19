package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private TreeMap<Integer, Double> monoame;

    public void setMonoame(TreeMap<Integer, Double> monoame) {
        this.monoame = monoame;
    }
    public void adaugaMonom(Integer grad, double coeficient){
        if(monoame==null){
         monoame=new TreeMap<>();
        }
        monoame.put(grad, coeficient);
    }
    public TreeMap<Integer, Double> getMonoame() {
        return monoame;
    }
    public Polinom(TreeMap<Integer, Double> monoame) {
        this.monoame = monoame;
    }

    public Polinom sorteazaDescrescator() {
        Comparator<Integer> descendingComparator = Comparator.reverseOrder();
        TreeMap<Integer, Double> sortedTerms = new TreeMap<>(descendingComparator);
        sortedTerms.putAll(monoame);
        return new Polinom(sortedTerms);
    }

    public void eliminaMonoameZero() {
        Iterator<Map.Entry<Integer, Double>> iterator = monoame.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Double> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
            }
        }
    }


    public Polinom() {
        this.monoame=new TreeMap<>();
    }
    public String toString(){
        String rezultat="";
        for(Map.Entry<Integer, Double>entry:monoame.entrySet()){
            int grad=entry.getKey();
            double coeficient=entry.getValue();
            if(coeficient>0 && !rezultat.isEmpty()) {
                rezultat += "+";
            }
            if((coeficient!=0 && coeficient!=1) || (coeficient==1 && grad==0) ){
                if((int)coeficient==coeficient){
                    rezultat+=(int)coeficient;
                }
                else rezultat+= String.format("%.2f", coeficient);
            }
            if(grad>0 && coeficient!=0){
                rezultat+="x";
                if(grad!=1){
                    rezultat+="^"+grad;
                }
            }
        }
        if(rezultat.isEmpty()){
            rezultat="0";
        }
        return rezultat;
    }
    public List<String> extrageGradCoeficient(String monom){
        List<String> rezultat= new ArrayList<>();
        int indexOfX=monom.indexOf("x");
        String coeficientString = null;
        String gradString = null;
        if(indexOfX!=-1){
            if (indexOfX != monom.length() - 1){
                gradString=monom.substring(indexOfX+2);
            } else gradString=("1");
            if(indexOfX==0 || (indexOfX==1 && monom.charAt(0)=='+')){
                coeficientString="1";
            }else if(indexOfX==1 && monom.charAt(0)=='-'){
                coeficientString="-1";
            }else coeficientString=monom.substring(0,indexOfX);
        }
        else{
            gradString="0";
            coeficientString=monom;
        }
        rezultat.add(gradString);
        rezultat.add(coeficientString);
        return rezultat;
    }

    public Polinom(String exp){
        this.monoame=new TreeMap<>();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        while (matcher.find()) {
            String monom=matcher.group(1);
            List<String> monomRezultat=new ArrayList<>();
            monomRezultat=extrageGradCoeficient(monom);
            String gradString= monomRezultat.get(0);
            String coeficientString= monomRezultat.get(1);
            try{
                Double coeficient= Double.parseDouble(coeficientString);
                int grad= Integer.parseInt(gradString);
                this.adaugaMonom(grad,coeficient);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("Polinomul introdus este incorect");
            }
        }
    }
}
