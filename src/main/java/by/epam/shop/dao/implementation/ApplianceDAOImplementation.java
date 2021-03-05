package by.epam.shop.dao.implementation;

import by.epam.shop.dao.ApplianceDAO;
import by.epam.shop.entity.Appliance;
import by.epam.shop.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImplementation implements ApplianceDAO {
    private static final List<String> textFromFile = new ArrayList<>();
    private static Object[] keysArray;
    private static Object[] valuesArray;
    public static void fileReader() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/appliances_db.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String stringLine;
        while ((stringLine = bufferedReader.readLine()) != null){
            textFromFile.add(stringLine);
        }
    }
    //todo parse by param
    public static List<String> fileParser(String stringLine) {
        List<String> parsedList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+=\\d+");
        Matcher matcher = pattern.matcher(stringLine);
        while (matcher.find()) {
            parsedList.add(matcher.group());
        }
        return parsedList;
    }
    public static void getKeysFromMap(Criteria criteria){
        Set<String> keys = criteria.getCriteria().keySet();
        keysArray = keys.toArray();
    }
    public static void getValuesFromMap(Criteria criteria){
        Collection<Object> values = criteria.getCriteria().values();
        valuesArray = values.toArray();
    }
    @Override
    public Appliance find(Criteria criteria) {
        List<String> parsedList = new ArrayList<>();
        for (String s : textFromFile) {
            int counter = 0;
            for (int mapCriteria = 0; mapCriteria < keysArray.length; mapCriteria++) {
                Pattern pattern = Pattern.compile(criteria.getGroupSearchName() + ".*"
                        + keysArray[mapCriteria] + "=" + valuesArray[mapCriteria] + "[,;]");
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    counter++;
                    if (counter == keysArray.length) {
                        parsedList.add(s);
                    }
                }
            }
        }
        textFromFile.clear();
        return new Appliance(parsedList);
    }
}
