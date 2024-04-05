package com.von.user.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.von.user.user.model.UserDto;
import com.von.user.common.component.PageRequestVo;
import com.von.user.user.model.User;
import com.von.user.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("rawtypes")
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private UserRepository repo;

    @Override
    public UserDto save(UserDto t) {
        return entityToDto(Optional.of(repo.save(dtoToEntity(t))));
    }


    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<UserDto> findAll(PageRequestVo vo) {
        //return repo.findAll(vo);
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.of(entityToDto(repo.findById(id)));
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}
//public String deleteAll() {
//    repo.deleteAll();
//    return "All users deleted successfully";
//}
