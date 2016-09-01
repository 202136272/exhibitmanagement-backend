package exhibitmanagement.client;
import exhibitmanagement.domain.Ballistic;
import exhibitmanagement.services.BallisticService;
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
public class BallisticController {
    // Inject Service
    @Autowired
    private BallisticService ballisticService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/ballistic/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ballistic> getBallistic(@PathVariable("id") long id) {
        Ballistic admin = ballisticService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Ballistic>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ballistic>(admin, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/ballistic/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ballistic> deleteBallistic(@PathVariable("id") long id) {
        Ballistic ballistic = ballisticService.readById(id);
        if (ballistic == null) {
            return new ResponseEntity<Ballistic>(HttpStatus.NOT_FOUND);
        }
        ballisticService.delete(ballistic);
        return new ResponseEntity<Ballistic>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------
    @RequestMapping(value = "/ballistic/all", method = RequestMethod.GET)
    public ResponseEntity<List<Ballistic>> getBallistic() {
        List<Ballistic> ballistics = ballisticService.readAll();
        if(ballistics.isEmpty()){
            return new ResponseEntity<List<Ballistic>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Ballistic>>(ballistics, HttpStatus.OK);
    }

    //-------------------Create a Story--------------------------------------------------------
    @RequestMapping(value = "/ballistic/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBallistic(@RequestBody Ballistic ballistic, UriComponentsBuilder ucBuilder) {
        ballisticService.create(ballistic);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ballistic/{id}").buildAndExpand(ballistic.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}