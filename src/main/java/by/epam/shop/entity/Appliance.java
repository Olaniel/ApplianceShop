package by.epam.shop.entity;

import java.util.List;

public class Appliance {
    List<String> applianceList;

    @Override
    public String toString() {
        return "Appliance: " + applianceList + '.';
    }

    public Appliance(List<String> appliances){
        this.applianceList = appliances;
    }
}
