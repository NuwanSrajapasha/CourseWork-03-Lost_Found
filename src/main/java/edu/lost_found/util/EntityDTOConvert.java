package edu.lost_found.util;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.entity.ItemEntity;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConvert {

    private final ModelMapper modelMapper;

    //Item
    public ItemEntity convertItemDTOToItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public ItemDTO convertItemEntityToItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList,new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
