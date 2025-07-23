package edu.lost_found.util;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.RequestDTO;
import edu.lost_found.dto.UserDTO;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.entity.RequestEntity;
import edu.lost_found.entity.UserEntity;
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

    //Request
    public RequestEntity convertRequestDTOToRequestEntity(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO, RequestEntity.class);
    }
    public RequestDTO convertRequestEntityToRequestDTO(RequestEntity requestEntity) {
        return modelMapper.map(requestEntity, RequestDTO.class);
    }
    public List<RequestDTO> toRequestDTOList(List<RequestEntity> requestEntityList) {
        return modelMapper.map(requestEntityList,new TypeToken<List<RequestDTO>>(){}.getType());
    }

    //User
    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }
}
