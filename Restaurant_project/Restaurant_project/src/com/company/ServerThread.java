package com.company;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject())!=null) {

                if (pd.getOperationType().equals("Add_Food")) {
                    try {
                        Foods foods = pd.getFood();
                        addFoodsToDb(foods);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_Orders")){
                    try {
                        Orders orders= pd.getOrders().get(0);
                        addOrdersToDb(orders);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Foods")){
                    ArrayList<Foods> foods = getFoods();
                    PackageData resp = new PackageData();
                    resp.setFoods(foods);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List_Buyers")) {
                    ArrayList<BuyerData> buyers = getAllBuyers();
                    PackageData resp = new PackageData();
                    resp.setBuyers(buyers);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List_Admins")){
                    ArrayList<AdminData> admins = getAllAdmins();
                    PackageData resp = new PackageData();
                    resp.setAdmins(admins);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("Add_Buyer")) {
                    try {
                        BuyerData buyer = pd.getBuyer();
                        addBuyer(buyer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (pd.getOperationType().equals("Add_Admin")) {
                    try {
                        AdminData admin = pd.getAdmin();
                        addAdmin(admin);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Orders")){
                    ArrayList<Orders>orders=getOrders();
                    PackageData pd2=new PackageData();
                    pd2.setOrders(orders);
                    outputStream.writeObject(pd2);
                }
                else if(pd.getOperationType().equals("Delete_Foods")){
                    Long id=pd.getId();
                    deleteFoodsToDB(id);
                }
                else{
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFoodsToDb(Foods foods) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into foods(id,kindoffood,name,price) values(null,?,?,?)");

            ps.setString(1,foods.getKindoffood());
            ps.setString(2,foods.getName());
            ps.setInt(3,foods.getPrice());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addBuyer(BuyerData buyer) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO buyerdata (login, password,address,telephoneNumber,id) VALUES(?,?,?,?,NULL)");
            pse.setString(1, buyer.getLogin());
            pse.setString(2, buyer.getPassword());
            pse.setString(3, buyer.getAddress());
            pse.setString(4, buyer.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addAdmin(AdminData admin) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO admindata (login, password,address,telephoneNumber,id) VALUES(?,?,?,?,NULL)");
            pse.setString(1, admin.getLogin());
            pse.setString(2, admin.getPassword());
            pse.setString(3, admin.getAddress());
            pse.setString(4, admin.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BuyerData> getAllBuyers() {
        ArrayList<BuyerData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from buyerdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BuyerData(rs.getString("login"), rs.getString("password"), rs.getString("address"), rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<AdminData> getAllAdmins() {
        ArrayList<AdminData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from admindata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new AdminData(rs.getString("login"), rs.getString("password"), rs.getString("address"), rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public  void addOrdersToDb(Orders orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into orders(id,foodsId,name,surname,passwordNumber) values(null,?,?,?,?)");

            ps.setInt(1,orders.getFoodsId());
            ps.setString(2,orders.getName());
            ps.setString(3,orders.getSurname());
            ps.setString(4,orders.getPasswordNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Foods> getFoods() {
        ArrayList<Foods> foods = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM foods";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                foods.add(new Foods(res.getLong("id"), res.getString("kindoffood"),res.getString("name"),res.getInt("price")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }
    public ArrayList<Orders> getOrders() {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                orders.add(new Orders(res.getLong("id"), res.getInt("foodsId"), res.getString("name"), res.getString("surname"),res.getString("passwordNumber")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }



    public void deleteFoodsToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM foods WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
