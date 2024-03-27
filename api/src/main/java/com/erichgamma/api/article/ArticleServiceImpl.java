package com.erichgamma.api.article;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends AbstractService {
    private final ArticleRepository articleRepository;


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
        return articleRepository.findAll();
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
}
