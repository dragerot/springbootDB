package net.toregard.respository;

import net.toregard.Application;
import net.toregard.model.CV;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

//@ContextConfiguration()
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes=net.toregard.app.Application.class)
//@ContextConfiguration(locations={"classpath:com/guitar/db/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
//@ActiveProfiles("test")
public class CVRepositoryTest {
    @Autowired
    private CVRepository cVRepository;



    @Test
    public void registrer(){
        CV cv = new CV();
        cv.setCompanyName("A");
        cv.setDescription("B");
        cv.setLocation("AA");
        cv.setType("dsdsd");
        cv.setYear("2010");
        this.cVRepository.saveAndFlush(cv);
        //CV c=cVRepository.findByYear("2010");
        //assertEquals("2010", c.getYear());

        CV c2v = new CV();
        c2v.setCompanyName("B");
        c2v.setDescription("B");
        c2v.setLocation("AA");
        c2v.setType("dsdsd");
        c2v.setYear("2014");
        this.cVRepository.saveAndFlush(c2v);

        assertEquals("2010", cVRepository.findByYear("2010").getYear());
        assertEquals("2014", cVRepository.findByYear("2014").getYear());
        for(CV item : this.cVRepository.findAll()){
            System.out.println(item.getId()+" "+item.getYear()+" "+item.getCompanyName());
        }

    }

}
