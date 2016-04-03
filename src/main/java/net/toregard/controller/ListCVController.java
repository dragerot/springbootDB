package net.toregard.controller;

import net.toregard.fault.BusinessFault;
import net.toregard.model.CV;
import net.toregard.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//// http://localhost:8080/test/vis/1
@RestController
public class ListCVController {

    @Autowired
    private CVService cVService;

    @RequestMapping(value = "/cv/create/{year}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MessageCV>  create(@PathVariable("year") String year) {
        MessageCV messageCV= new MessageCV();
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
        try{
           messageCV.setId(0);
           messageCV.setCv(createCV(year));
           messageCV.setMessage("OK");
            httpStatus=HttpStatus.OK;
        }catch (BusinessFault businessFault){
            messageCV.setId(businessFault.getId());
            messageCV.setMessage(businessFault.getMessage());
       }
        return new ResponseEntity<MessageCV>(messageCV,httpStatus);
   }

    @RequestMapping(value = "/cv/hent/{year}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CV>  get(@PathVariable("year") String year) {
        return new ResponseEntity<CV>(cVService.findCVByYear(year),HttpStatus.OK);
        //return new ResponseEntity<CV>(createCV("2012"),HttpStatus.OK);
    }

    private CV createCV(String year) throws BusinessFault  {
        CV cv = new CV();
        cv.setCompanyName("Schenker"+year);
        cv.setDescription("Besrivelse"+year);
        cv.setLocation("Oslo+year");
        cv.setType("Kurs");
        cv.setYear(year);
        return  cVService.createCV(cv);
    }


}
