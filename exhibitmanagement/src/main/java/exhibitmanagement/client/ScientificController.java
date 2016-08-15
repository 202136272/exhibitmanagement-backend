package exhibitmanagement.client;

import exhibitmanagement.domain.Scientific;
import exhibitmanagement.domain.Station;
import exhibitmanagement.services.ScientificService;
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
 * Created by Bonga on 8/15/2016.
 */
public class ScientificController  {


    // Inject Service
    @Autowired
    private ScientificService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/sci/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Scientific> getScientific(@PathVariable("id") long id) {
        Scientific admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Scientific>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Scientific>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/sci/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Scientific> deleteStation(@PathVariable("id") long id) {
        Scientific admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Scientific>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Scientific>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/sci/", method = RequestMethod.GET)
    public ResponseEntity<Set<Scientific>> getBiology() {
        Set<Scientific> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Scientific>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Scientific>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/sci/", method = RequestMethod.POST)
    public ResponseEntity<Void> createScientific(@RequestBody Scientific admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/stat/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
