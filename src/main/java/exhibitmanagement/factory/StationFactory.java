package exhibitmanagement.factory;

import exhibitmanagement.domain.Station;

/**
 * Created by Bonga on 8/14/2016.
 */
public class StationFactory {


    public static Station getStation(String name, String address)
    {
        Station myStation = new Station.Builder()
                .name(name)
                .address(address)
                .build();
        return myStation;

    }
}
