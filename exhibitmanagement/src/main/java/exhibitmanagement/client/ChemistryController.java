package exhibitmanagement.client;

import exhibitmanagement.domain.Chemistry;
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

import java.util.List;
/**
 * Created by Bonga on 8/13/2016.
 */
public class ChemistryController {

    // Inject Service
    @Autowired
    private ChemistryService chemistryService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/chemistry/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chemistry> getChemistry(@PathVariable("id") long id) {
        Chemistry chemistry = chemistryService.readById(id);
        if (chemistry == null) {
            return new ResponseEntity<Chemistry>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Chemistry>(chemistry, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/chemistry/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Chemistry> deleteChemistry(@PathVariable("id") long id) {
        Chemistry chemistry = chemistryService.readById(id);
        if (chemistry == null) {
            return new ResponseEntity<Chemistry>(HttpStatus.NOT_FOUND);
        }
        chemistryService.delete(chemistry);
        return new ResponseEntity<Chemistry>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------
    @RequestMapping(value = "/chemistry/all", method = RequestMethod.GET)
    public ResponseEntity<List<Chemistry>> getChemistry() {
        List<Chemistry> chemistry = chemistryService.readAll();
        if(chemistry.isEmpty()){
            return new ResponseEntity<List<Chemistry>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Chemistry>>(chemistry, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------
    @RequestMapping(value = "/chemistry/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createChemistry(@RequestBody Chemistry chemistry, UriComponentsBuilder ucBuilder) {
        chemistryService.create(chemistry);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/che/{id}").buildAndExpand(chemistry.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
