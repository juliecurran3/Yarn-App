package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Skein;

public class SkeinDao {
  
  private Connection connection;
 
  
  private final String GET_SKEINS_QUERY = "SELECT * FROM skeins";
  private final String GET_SKEIN_BY_ID_QUERY = "SELECT * FROM skeins WHERE id = ?";
  private final String CREATE_NEW_SKEIN_QUERY = "INSERT INTO skeins(brand, color) VALUES(?,?)";
  private final String DELETE_SKEIN_BY_ID_QUERY = "DELETE FROM skeins WHERE id = ?";
  private final String UPDATE_SKEIN_BY_ID_QUERY = "UPDATE skeins SET brand = ?,  color = ? WHERE id = ? ";
  public SkeinDao() { 
    connection = DBConnection.getConnection();
   
  }   


  public List<Skein> getSkeins() throws SQLException {
    ResultSet rs = connection.prepareStatement(GET_SKEINS_QUERY).executeQuery();
    List<Skein> skeins = new ArrayList<Skein>();
    
    while (rs.next()) {
      skeins.add(populateSkein(rs.getInt(1), rs.getString(2), rs.getString(3)));
    }
    return skeins;
  }
  public Skein getSkeinById(int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(GET_SKEIN_BY_ID_QUERY);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return populateSkein(rs.getInt(1), rs.getString(2), rs.getString(3));
  }

  public void createNewSkein(String skeinBrand, String skeinColor) throws SQLException {
    PreparedStatement ps = connection.prepareStatement (CREATE_NEW_SKEIN_QUERY);
    ps.setString(1,skeinBrand);
    ps.setString(2,skeinColor);
    ps.executeUpdate();

  }
  public void deleteSkeinById(int id) throws SQLException { 
    PreparedStatement ps = connection.prepareStatement(DELETE_SKEIN_BY_ID_QUERY);
    ps.setInt(1, id);
    ps.executeUpdate();
  }
  
  public void updateSkeinByIdQuery(String skeinBrand, String skeinColor, int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(UPDATE_SKEIN_BY_ID_QUERY);
    ps.setString(1,skeinBrand);
    ps.setString(2,skeinColor);
    ps.setInt(3,id);
    ps.executeUpdate();
  }
 
  private Skein populateSkein(int id, String brand, String color) throws SQLException {
    return new Skein(id,brand,color);
  }





}