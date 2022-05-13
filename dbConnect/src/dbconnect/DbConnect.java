package dbconnect;

import java.sql.*;

public class DbConnect {

    public static void main(String[] args) throws Exception {
        
        //MySQL Connection
        
        // Carregar o driver do MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Iniciar a conexão com o servidor
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/smallrelations", "gofs", "1234");
        
        // Criar um statement
        Statement stmt = con.createStatement();
        
        // Executar a query
        ResultSet rs = stmt.executeQuery("select * from instructor");
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        
        // Fechar a conexão
        con.close();
        stmt.close();
        
        //PostgreSQL Connection
        
        // Carregar o driver do Postgres
        Class.forName("org.postgresql.Driver");
        
        // Iniciar a conexão com o servidor
        String url = "jdbc:postgresql://:5432/?user=&password=";
        Connection conn = DriverManager.getConnection(url);
        
        //Criar um statement
        Statement st = conn.createStatement();
        
        // Iniciar a conexão com o servidor
        ResultSet rss = st.executeQuery("SELECT * FROM mytable WHERE columnfoo = 500");
        while (rss.next())
        {
            System.out.print("Column 1 returned ");
            System.out.println(rss.getString(1));
        }
        
        // Fechar a conexão
        rss.close();
        st.close();   
    }
    
}
