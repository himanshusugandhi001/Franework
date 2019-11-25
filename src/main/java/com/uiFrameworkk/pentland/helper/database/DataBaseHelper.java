package com.uiFrameworkk.pentland.helper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;

public class DataBaseHelper {

	private static Logger log = LoggerHelper.getLogger(DataBaseHelper.class);
	private static String url = "";
	private static String driverName = "";
	private static String userName = "";
	private static String password = "";
	private static Connection connection;
	private static DataBaseHelper instance = null;

	public DataBaseHelper() {
		connection = getSingleInstanceConnection();
	}

	public static DataBaseHelper getInstance() {
		if (instance == null) {
			instance = new DataBaseHelper();
		}
		return instance;
	}

	private Connection getSingleInstanceConnection() {
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, userName, password);
				if (connection != null) {
					log.info("Connected to database..");
				}
			} catch (SQLException e) {
				log.error("Failed to Create database Connection..." + e);

			}
		} catch (ClassNotFoundException e) {
			log.info("Driver not Found.." + e);
		}
		return connection;
	}

	public Connection getConnection() {
		return connection;

	}

	public static ResultSet getResultSet(String dbQuery) {
		instance = DataBaseHelper.getInstance();
		connection = instance.getConnection();
		log.info("Executing query" + dbQuery);
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(dbQuery);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
