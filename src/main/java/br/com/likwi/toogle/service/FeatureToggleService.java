package br.com.likwi.toogle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class FeatureToggleService {

    private final DataSource dataSource;

    @Autowired
    public FeatureToggleService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getVehicleType() {
        String query = "SELECT propriedade FROM veiculo LIMIT 1";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("propriedade");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }
}
