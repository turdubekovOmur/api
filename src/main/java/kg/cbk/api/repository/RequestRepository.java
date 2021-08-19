package kg.cbk.api.repository;

import kg.cbk.api.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {


}
