package com.guru.Model;

import com.guru.Helper.DBConnection;
import com.guru.Helper.Help;

import java.sql.*;
import java.util.ArrayList;

public class StockManager {

    public static ArrayList<Stock> getList(){
        ArrayList<Stock> stockList=new ArrayList<Stock>();
        ResultSet rs=null;
        Statement st=null;
        String query="SELECT * FROM stocks";
        Stock stock=new Stock();
        try {
            st=DBConnection.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                stock=new Stock(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getString("unit"),
                        rs.getString("barcode"),
                        rs.getDouble("varType"),
                        rs.getString("description"),
                        rs.getString("createdTime")
                );
                stockList.add(stock);
            }
        } catch (SQLException e) {
            Help.showMsg("err");
        }finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                Help.showMsg("err");
            }
        }
        return stockList;
    }

    public static ArrayList<Stock> getListByCode(String code){
        ArrayList<Stock> stockList=new ArrayList<Stock>();
        ResultSet rs=null;
        Statement st=null;
        String query="SELECT * FROM stocks WHERE code LIKE '%"+ code +"%'";
        Stock stock=new Stock();
        try {
            st=DBConnection.getConnection().createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                stock=new Stock(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getString("unit"),
                        rs.getString("barcode"),
                        rs.getDouble("varType"),
                        rs.getString("description"),
                        rs.getString("createdTime")
                );
                stockList.add(stock);
            }
        } catch (SQLException e) {
            Help.showMsg("err");
        }finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                Help.showMsg("err");
            }
        }
        return stockList;
    }

    public static Stock isThereByCode(String code){
        Stock stock=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        String query="SELECT * FROM stocks WHERE code=?";

        try {
            pr=DBConnection.getConnection().prepareStatement(query);
            pr.setString(1,code);
            rs=pr.executeQuery();
            if(rs.next()){
                stock=new Stock(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("type"),
                        rs.getString("unit"),
                        rs.getString("barcode"),
                        rs.getDouble("varType"),
                        rs.getString("description"),
                        rs.getString("createdTime")
                );
            }
        } catch (SQLException e) {
            Help.showMsg("err");
        }finally {
            try {
                pr.close();
                rs.close();
            } catch (SQLException e) {
                Help.showMsg("err");
            }
        }
        return  stock;
    }

    public static boolean add(Stock stock){
        PreparedStatement pr=null;
        String query="INSERT INTO stocks (code, name, type, unit, barcode, varType, description, createdTime) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pr=DBConnection.getConnection().prepareStatement(query);
            pr.setString(1,stock.getCode());
            pr.setString(2,stock.getName());
            pr.setInt(3,stock.getType());
            pr.setString(4,stock.getUnit());
            pr.setString(5,stock.getBarcode());
            pr.setDouble(6,stock.getVarType());
            pr.setString(7,stock.getDescription());
            pr.setString(8,stock.getCreatedDate());
            pr.executeUpdate();
        } catch (SQLException e) {
            Help.showMsg("err");
        }finally {
            try {
                pr.close();
            } catch (SQLException e) {
                Help.showMsg("err");
            }
        }
        return true;
    }

    public static boolean delete(String code){
        PreparedStatement pr=null;
        String query="DELETE FROM stocks WHERE code = ?";
        try {
            pr=DBConnection.getConnection().prepareStatement(query);
            pr.setString(1,code);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pr.close();
            } catch (SQLException e) {
                Help.showMsg("err");
            }
        }
        return true;
    }

    public static boolean update(Stock stock){
        PreparedStatement pr=null;
        String query="UPDATE stocks SET name=?, type=?, unit=?, barcode=?, varType=?, description=?, createdTime=? WHERE code=?";
        try {
            pr=DBConnection.getConnection().prepareStatement(query);
            pr.setString(1,stock.getName());
            pr.setInt(2,stock.getType());
            pr.setString(3,stock.getUnit());
            pr.setString(4,stock.getBarcode());
            pr.setDouble(5,stock.getVarType());
            pr.setString(6,stock.getDescription());
            pr.setString(7,stock.getCreatedDate());
            pr.setString(8,stock.getCode());
            int control=pr.executeUpdate();
            return control!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
