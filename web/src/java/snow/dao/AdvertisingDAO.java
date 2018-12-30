/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.dao;

import snow.connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import snow.model.Advertising;

/**
 *
 * @author huyla
 */
public class AdvertisingDAO {
    public ArrayList<Advertising> getListAds(int amount) throws SQLException{
        Connection connection   = DBConnect.getConnection();
        String query            = "SELECT *,rand() AS `random` FROM `quangcao` WHERE `visiable` = 1"
                            + " ORDER BY `random` LIMIT 0,?";
        PreparedStatement ps    = connection.prepareStatement(query);
        ps.setInt(1, amount);
        ResultSet result        = ps.executeQuery();
        ArrayList<Advertising> list = new ArrayList<>();
        
        while(result.next()){
            Advertising ads = new Advertising();
            ads.setAdsID(result.getInt("id_quangcao"));
            ads.setAdsTitle(result.getString("tieude"));
            ads.setAdsFile(result.getString("taptin"));
            ads.setAdsURL(result.getString("url"));
            ads.setAdsTarget(result.getString("target"));
            list.add(ads);
        }
        return list;
    }
}
