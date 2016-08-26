package exhibitmanagement.client;

import exhibitmanagement.domain.Station;
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

import java.util.List;
import java.util.Set;

/**
 * Created by Bonga on 8/14/2016.
 */
public class StationController {

    // Inject Service
    @Autowired
    private StationService stationService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/station/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> getStation(@PathVariable("id") long id) {
        Station station = stationService.readById(id);
        if (station == null) {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Station>(station, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------
    @RequestMapping(value = "/station/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Station> deleteStation(@PathVariable("id") long id) {
        Station station = stationService.readById(id);
        if (station == null) {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }
        stationService.delete(station);
        return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/station/all", method = RequestMethod.GET)
    public ResponseEntity<List<Station>> getStation() {
        List<Station> station = stationService.readAll();
        if(station.isEmpty()){
            return new ResponseEntity<List<Station>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Station>>(station, HttpStatus.OK);
    }

    //-------------------Create a Story--------------------------------------------------------
    @RequestMapping(value = "/station/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createStation(@RequestBody Station station, UriComponentsBuilder ucBuilder) {
        stationService.create(station);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/stat/{id}").buildAndExpand(station.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
