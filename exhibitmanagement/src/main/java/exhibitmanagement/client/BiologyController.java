package exhibitmanagement.client;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.services.BiologyService;
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
public class BiologyController {


    // Inject Service
    @Autowired
    private BiologyService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/bio/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Biology> getBiology(@PathVariable("id") long id) {
            Biology admin = adminService.readById(id);
            if (admin == null) {
            return new ResponseEntity<Biology>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Biology>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/bio/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Biology> deleteBiology(@PathVariable("id") long id) {
        Biology admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Biology>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Biology>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/bio/", method = RequestMethod.GET)
    public ResponseEntity<Set<Biology>> getBiology() {
        Set<Biology> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Biology>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Biology>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/bio/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBiology(@RequestBody Biology admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bio/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
