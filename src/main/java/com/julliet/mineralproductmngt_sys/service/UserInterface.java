package com.julliet.mineralproductmngt_sys.service;

import com.julliet.mineralproductmngt_sys.DataTransferObject.UserRegistartionDto;
import com.julliet.mineralproductmngt_sys.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService {
    public User saveAccount(UserRegistartionDto userRegistartionDto);
}
