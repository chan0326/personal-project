package com.erichgamma.api.article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {

    List<?> findarticle() throws SQLException;

}
