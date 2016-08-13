package exhibitmanagement.client;
import exhibitmanagement.domain.Administrator;
import exhibitmanagement.domain.Ballistic;
import exhibitmanagement.services.BallisticService;
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
public class BallisticController {

    // Inject Service
    @Autowired
    private BallisticService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/ball/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ballistic> getBallistic(@PathVariable("id") long id) {
        Ballistic admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Ballistic>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ballistic>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ballistic> deleteAdministrator(@PathVariable("id") long id) {
        Ballistic admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Ballistic>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Ballistic>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public ResponseEntity<Set<Ballistic>> getBallistic() {
        Set<Ballistic> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Ballistic>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Ballistic>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/admin/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBallistic(@RequestBody Ballistic admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
