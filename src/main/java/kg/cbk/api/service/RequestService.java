package kg.cbk.api.service;

import kg.cbk.api.entity.Request;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestService {
    Object check(Request request);
    Object add(Request entity);
}
