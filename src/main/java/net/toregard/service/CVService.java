package net.toregard.service;


import net.toregard.fault.BusinessFault;
import net.toregard.model.CV;
import org.springframework.stereotype.Service;

public interface CVService {
    public CV createCV(CV cv) throws BusinessFault;
    public CV saveCV(CV cv) throws BusinessFault;
    public CV findCVByYear(String year);
}
