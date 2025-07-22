package edu.lost_found.dao;

import edu.lost_found.dto.itemStatus;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDAO extends JpaRepository<AbstractReadWriteAccess.Item, Integer> {
    List<AbstractReadWriteAccess.Item> findByStatus(itemStatus status);
}
