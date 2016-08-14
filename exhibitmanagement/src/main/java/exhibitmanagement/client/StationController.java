package exhibitmanagement.client;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.domain.Station;
import exhibitmanagement.services.ExhibitService;
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
public class StationController {


    // Inject Service
    @Autowired
    private StationService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/stat/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> getStation(@PathVariable("id") long id) {
        Station admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Station>(admin, HttpStatus.OK);
    }



    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/stat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Station> deleteStation(@PathVariable("id") long id) {
        Station admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/stat/", method = RequestMethod.GET)
    public ResponseEntity<Set<Station>> getBiology() {
        Set<Station> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<Set<Station>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Station>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/stat/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStation(@RequestBody Station admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/stat/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
