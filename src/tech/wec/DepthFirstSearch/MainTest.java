package tech.wec.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {

    public static class Intval{
        private int intval;
        private int nouse;

        @Override
        public boolean equals(Object obj) {
            return this.intval == ((Intval)obj).intval;
        }

        public Intval(){
        }

        public Intval(int intval){

        }

        public static void print(){
            System.out.println("hello");
        }

        public int getIntval() {
            return intval;
        }

        public void setIntval(int intval) {
            this.intval = intval;
        }

        public int getNouse() {
            return nouse;
        }

        public void setNouse(int nouse) {
            this.nouse = nouse;
        }
    }

    public static void main(String[] args) {
        Intval.print();
        Intval intval = new Intval();
    }
}

