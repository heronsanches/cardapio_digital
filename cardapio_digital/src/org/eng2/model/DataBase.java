package org.eng2.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	private Connection connection;
	
	private static DataBase db = null;
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost/cardapio_digital";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	// for create schema and tables
	public static final String DB_NAME = "cardapio_digital";

	private DataBase() {
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(url, user, password);
		 } catch (Exception e) {
		      System.out.println("err in get connection: class DataBase.java");
		 }
	}
	
	public static Connection getConnectionDB() throws Exception {
		if (db == null)
			db = new DataBase();

		return db.connection;
	}

}
