package exhibitmanagement.client;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.services.ExhibitService;
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
public class ExhibitController {


    // Inject Service
    @Autowired
    private ExhibitService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/exh/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Exhibit> getExhibit(@PathVariable("id") long id) {
        Exhibit admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Exhibit>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Exhibit>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/exh/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Exhibit> deleteExhibit(@PathVariable("id") long id) {
        Exhibit admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Exhibit>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Exhibit>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/exh/", method = RequestMethod.GET)
    public ResponseEntity<Set<Exhibit>> getBiology() {
        Set<Exhibit> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Exhibit>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Exhibit>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/exh/", method = RequestMethod.POST)
    public ResponseEntity<Void> createExhibit(@RequestBody Exhibit admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/exh/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
