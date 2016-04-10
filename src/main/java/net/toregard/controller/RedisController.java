package net.toregard.controller;

import net.toregard.fault.BusinessFault;
import net.toregard.model.CV;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @RequestMapping(value = "/redis/create/{year}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MessageCV> create(@PathVariable("year") String year) {
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

    private CV createCV(String year) throws BusinessFault  {
        CV cv = new CV();
        cv.setCompanyName("Bedriften AS"+year);
        cv.setDescription("Besrivelse"+year);
        cv.setLocation("Oslo+year");
        cv.setType("Kurs");
        cv.setYear(year);
        return  cv;
    }
}
