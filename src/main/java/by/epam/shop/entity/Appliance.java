package by.epam.shop.entity;

import java.util.List;

public class Appliance {// вкорне неверно построенная иерархия сущностей. Мы на код-ревью разбирали правила, и наследованиеее
    List<String> applianceList;

    @Override
    public String toString() {
        return "Appliance: " + applianceList + '.';
    }

    public Appliance(List<String> appliances){
        this.applianceList = appliances;
    }
}
