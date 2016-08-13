package exhibitmanagement.client;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.domain.Chemistry;
import exhibitmanagement.services.BiologyService;
import exhibitmanagement.services.ChemistryService;
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
 * Created by Bonga on 8/13/2016.
 */
public class ChemistryController {

    // Inject Service
    @Autowired
    private ChemistryService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/che/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chemistry> getChemistry(@PathVariable("id") long id) {
        Chemistry admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Chemistry>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Chemistry>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/che/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Chemistry> deleteChemistry(@PathVariable("id") long id) {
        Chemistry admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Chemistry>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Chemistry>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/bio/", method = RequestMethod.GET)
    public ResponseEntity<Set<Chemistry>> getBiology() {
        Set<Chemistry> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Chemistry>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Chemistry>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/che/", method = RequestMethod.POST)
    public ResponseEntity<Void> createChemistry(@RequestBody Chemistry admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/che/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
