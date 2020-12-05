package com.example.firebasecalc;

public class RecordModel {
    private double num1;
    private double num2;
    private String tandaHitung;
    private double result;

    public String getTandaHitung() {
        return tandaHitung;
    }

    public void setTandaHitung(String tandaHitung) {
        this.tandaHitung = tandaHitung;
    }

    private RecordModel(){

    }

    private RecordModel(double num1, double num2, String tandaHitung, double result){
        this.num1 = num1;
        this.num2 = num2;
        this.tandaHitung = tandaHitung;
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
