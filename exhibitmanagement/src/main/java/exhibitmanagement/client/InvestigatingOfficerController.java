package exhibitmanagement.client;

import exhibitmanagement.domain.InvestigatingOfficer;
import exhibitmanagement.domain.Station;
import exhibitmanagement.services.InvestigatingOfficerService;
import exhibitmanagement.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by Bonga on 8/14/2016.
 */
public class InvestigatingOfficerController  {

    // Inject Service
    @Autowired
    private InvestigatingOfficerService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/io/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvestigatingOfficer> getStation(@PathVariable("id") long id) {
        InvestigatingOfficer admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<InvestigatingOfficer>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/io/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<InvestigatingOfficer> deleteStation(@PathVariable("id") long id) {
        InvestigatingOfficer admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/io/", method = RequestMethod.GET)
    public ResponseEntity<Set<InvestigatingOfficer>> getBiology() {
        Set<InvestigatingOfficer> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<InvestigatingOfficer>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<InvestigatingOfficer>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/io/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStation(@RequestBody InvestigatingOfficer admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/io/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
