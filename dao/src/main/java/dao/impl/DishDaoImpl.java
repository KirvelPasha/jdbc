package dao.impl;

import dao.interfaces.DishDao;
import entity.Dish;
import jdbc.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {
    private static final String SQL_QUERY_GET_DISH = "SELECT Id,Name,Price From Dish";

    @Override
    public List<Dish> getAllDish() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Dish>dishes = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_DISH);
            dishes = initDish(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dishes;
    }




    private static List<Dish> initDish(ResultSet resultSet) throws SQLException {
        List<Dish> dishes = new ArrayList<>();
        while (resultSet.next()){
            Dish dish = new Dish();
            dish.setId(resultSet.getInt("Id"));
            dish.setName(resultSet.getString("Name"));
            dish.setPrice(resultSet.getInt("Price"));
            dishes.add(dish);
        }
        return dishes;
    }
}
