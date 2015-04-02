package com.example.marta.lolcomponent;

/**
 * Created by Marta on 02/04/2015.
 */
public class Transaction {

    private String value1;
    private String value2;
    private String value3;
    private String value4;


    public void setValue1(final String value1) {
        this.value1 = value1;
    }

    public void setValue2(final String value2) {
        this.value2 = value2;
    }

    public void setValue3(final String value3) {
        this.value3 = value3;
    }

    public void setValue4(final String value4) {
        this.value4 = value4;
    }

    @Override
    public String toString() {
        return "Transaction{" + "\n" +
                "value1='" + value1 + '\'' + "\n" +
                ", value2='" + value2 + '\'' + "\n" +
                ", value3='" + value3 + '\'' + "\n" +
                ", value4='" + value4 + '\'' + "\n" +
                '}';
    }
}
