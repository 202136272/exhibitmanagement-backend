package exhibitmanagement.factory;;

import exhibitmanagement.domain.Administrator;

/*
 * Created by Bonga on 4/2/2016.
 */
public class AdministratorFactory {

    public static Administrator getAdministrator(String name, String surname, String persalNumber)
    {
        Administrator myAdmin = new Administrator.Builder()
                .name(name)
                .surname(surname)
                .persalNumber(persalNumber)
                .build();
        return myAdmin;

    }
}
