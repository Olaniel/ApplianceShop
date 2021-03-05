package by.epam.shop.dao;

import by.epam.shop.entity.Appliance;
import by.epam.shop.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceDAO {
    Appliance find(Criteria criteria) throws IOException;
}
