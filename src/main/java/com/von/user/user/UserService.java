package com.von.user.user;

import java.util.List;
import com.von.user.common.command.CommandService;
import com.von.user.common.query.QueryService;

public interface UserService extends CommandService, QueryService {

    String updatePassword(User user);
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
}
