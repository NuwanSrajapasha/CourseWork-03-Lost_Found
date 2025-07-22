package edu.lost_found.dao;

import edu.lost_found.dto.itemStatus;
import edu.lost_found.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDAO extends JpaRepository<ItemEntity, String> {
    List<ItemEntity> findByItemStatus(edu.lost_found.dto.itemStatus itemStatus);
}
