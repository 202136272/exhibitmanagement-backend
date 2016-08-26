package exhibitmanagement.client;

import exhibitmanagement.domain.Administrator;
import exhibitmanagement.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by Bonga on 8/9/2016.
 */
@RestController
public class AdministratorController {

    // Inject Service
    @Autowired
    private AdministratorService adminService;

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/admin/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrator> getAdministrator(@PathVariable("id") long id) {
        Administrator admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Administrator>(admin, HttpStatus.OK);
    }


    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Administrator> deleteAdministrator(@PathVariable("id") long id) {
        Administrator admin = adminService.readById(id);
        if (admin == null) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }
        adminService.delete(admin);
        return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
    }

    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/admin/all", method = RequestMethod.GET)
    public ResponseEntity<List<Administrator>> getAdministrator() {
        List<Administrator> admin = adminService.readAll();
        if(admin.isEmpty()){
            return new ResponseEntity<List<Administrator>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Administrator>>(admin, HttpStatus.OK);
    }


    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdministrator(@RequestBody Administrator admin, UriComponentsBuilder ucBuilder) {
        adminService.create(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}