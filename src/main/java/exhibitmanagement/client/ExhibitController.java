package exhibitmanagement.client;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.services.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
/**
 * Created by Bonga on 8/13/2016.
 */
@RestController
public class ExhibitController {

    // Inject Service
    @Autowired
    private ExhibitService exhibitService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/exhibit/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Exhibit> getExhibit(@PathVariable("id") long id) {
        Exhibit exhibit = exhibitService.readById(id);
        if (exhibit == null) {
            return new ResponseEntity<Exhibit>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Exhibit>(exhibit, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/exhibit/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Exhibit> deleteExhibit(@PathVariable("id") long id) {
        Exhibit exhibit = exhibitService.readById(id);
        if (exhibit == null) {
            return new ResponseEntity<Exhibit>(HttpStatus.NOT_FOUND);
        }
        exhibitService.delete(exhibit);
        return new ResponseEntity<Exhibit>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------
    @RequestMapping(value = "/exhibit/all", method = RequestMethod.GET)
    public ResponseEntity<List<Exhibit>> getExhibit() {
        List<Exhibit> exhibit = exhibitService.readAll();
        if(exhibit.isEmpty()){
            return new ResponseEntity<List<Exhibit>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Exhibit>>(exhibit, HttpStatus.OK);
    }

    //-------------------Create a Story--------------------------------------------------------
    @RequestMapping(value = "/exhibit/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createExhibit(@RequestBody Exhibit exhibit, UriComponentsBuilder ucBuilder) {
        exhibitService.create(exhibit);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/exhibit/{id}").buildAndExpand(exhibit.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
