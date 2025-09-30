package ch09.practice.problem01;

public class Computer {
    String brand;
    String model;

    public static class CPU{
       int cores;
       double speed;

       CPU(int cores, double speed){
           this.cores = cores;
           this.speed = speed;
       }

       String getSpecification(){
            String result = this.cores + "코어, " + this.speed +"Hz";
            return result;
       }

    }



    Computer(String brand, String model){
        this.brand = brand;
        this.model = model;

    }

    String getBrand(){
        return this.brand;
    }

    String getModel(){
        return  this.model;
    }
}
