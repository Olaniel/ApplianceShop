package by.epam.shop.main;

import by.epam.shop.entity.Appliance;

public class PrintApplianceInfo {
    public static void printName(String string){
        System.out.println("This are " + string + "'s:");
    }
    public static void print(Appliance appliance) {
        System.out.println(appliance);
    }
}
