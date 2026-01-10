package com.example.figma2.service;

import com.example.figma2.entity.Category;
import com.example.figma2.entity.Group;
import com.example.figma2.entity.Room;
import com.example.figma2.entity.User;
import com.example.figma2.exception.NotFoundEx;
import com.example.figma2.payload.ApiResponse;
import com.example.figma2.payload.GroupDTO;
import com.example.figma2.repository.CategoryRepository;
import com.example.figma2.repository.GroupRepository;
import com.example.figma2.repository.RoomRepositor;
import com.example.figma2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;


@Service
@RequiredArgsConstructor
public class GroupService {


    private final UserRepository userRepository;
    private final RoomRepositor roomRepositor;
    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;

    public ApiResponse addGroup(GroupDTO groupDTO) {
        if (groupRepository.existsByNameIgnoreCaseAndActiveIsTrue(groupDTO.getName())) {

            return new ApiResponse("Bunday nomli Guruh mavjud" , false ,HttpStatus.ALREADY_REPORTED , null);
        }

        User teacher= userRepository.findById(groupDTO.getTeacherId())
                .orElseThrow(() -> new NotFoundEx("Teacher not found"));


        Room room = roomRepositor.findById(groupDTO.getRoomId())
                .orElseThrow(() -> new NotFoundEx("Room not found"));

        Category category = categoryRepository.findById(groupDTO.getCategoryId())
                .orElseThrow(() -> new NotFoundEx("Category not found"));

        Group grop = Group.builder()

                .name(groupDTO.getName())
                .CategoryID(category)
                .roomId(room)
                .days(groupDTO.getDays())
                .start_date(groupDTO.getStartDate())
                .start_time(groupDTO.getStartTime())
                .teacherId(teacher)
                .isActive(groupDTO.isActive())
                .end_date(groupDTO.getEndDate())
                .end_time(groupDTO.getEndTime())
                .build();
        groupRepository.save(grop);

      return new ApiResponse("Group saved" ,true ,HttpStatus.OK, null);

    }

      public ApiResponse updateGroup(GroupDTO groupDTO , Integer categoryId, Integer groupId) {


          Group group = groupRepository.findById(groupId)
                  .orElseThrow(() -> new NotFoundEx("Group not found"));

          User teacher = userRepository.findById(groupDTO.getTeacherId())
                  .orElseThrow(() -> new NotFoundEx("Teacher not found"));

          Category category = categoryRepository.findByIdAndActiveTrue(categoryId)
                  .orElseThrow(() -> new NotFoundEx("Category not found"));

          Room room = roomRepositor.findById(groupDTO.getRoomId())
                  .orElseThrow(() -> new NotFoundEx("Room not found"));


          if (groupRepository.existsByNameIgnoreCaseAndActiveIsTrue(groupDTO.getName())){

          return new ApiResponse("Bunday Nomli guruh mavjud" , false ,HttpStatus.ALREADY_REPORTED , null);

          }

      group.setName(groupDTO.getName());
      group.setCategoryID(category);
      group.setRoomId(room);
      group.setTeacherId(teacher);
      group.setIsActive(groupDTO.isActive());
      group.setDays(groupDTO.getDays());
      group.setStart_date(groupDTO.getStartDate());
      group.setStart_time(groupDTO.getStartTime());
      group.setEnd_date(groupDTO.getEndDate());
      group.setEnd_time(groupDTO.getEndTime());
      groupRepository.save(group);
      return new ApiResponse("Group saved" ,true ,HttpStatus.OK, null);

      }


      public ApiResponse getGroup( ) {





      }





}
