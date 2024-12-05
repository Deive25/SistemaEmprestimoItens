package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author laboratorio
 */
public class Conexao {

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoEmprestimo?useTimezone=true&serverTimezone=UTC", "root", "laboratorio");
            System.out.println("Conexao realizada com sucesso!");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar no BD" + e.getMessage());
            return null;
        }
    }
}
