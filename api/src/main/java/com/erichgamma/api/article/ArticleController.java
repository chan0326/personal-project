package com.erichgamma.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    public static ArticleController getinstance;
    private ArticleServicelmpl articleServicelmpl;

    ArticleController(){
        this.articleServicelmpl = ArticleServicelmpl.getInstance();
    }



    public List<?> findarticlecle() throws SQLException {
        return articleServicelmpl.findarticle();
    }
}
