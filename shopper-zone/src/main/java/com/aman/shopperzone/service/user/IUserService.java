package com.aman.shopperzone.service.user;

import com.aman.shopperzone.dto.UserDto;
import com.aman.shopperzone.model.User;
import com.aman.shopperzone.request.CreateUserRequest;
import com.aman.shopperzone.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);

    User createUser(CreateUserRequest request);

    User updateUser(UserUpdateRequest request, Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
