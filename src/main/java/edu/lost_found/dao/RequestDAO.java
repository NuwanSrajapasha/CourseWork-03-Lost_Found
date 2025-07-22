package edu.lost_found.dao;

import edu.lost_found.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestDAO extends JpaRepository<RequestEntity,String> {
    List<RequestEntity> findByRequestID(String requestID);
}
