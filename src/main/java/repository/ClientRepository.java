package repository;

import database.DatabaseConnection;
import dto.request.ClientRequest;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@ApplicationScoped
public class ClientRepository {
    public String createClient(ClientRequest request){
        String createClient = "INSERT INTO Clients(tel_number, operator_code, tag, time_zone) VALUES (?,?,?,?)";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.
                    prepareStatement(createClient)) {
                preparedStatement.setString(1, request.getTelNumber());
                preparedStatement.setString(2, request.getOperatorCode());
                preparedStatement.setString(3, request.getTag());
                preparedStatement.setString(4, request.getTimeZone().toString());
                preparedStatement.execute();

                return "Client has added successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateClient(int id, ClientRequest request){
        String updateSql = "UPDATE clients SET tel_number = ?, operator_code = ?, tag = ?, time_zone = ? WHERE id = ?";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
                preparedStatement.setString(1, request.getTelNumber());
                preparedStatement.setString(2, request.getOperatorCode());
                preparedStatement.setString(3, request.getTag());
                preparedStatement.setString(4, request.getTimeZone());
                preparedStatement.setInt(5, id);

                preparedStatement.execute();

                return "Client has updated successfully";
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }

    }

    public String deleteClient(int id){
        String deleteSql = "DELETE FROM clients WHERE id = ?";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();

                return "Client has deleted successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
