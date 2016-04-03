package net.toregard.respository;

import net.toregard.model.CV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {

    public CV findByYear(String year);
}
