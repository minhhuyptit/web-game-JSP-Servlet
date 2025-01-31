/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import snow.connect.DBConnect;
import snow.model.Game;

/**
 *
 * @author huyla
 */
public class GameDAO {

    private ArrayList<Integer> listGameHot = new ArrayList<>();
    private ArrayList<Integer> listGameChoiNhieuNhat = new ArrayList<>();
    private ArrayList<Integer> listGameYeuThichNhat = new ArrayList<>();

    private ArrayList<Integer> listGameHotByCategory = new ArrayList<>();
    private ArrayList<Integer> listGameYeuThichNhatByCategory = new ArrayList<>();

    private ArrayList<Integer> listGameChoiNhieuNhatByIDGame = new ArrayList<>();

    public ArrayList<Game> getListGameHot() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `game` "
                + "WHERE `hot` = 1 AND `kiemduyet` = 1"
                + " ORDER BY `luotchoi` DESC LIMIT 0,11";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameHot.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameChoiNhieuNhat() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `game` "
                + "WHERE `kiemduyet` = 1 AND `id_game` NOT IN (" + arrayID(listGameHot) + ")"
                + " ORDER BY `luotchoi` DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameChoiNhieuNhat.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameYeuThichNhat() throws SQLException {
        Connection connection = DBConnect.getConnection();
        String arrayID = arrayID(listGameHot) + "," + arrayID(listGameChoiNhieuNhat);
        String query = "SELECT *FROM `game` "
                + "WHERE `kiemduyet` = 1 AND `id_game` NOT IN (" + arrayID + ")"
                + " ORDER BY `luotyeuthich` DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameYeuThichNhat.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameDetail(int id_theloai) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String arrayID = arrayID(listGameHot) + "," + arrayID(listGameChoiNhieuNhat) + "," + arrayID(listGameYeuThichNhat);
        String query = "SELECT *FROM `game` "
                + "WHERE `kiemduyet` = 1 AND `id_game` NOT IN (" + arrayID + ") AND `id_theloai`=?"
                + " ORDER BY `luotchoi` DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_theloai);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameHotByCategory(int id_theloai) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `game` "
                + "WHERE `hot` = 1 AND `kiemduyet` = 1 AND `id_theloai`=?"
                + " ORDER BY `luotchoi` DESC LIMIT 0,11";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_theloai);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameHotByCategory.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameYeuThichNhatByCategory(int id_theloai) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `game` "
                + "WHERE `kiemduyet` = 1 AND `id_game` NOT IN (" + arrayID(listGameHotByCategory) + ") AND `id_theloai`=?"
                + " ORDER BY `luotyeuthich` DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_theloai);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameYeuThichNhatByCategory.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public int countGameByCategory(int id_theloai) throws SQLException {
        int soluong = 0;
        Connection connection = DBConnect.getConnection();
        String query = "SELECT COUNT(id_game) AS 'soluong' FROM `game` WHERE `id_theloai`=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_theloai);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            soluong = Integer.parseInt(result.getString("soluong"));
            DBConnect.closeConnection(connection);
        }
        return soluong;
    }

    public ArrayList<Game> getListGameByCategoryAndPage(int id_theloai, int currentPage, int itemPerPage) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String arrayID = arrayID(listGameHotByCategory) + "," + arrayID(listGameYeuThichNhatByCategory);
        int position = (currentPage - 1) * itemPerPage;
        String query = "SELECT *FROM `game` "
                + "WHERE `kiemduyet` = 1 AND `id_game` NOT IN (" + arrayID + ") AND `id_theloai`= ?"
                + " ORDER BY `luotyeuthich` DESC LIMIT ?,?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_theloai);
        ps.setInt(2, position);
        ps.setInt(3, itemPerPage);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameYeuThichNhat.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public Game getGame(int id_game) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM game WHERE id_game=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_game);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            DBConnect.closeConnection(connection);
            return game;
        }
        DBConnect.closeConnection(connection);
        return null;
    }

    public ArrayList<Game> getListGameChoiNhieuNhatByIDGame(int id_game) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM game AS g1"
                + " WHERE g1.id_theloai = (SELECT g2.id_theloai FROM game AS g2"
                + " WHERE g2.id_game = ?)"
                + " AND g1.id_game != ?"
                + " ORDER BY g1.luotchoi DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareCall(query);
        ps.setInt(1, id_game);
        ps.setInt(2, id_game);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();

        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameChoiNhieuNhatByIDGame.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameYeuThichNhatByIDGame(int id_game) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM game AS g1"
                + " WHERE g1.id_theloai = (SELECT g2.id_theloai FROM game AS g2"
                + " WHERE g2.id_game = ?)"
                + " AND g1.id_game != ? AND g1.id_game NOT IN(" + arrayID(listGameChoiNhieuNhatByIDGame) + ")"
                + " ORDER BY g1.luotyeuthich DESC LIMIT 0,8";
        PreparedStatement ps = connection.prepareCall(query);
        ps.setInt(1, id_game);
        ps.setInt(2, id_game);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();

        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
            listGameChoiNhieuNhatByIDGame.add(game.getGameID());
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public ArrayList<Game> getListGameByIDGame(int id_game, int position, int item) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM game AS g1"
                + " WHERE g1.id_theloai = (SELECT g2.id_theloai FROM game AS g2"
                + " WHERE g2.id_game = ?)"
                + " AND g1.id_game != ?"
                + " LIMIT ?,?";
        PreparedStatement ps = connection.prepareCall(query);
        ps.setInt(1, id_game);
        ps.setInt(2, id_game);
        ps.setInt(3, position);
        ps.setInt(4, item);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();

        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);
            list.add(game);
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    public void updateLuotChoi(int id_game) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "UPDATE game SET luotchoi=luotchoi+1 WHERE id_game=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_game);
        ps.executeUpdate();
        DBConnect.closeConnection(connection);
    }

    public void updateLuotYeuThich(int id_game, boolean increment) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query;
        if (increment) {
            query = "UPDATE game SET luotyeuthich=luotyeuthich+1 WHERE id_game=?";
        } else {
            query = "UPDATE game SET luotyeuthich=luotyeuthich-1 WHERE id_game=?";
        }
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_game);
        ps.executeUpdate();
        DBConnect.closeConnection(connection);
    }

    public int getLuotYeuThich(int id_game) throws SQLException {
        int luotyeuthich = 0;
        Connection connection = DBConnect.getConnection();
        String query = "SELECT luotyeuthich FROM game WHERE id_game=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_game);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            luotyeuthich = result.getInt("luotyeuthich");
        }
        DBConnect.closeConnection(connection);
        return luotyeuthich;
    }

    public String getNamCategory(int id_game) throws SQLException {
        String name = "";
        Connection connection = DBConnect.getConnection();
        String query = "SELECT tlg.tentheloai FROM game AS g, theloaigame AS tlg"
                + " WHERE g.id_game=? AND g.id_theloai = tlg.id_theloai";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id_game);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            name = result.getString("tentheloai");
        }
        DBConnect.closeConnection(connection);
        return name;
    }
    
    public ArrayList<Game> getListGameSearch(String keyword, int position , int item) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM game WHERE tengame LIKE ? LIMIT ?,?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%");
        ps.setInt(2, position);    
        ps.setInt(3, item);
        ResultSet result = ps.executeQuery();
        ArrayList<Game> list = new ArrayList<>();
        while (result.next()) {
            Game game = new Game();
            game.setGameID(result.getInt("id_game"));
            game.setGameName(result.getString("tengame"));
            game.setGameImage(result.getString("hinhgame"));
            game.setGameFile(result.getString("taptingame"));
            game.setGameContent(result.getString("noidunggame"));
            game.setGameLuotChoi(result.getLong("luotchoi"));
            game.setGameLuotYeuThich(result.getLong("luotyeuthich"));
            boolean gameHot = (result.getByte("hot") != 0);
            game.setGameHot(gameHot);   
            list.add(game);
        }
        DBConnect.closeConnection(connection);
        return list;
    }

    private String arrayID(ArrayList<Integer> array) {
        String str = "";
        if (!array.isEmpty()) {
            for (Integer integer : array) {
                str += integer.toString() + ",";
            }
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void main(String[] args) throws SQLException {
        GameDAO gameDAO = new GameDAO();
//        for (Game item : gameDAO.getListGameHot()) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
//        }
//        
//        System.out.println("Ngắt");
//        for (Game item : gameDAO.getListGameChoiNhieuNhat()) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
//        }
//        
//        System.out.println("Ngắt");
//        for (Game item : gameDAO.getListGameYeuThichNhat()) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotYeuThich());
//        }

//        for (Game item : gameDAO.getListGameHotByCategory(1)) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
//        }
//
//        System.out.println("Ngắt");
//        for (Game item : gameDAO.getListGameYeuThichNhatByCategory(1)) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
//        }
//
//        System.out.println("Ngắt");
//        for (Game item : gameDAO.getListGameByCategoryAndPage(1, 2, 16)) {
//            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
//        }
        System.out.println("Ngắt");
        for (Game item : gameDAO.getListGameChoiNhieuNhatByIDGame(4)) {
            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
        }

        System.out.println("Ngắt");
        for (Game item : gameDAO.getListGameYeuThichNhatByIDGame(4)) {
            System.out.println(item.getGameID() + " " + item.getGameName() + " " + item.getGameLuotChoi());
        }
    }
}
