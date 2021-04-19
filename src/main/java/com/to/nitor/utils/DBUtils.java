package com.to.nitor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.to.nitor.domain.Item;

public class DBUtils {
	private Connection conn;
	private String jdbcConnectionURL;
	private String username;
	private String password;
	
	public DBUtils(String jdbcConnectionURL, String username, String password) {
		this.jdbcConnectionURL = jdbcConnectionURL;
		this.username = username;
		this.password = password;
	}
	
	public void getConnection() {
		this.conn = null;
		try {
			this.conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
		} catch (Exception e) {
			System.out.println("Get Connection Failed: "+ e);
		} 
	}
	
	public void closeConnection() {
		try {
			DriverManager.getConnection(jdbcConnectionURL, username, password).close();
		} catch(Exception e) {
			System.out.println("Close Connection Failed: "+e);
		}
	}
	
	public Item itemFromResultSet(ResultSet resultSet) throws SQLException{
		String Name = resultSet.getString("Name");
		Long Quantity = resultSet.getLong("Quantity");
		Long Id = resultSet.getLong("Id");
		return new Item(Name, Quantity, Id);	
	}
	
	public List<Item> readAll() {
		try(Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Inventory");
			){
			List<Item> items = new ArrayList<>();
			while(resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			System.out.println("SQL Failed: "+e);
		}
		return new ArrayList<>();
	}
	
	public void createItem(Item item) {
		try(Statement statement = conn.createStatement()){
			statement.executeUpdate("INSERT INTO Inventory (Name, Quantity) VALUES ('"+item.getName()+"','"+item.getQuantity()+"')");
		} catch(Exception e) {
			System.out.println("Item creation failed: "+e);
		}
	}
	
	public void removeItem(Long id) {
		try(Statement statement = conn.createStatement()){
			statement.executeUpdate("DELETE FROM Inventory WHERE Id = "+id+";");
		} catch(Exception e) {
			System.out.println("Item removal failed: "+e);
		}
	}
	
}

