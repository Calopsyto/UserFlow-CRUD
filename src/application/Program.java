package application;

import db.DB;
import db.DbException;
import model.entities.User;
import model.impl.UserDaoJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try {
            Connection connection = DB.getConnection();
            connection.setAutoCommit(false);
            Scanner sc = new Scanner(System.in);
            UserDaoJDBC userDaoJDBC = new UserDaoJDBC(connection);

            String menu = """
        ================================
               SISTEMA CRUD
        ================================
        
        [1] - Cadastrar
        [2] - Listar
        [3] - Atualizar
        [4] - Deletar
        [0] - Sair
        
        ================================
        Escolha uma opção: """;

            System.out.print(menu);
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): " );
                    String birthDate = sc.nextLine();
                    System.out.print("Idade: ");
                    int age = sc.nextInt();

                    User user = new User(name, email, birthDate, age);

                    userDaoJDBC.insert(user);
                    break;

                case 2:
                    System.out.print("Listando: ");
                    String idString = sc.nextLine();
                    List<User> userList = new ArrayList<>();

                    if (idString.isEmpty()) {
                        userList = userDaoJDBC.findAll();
                        System.out.println(userList.toString());
                    } else {
                        User userFind = userDaoJDBC.findById(Integer.parseInt(idString));
                        System.out.println(userFind.toString());
                    }
                    break;
                case 3:
                    System.out.println("Atualizando");
                    System.out.print("Id: ");
                    int idUpate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nameUpdate = sc.nextLine();
                    System.out.print("Email: ");
                    String emailUpdate = sc.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): " );
                    String birthDateUpdate = sc.nextLine();
                    System.out.print("Idade: ");
                    int ageUpdate = sc.nextInt();
                    sc.nextLine();

                    User userUpdate = new User(nameUpdate, emailUpdate, birthDateUpdate, ageUpdate);

                    userDaoJDBC.update(userUpdate, idUpate);
                    break;

                case 4:
                    System.out.println("Deletar");
                    System.out.print("Id: ");
                    int idDelete = sc.nextInt();

                    userDaoJDBC.deleteById(idDelete);
                    break;

                case 0:
                    System.out.print("Saindo...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.exit(0);


            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}
