package exhibitmanagement.client;

import exhibitmanagement.domain.InvestigatingOfficer;
import exhibitmanagement.services.InvestigatingOfficerService;
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

import java.util.List;
import java.util.Set;

/**
 * Created by Bonga on 8/14/2016.
 */
public class InvestigatingOfficerController  {

    // Inject Service
    @Autowired
    private InvestigatingOfficerService officerService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/officer/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvestigatingOfficer> getStation(@PathVariable("id") long id) {
        InvestigatingOfficer officer = officerService.readById(id);
        if (officer == null) {
            return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<InvestigatingOfficer>(officer, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/officer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<InvestigatingOfficer> deleteOfficer(@PathVariable("id") long id) {
        InvestigatingOfficer officer = officerService.readById(id);
        if (officer == null) {
            return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NOT_FOUND);
        }
        officerService.delete(officer);
        return new ResponseEntity<InvestigatingOfficer>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------
    @RequestMapping(value = "/officer/all", method = RequestMethod.GET)
    public ResponseEntity<List<InvestigatingOfficer>> getOfficer() {
        List<InvestigatingOfficer> exhibit = officerService.readAll();
        if(exhibit.isEmpty()){
            return new ResponseEntity<List<InvestigatingOfficer>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<InvestigatingOfficer>>(exhibit, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/io/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOfficer(@RequestBody InvestigatingOfficer officer, UriComponentsBuilder ucBuilder) {
        officerService.create(officer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/io/{id}").buildAndExpand(officer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
