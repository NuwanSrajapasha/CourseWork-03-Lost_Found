package edu.lost_found.dao;

import edu.lost_found.dto.itemStatus;
import edu.lost_found.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity, String> {
    List<ItemEntity> findByItemStatus(edu.lost_found.dto.itemStatus itemStatus);
}
