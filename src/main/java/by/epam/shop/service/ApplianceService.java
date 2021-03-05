package by.epam.shop.service;

import by.epam.shop.entity.Appliance;
import by.epam.shop.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceService {
    Appliance find(Criteria criteria) throws IOException;
}
