package com.guru.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.guru.help.DBConnection;
import com.guru.help.Help;

public class Stock {
	private DBConnection dbConnection;
	private String code;
	private String name;
	private int type;
	private String unit;
	private String barcode;
	private double varType;
	private String description;
	private Date createdDate;

	public Stock() {
	}

	public Stock(String code, String name, int type, String unit, String barcode, double varType, String description,
			Date createdDate) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.unit = unit;
		this.barcode = barcode;
		this.varType = varType;
		this.description = description;
		this.createdDate = createdDate;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getVarType() {
		return varType;
	}

	public void setVarType(double varType) {
		this.varType = varType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	// Methods
	public boolean save(Stock stock) {
		dbConnection = new DBConnection();
		int control = -1;
		PreparedStatement pr = null;
		String query = "INSERT INTO stocks (code, name, type, unit, barcode, varType, description, createdTime) VALUES (?,?,?,?,?,?,?,?)";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stock.getCode());
			pr.setString(2, stock.getName());
			pr.setInt(3, stock.getType());
			pr.setString(4, stock.getUnit());
			pr.setString(5, stock.getBarcode());
			pr.setDouble(6, stock.getVarType());
			pr.setString(7, stock.getDescription());
			pr.setDate(8, stock.getCreatedDate());
			control = pr.executeUpdate();
			System.out.println(control);
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

	public boolean delete(String stockCode) {
		dbConnection = new DBConnection();
		PreparedStatement pr = null;
		String query = "DELETE FROM stocks WHERE code = ?";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stockCode);
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

	public boolean update(Stock stock) {
		dbConnection = new DBConnection();
		int control = -1;
		PreparedStatement pr = null;
		String query = "UPDATE stocks SET name=?, type=?, unit=?, barcode=?, varType=?, description=?, createdTime=? WHERE code=?";
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stock.getName());
			pr.setInt(2, stock.getType());
			pr.setString(3, stock.getUnit());
			pr.setString(4, stock.getBarcode());
			pr.setDouble(5, stock.getVarType());
			pr.setString(6, stock.getDescription());
			pr.setDate(7, stock.getCreatedDate());
			pr.setString(8, stock.getCode());
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

	public ArrayList<Stock> searchStock(String stockCode) {
		dbConnection = new DBConnection();
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		ResultSet rs = null;
		Statement st = null;
		String query = "SELECT * FROM stocks WHERE code LIKE '%" + stockCode + "%'";
		Stock stock = new Stock();
		try {
			st = dbConnection.getConnection().createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				stock = new Stock(rs.getString("code"), rs.getString("name"), rs.getInt("type"), rs.getString("unit"),
						rs.getString("barcode"), rs.getDouble("varType"), rs.getString("description"),
						rs.getDate("createdTime"));

				stockList.add(stock);
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
		return stockList;
	}

	public Stock getStock(String stockCode) {
		dbConnection = new DBConnection();
		Stock stock = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		String query = "SELECT * FROM stocks WHERE code=?";

		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			pr.setString(1, stockCode);
			rs = pr.executeQuery();
			if (rs.next()) {
				stock = new Stock(rs.getString("code"), rs.getString("name"), rs.getInt("type"), rs.getString("unit"),
						rs.getString("barcode"), rs.getDouble("varType"), rs.getString("description"),
						rs.getDate("createdTime"));
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
		return stock;
	}

	public Stock beforNextStock(String whichOne, String value) {
		dbConnection = new DBConnection();
		PreparedStatement pr = null;
		Stock stock = null;
		ResultSet rs = null;
		String query = null;
		if (whichOne.equals("first")) {
			query = "SELECT * FROM guru.stocks ORDER BY CODE ASC LIMIT 1;";
		} else if (whichOne.equals("last")) {
			query = "SELECT * FROM guru.stocks ORDER BY CODE DESC LIMIT 1;";
		} else if (whichOne.equals("next")) {
			query = "SELECT * FROM guru.stocks WHERE code= (SELECT min(code) FROM guru.stocks WHERE code>'" + value
					+ "');";
		} else if (whichOne.equals("before")) {
			query = "SELECT * FROM guru.stocks WHERE code= (SELECT Max(code) FROM guru.stocks WHERE code<'" + value
					+ "');";
		}
		try {
			pr = dbConnection.getConnection().prepareStatement(query);
			rs = pr.executeQuery();
			if (rs.next()) {
				stock = new Stock(rs.getString("code"), rs.getString("name"), rs.getInt("type"), rs.getString("unit"),
						rs.getString("barcode"), rs.getDouble("varType"), rs.getString("description"),
						rs.getDate("createdTime"));
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
		return stock;
	}
}
