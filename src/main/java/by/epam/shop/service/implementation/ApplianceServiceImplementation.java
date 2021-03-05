package by.epam.shop.service.implementation;

import by.epam.shop.dao.ApplianceDAO;
import by.epam.shop.dao.DAOFactory;
import by.epam.shop.dao.implementation.ApplianceDAOImplementation;
import by.epam.shop.entity.Appliance;
import by.epam.shop.entity.criteria.Criteria;
import by.epam.shop.service.ApplianceService;
import by.epam.shop.service.validation.Validator;

import java.io.IOException;

public class ApplianceServiceImplementation implements ApplianceService {
    @Override
    public Appliance find(Criteria criteria) throws IOException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        ApplianceDAOImplementation.fileReader();
        ApplianceDAOImplementation.getKeysFromMap(criteria);
        ApplianceDAOImplementation.getValuesFromMap(criteria);
        Appliance appliance = applianceDAO.find(criteria);
        return appliance;
    }
}
