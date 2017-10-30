import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class MJS {
    private int n = 101;
    private double[] arrayU = new double[n];
    private double[] arrayV = new double[n];
    int [] intU = new int[n];
    int [] intV = new int[n];
    private double[] q = new double[n];
    private int i;
    private double fiFirst;
    private double fiSecond;
    private double fiThird;
    private double fiFourth;

    private double getFiFirst(double q){
        return (24*(Math.cos(3*q)) - 24*(Math.cos(2*q)));
    }
    private double getFiSecond(double q){
        return (24*(Math.sin(3*q)) - 24*(Math.sin(2*q)));
    }
    private double getFiThird(double q){
        return ((9*(Math.cos(3*q))) + (19*(Math.cos(2*q))) - (5*(Math.cos(q)))+ 1);
    }
    private double getFiFourth(double q){
        return ((9*(Math.sin(3*q)))+(19*(Math.sin(2*q)))-(5*(Math.sin(q))));
    }

    public double getRezultU(double q) {

        fiFirst=getFiFirst(q);
        fiSecond=getFiSecond(q);
        fiThird=getFiThird(q);
        fiFourth=getFiFourth(q);
        return (fiFirst*fiThird+fiSecond*fiFourth)/(pow(fiThird,2)+pow(fiFourth,2));
    }
    public double getRezultV(double q) {

        fiFirst=getFiFirst(q);
        fiSecond=getFiSecond(q);
        fiThird=getFiThird(q);
        fiFourth=getFiFourth(q);
        return (fiSecond*fiThird-fiFirst*fiFourth)/(pow(fiThird,2)+pow(fiFourth,2));
    }

    public List<int[]> process() {
        List<int[]> list = new ArrayList<>();
        for(i=0;i<=100;i++){
            q[i]=((Math.PI)*i)/50;
            this.arrayU[i]=getRezultU(q[i]);
            this.arrayV[i]=getRezultV(q[i]);
        }
        for(int i =0;i<arrayU.length;i++){
            arrayU[i]*=85;
            arrayV[i]*=85;
            intU[i]=(int)arrayU[i] + 689;
            intV[i]=(int)arrayV[i] + 390;
        }
        list.add(intU);
        list.add(intV);
        return list;
    }

    public static void main(String[] args) {
        MJS obj = new MJS();
        obj.process();
    }
}
