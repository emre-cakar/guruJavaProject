package com.guru.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.guru.help.DBConnection;
import com.guru.help.Help;

public class StockType {

	private int id;
	private String code;
	private String name;
	private String description;
	
	private DBConnection dbConnection;
	
	public StockType() {}
	
	public StockType(int id, String code, String name, String description) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public String toString()
    {
        return name;
    }

	//Methods
	
	public boolean saveStockType(StockType stockType) {
		dbConnection = new DBConnection();
		int control = -1;
		PreparedStatement pr = null;
		String query = "INSERT INTO stocktypes (code, name, description) VALUES (?,?,?)";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stockType.getCode());
			pr.setString(2, stockType.getName());
			pr.setString(3, stockType.getDescription());
			control = pr.executeUpdate();
		} catch (SQLException e) {
			Help.showMsg("err");
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				Help.showMsg("err");
			}
		}
		return control == 1;
	}
	public boolean deleteStockType(StockType stockType) {
		dbConnection = new DBConnection();
		PreparedStatement pr = null;
		String query = "DELETE FROM stocktypes WHERE id = ?";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setInt(1, stockType.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				Help.showMsg("err");
			}
		}
		return true;
	}
	public boolean updateStockType(StockType stockType) {
		dbConnection = new DBConnection();
		int control = -1;
		PreparedStatement pr = null;
		String query = "UPDATE stocktypes SET code=?,  name=?, description=? WHERE id=?";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stockType.getCode());
			pr.setString(2, stockType.getName());
			pr.setString(3, stockType.getDescription());
			pr.setInt(4, stockType.getId());
			control = pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return control == 1;
	}
	public StockType getStockTypeItem(StockType stockType) {
		dbConnection = new DBConnection();
		StockType stp = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		String query = "SELECT * FROM stocktypes WHERE code=?";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stockType.getCode());
			rs = pr.executeQuery();
			if (rs.next()) {
				stp = new StockType(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"));
			}
		} catch (SQLException e) {
			Help.showMsg("err");
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				Help.showMsg("err");
			}
		}
		return stp;
	}
	public StockType beforNextStockType(String whichOne, Integer value) {
		dbConnection = new DBConnection();
		PreparedStatement pr = null;
		StockType stockType = null;
		ResultSet rs = null;
		String query = null;
		if (whichOne.equals("first")) {
			query = "SELECT * FROM guru.stocktypes ORDER BY id ASC LIMIT 1;";
		} else if (whichOne.equals("last")) {
			query = "SELECT * FROM guru.stocktypes ORDER BY id DESC LIMIT 1;";
		} else if (whichOne.equals("next")) {
			query = "SELECT * FROM guru.stocktypes WHERE id= (SELECT min(id) FROM guru.stocktypes WHERE id>" + value
					+ ");";
		} else if (whichOne.equals("before")) {
			query = "SELECT * FROM guru.stocktypes WHERE id= (SELECT Max(id) FROM guru.stocktypes WHERE id<" + value
					+ ");";
		}
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			rs = pr.executeQuery();
			if (rs.next()) {
				stockType = new StockType(rs.getInt("id"), rs.getString("code"), rs.getString("name"),  rs.getString("description"));
			}
		} catch (SQLException e) {
			Help.showMsg("err");
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				Help.showMsg("err");
			}
		}
		return stockType;
	}
	
	public ArrayList<StockType> getStockTypeList() {
		dbConnection = new DBConnection();
		ArrayList<StockType> stockTypeList = new ArrayList<StockType>();
		ResultSet rs = null;
		Statement st = null;
		String query = "SELECT * FROM stocktypes";
		StockType stockType = new StockType();
		try {
			st = dbConnection.getConnection().createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				stockType = new StockType(rs.getInt("id"), rs.getString("code"), rs.getString("name"),  rs.getString("description"));

				stockTypeList.add(stockType);
			}
		} catch (SQLException e) {
			Help.showMsg("err");
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				Help.showMsg("err");
			}
		}
		return stockTypeList;
	}
}
