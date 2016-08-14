package exhibitmanagement.factory;

import exhibitmanagement.domain.InvestigatingOfficer;

/**
 * Created by Bonga on 8/14/2016.
 */
public class InvestigatingOfficerFactory {


    public static InvestigatingOfficer getInvestigatingOfficer(String name, String rank, String station, String persalNumber)
    {
        InvestigatingOfficer myInvestigatingOfficer = new InvestigatingOfficer.Builder()
                .name(name)
                .rank(rank)
                .station(station)
                .persalNumber(persalNumber)
                .build();
        return myInvestigatingOfficer;

    }
}
