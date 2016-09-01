package exhibitmanagement.factory;

import exhibitmanagement.domain.Exhibit;

/**
 * Created by Bonga on 8/13/2016.
 */
public class ExhibitFactory {

    public static Exhibit getExhibit(String casNumber, String station, String description, String sceneType )
    {
        Exhibit myExhibit = new Exhibit.Builder()
                .casNumber(casNumber)
                .station(station)
                .description(description)
                .sceneType(sceneType)
                .build();
        return myExhibit;

    }
}
