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
import java.util.List;

/**
 * Created by Bonga on 8/13/2016.
 */
public class BiologyController {

    // Inject Service
    @Autowired
    private BiologyService biologyServiceService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/biology/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Biology> getBiology(@PathVariable("id") long id) {
            Biology biology = biologyServiceService.readById(id);
            if (biology == null) {
            return new ResponseEntity<Biology>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Biology>(biology, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/biology/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Biology> deleteBiology(@PathVariable("id") long id) {
        Biology biology = biologyServiceService.readById(id);
        if (biology == null) {
            return new ResponseEntity<Biology>(HttpStatus.NOT_FOUND);
        }
        biologyServiceService.delete(biology);
        return new ResponseEntity<Biology>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/biology/all", method = RequestMethod.GET)
    public ResponseEntity<List<Biology>> getBiology() {
        List<Biology> biology = biologyServiceService.readAll();
        if(biology.isEmpty()){
            return new ResponseEntity<List<Biology>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Biology>>(biology, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/biology/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createBiology(@RequestBody Biology biology, UriComponentsBuilder ucBuilder) {
        biologyServiceService.create(biology);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bio/{id}").buildAndExpand(biology.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
