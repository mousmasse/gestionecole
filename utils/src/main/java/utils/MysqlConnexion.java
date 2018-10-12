/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class MysqlConnection
 * @author Moustapha M. NDIAYE
 * @version 1.0-SNAPSHOT
 * @since 30/05/2018 
 */

public class MysqlConnexion {

	private static  String url="jdbc:mysql://localhost/gestionscolaire?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userBd = "root";
	private static String pwdBd = "Bouchra#05";
	private static Connection connexion = null;

	/**
	 * Constructeur privé pour entraver la création d'instance de la classe
	 */
	private MysqlConnexion() {
		super();
	}

	public static Connection getInstanceConnexion() {

		if (connexion==null) {

			try {
				connexion = DriverManager.getConnection(url, userBd, pwdBd);
				System.out.println("Connexion établie avec la base.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Echéque de la tentative de connexion avec la base");
			}

		}

		return connexion;

	}


}
