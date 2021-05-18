package ua.com.finaly;

import java.io.Serializable;

public class Anketa implements Serializable{
    private int[][] field;
    private String name;
    private int count4;
    private int count3;
    private int count2;
    private int count1;
    private int hitpoint;

    public Anketa(){
        this.field=new int[10][10];
        this.count1=4;
        this.count2=3;
        this.count3=2;
        this.count4=1;
        this.hitpoint=20;
    }

    public Anketa(String name){
        this.field=new int[10][10];
        this.count1=4;
        this.count2=3;
        this.count3=2;
        this.count4=1;
        this.hitpoint=20;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount4() {
        return count4;
    }

    public void setCount4(int count4) {
        this.count4 = count4;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }
}
