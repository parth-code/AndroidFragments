package com.example.assignment3appa2;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataMap {
    public static Map<String, String> attractionWebMap = new LinkedHashMap<String, String>(){{
        put("Millennium Park", "https://www.chicago.gov/city/en/depts/dca/supp_info/millennium_park.html");
        put("Willis Tower", "https://www.willistower.com/");
        put("Cloud Gate", "https://en.wikipedia.org/wiki/Cloud_Gate");
        put("The Magnificent Mile", "https://www.themagnificentmile.com/");
        put("Garfield Park Conservatory", "https://garfieldconservatory.org");
        put("Navy Pier", "https://navypier.org/");
    }};
    public static Map<String, String> restaurantWebMap = new LinkedHashMap<String, String>(){{
        put("Marie's Pizza & Liquors", "https://mariespizzachicago.com/Welcome.html");
        put("Orange Garden", "http://www.eatorangegarden.com/zgrid/themes/10592/intro/index.jsp");
        put("Gene & Jude's", "http://geneandjudes.com/");
        put("Margie's Candies", "https://margiesfinecandies.com/");
        put("Twin Anchors Restaurant & Tavern", "http://www.twinanchorsribs.com/");
        put("Green Door Tavern", "http://www.greendoorchicago.com/");
    }};
}
