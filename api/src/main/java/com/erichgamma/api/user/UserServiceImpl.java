package com.erichgamma.api.user;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService {
    private final UserRepository userRepository;

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public Messenger delete(Object o) {
        return null;
    }

    @Override
    public Messenger deleteAll() {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return userRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional getOne(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
    // @Override
    // public Messenger makeTable(){
    //     return !userRepository.checkUsersTable()
    //             ? userRepository.makeTable()
    //             : Messenger.FAIL;
    // }

    // @Override
    // public Messenger removeTable(){
    //     return userRepository.checkUsersTable()
    //             ? userRepository.removeTable()
    //             : Messenger.FAIL;
    // }


    // @Override
    // public Messenger userExistsByUsername(String username) {
    //     return userRepository.userExistsByUsername(username);
    // }

    // @Override
    // public Messenger join(User user) {
    //     return userRepository.userExistsByUsername(user.getUsername()) == Messenger.FAIL
    //             ? userRepository.save(user)
    //             : Messenger.FAIL;
    // }

    // @Override
    // public Messenger login(User user) {
    //     return userRepository.login(user);
    // }
}
