package com.erichgamma.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance;

    private Connection connection;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArticleRepository getInstance() {
        return instance;
    }

    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb", "erichgamma",
                "erichgammadb"
        );

    }

    public List<?> findList() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        System.out.println("sql : " + sql);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .build());
            }while (rs.next());
        }else{
            System.out.println("No Data");
        }
        rs.close();
        pstmt.close();
        connection.close();
        return ls;
    }
}
