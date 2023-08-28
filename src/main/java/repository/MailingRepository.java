package repository;

import database.DatabaseConnection;
import dto.request.MailingListRequest;
import dto.request.Request;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@ApplicationScoped
public class MailingRepository {
    public String createMailingList(MailingListRequest request){
        String createSql = "INSERT INTO Mailing_list(start_time, message_text, filter_send, end_time) VALUES(?,?,?,?)";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.
                    prepareStatement(createSql)) {
                preparedStatement.setTimestamp(1, Timestamp.valueOf(request.getStartTime()));
                preparedStatement.setString(2, request.getMessageText());
                preparedStatement.setString(3, request.getFilterSend());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(request.getEndTime()));
                preparedStatement.execute();

                return "Mailing list has added successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String updateMailingList(int id, MailingListRequest request){
        String updateSql = "UPDATE mailing_list SET start_time = ?, message_text = ?, filter_send = ?, end_time = ? WHERE id = ?";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
                preparedStatement.setTimestamp(1, Timestamp.valueOf(request.getStartTime()));
                preparedStatement.setString(2, request.getMessageText());
                preparedStatement.setString(3, request.getFilterSend());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(request.getEndTime()));
                preparedStatement.setInt(5, id);

                preparedStatement.execute();

                return "Mailing list has updated successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteMailingList(int id){
        String deleteSql = "DELETE FROM mailing_list WHERE id = ?";

        try(Connection connection = DatabaseConnection.getMailerConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();

                return "Mailing list has deleted successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
