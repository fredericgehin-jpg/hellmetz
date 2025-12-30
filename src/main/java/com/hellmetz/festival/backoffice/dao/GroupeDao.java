package com.hellmetz.festival.backoffice.dao;

import com.hellmetz.festival.backoffice.model.Groupe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupeDao {

    public List<Groupe> findAll() {
        List<Groupe> result = new ArrayList<>();

        String sql = "SELECT id_groupe, nom, style, pays, description, site_web, image_url FROM groupe ORDER BY nom";

        try (Connection cn = ConnectionFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Groupe g = new Groupe();
                g.setId(rs.getInt("id_groupe"));
                g.setNom(rs.getString("nom"));
                g.setStyle(rs.getString("style"));
                g.setPays(rs.getString("pays"));
                g.setDescription(rs.getString("description"));
                g.setSiteWeb(rs.getString("site_web"));
                g.setImageUrl(rs.getString("image_url"));

                result.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // pour les SIO1, on se contente de ça
        }

        return result;
    }

    // On ajoutera ensuite : findById, insert, update, delete
}
