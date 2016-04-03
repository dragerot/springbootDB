package net.toregard.service;

import net.toregard.fault.BusinessFault;
import net.toregard.model.CV;
import net.toregard.respository.CVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CVServiceImp implements CVService{
    @Autowired
    private CVRepository cvRepository;

   @Override
    public CV createCV(CV cv) throws BusinessFault {
       CV cvOld =cvRepository.findByYear(cv.getYear());
       if(cvOld!=null) throw new BusinessFault(10,"CV finnes allerede: cv="+cvOld.toString());
       return cvRepository.saveAndFlush(cv);
    }

    @Override
    public CV saveCV(CV cv) throws BusinessFault {
        CV cvOld =cvRepository.findByYear(cv.getYear());
        if(cvOld==null) throw new BusinessFault(20,"CV finnes ikke: cv="+cv.toString());
        return cvRepository.saveAndFlush(cv);
    }

    @Override
    public CV findCVByYear(String year){
        return cvRepository.findByYear(year);
    }
}
