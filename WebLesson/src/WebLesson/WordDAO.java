package WebLesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class WordDAO {

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public WordDAO(){}


	public int registWords(List<Word> list){// (引数にWord型のArraylistをセット) {
		int result = 0;

		Word word = new Word();
		int index = 0;

		try {
			// DB接続の記述

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8","root","");

			if(con != null){
				System.out.println("DB接続完了 (getConnection後) \r\n----");
			}else{
				System.out.println("DB接続失敗\r\n");
			}


			// ここに日本語と英単語を登録する文

			while(index < list.size()) {

				String SQL ="INSERT INTO dectionary (english, japanese) values (?, ?)";
//				stmt= con.createStatement();

				word = list.get(index);


				stmt = con.prepareStatement(SQL);
				stmt.setString(1, word.getEnglish());// 氏名
				stmt.setString(2, word.getJapanese());// 性別

//				ResultSet rs = stmt.executeQuery(SQL);

				stmt.executeUpdate();

				index++;
			}


		} catch (Exception e) {
			System.out.println("SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if ( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result + 1;	// 結果を返す
	}

	public List<Word> getWords(){

		ArrayList<Word> WordA = new ArrayList<Word>();

		try{

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","");

			if(con != null){
				System.out.println("DB接続完了 (getConnection後) \r\n----");
			}else{
				System.out.println("DB接続失敗\r\n");
			}

//			@SuppressWarnings("resource")
//			int userId = new Scanner(System.in).nextInt();
//			String SQL = "SELECT * FROM users WHERE user_id= "+userId;

			String SQL ="SELECT * FROM dectionary";
//			stmt= con.createStatement(); WHERE user_id =?

			stmt = con.prepareStatement(SQL);
//			stmt.setInt(1,userId);

//			ResultSet rs = stmt.executeQuery(SQL);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				String english = rs.getString("english");
				String japanese = rs.getString("japanese");
//				System.out.println("英語:" + english + "  日本語:"+ japanese);
				WordA.add(new Word(english,japanese));

			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{

			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}

			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			System.out.println("\n\n正常切断完了");
		}


		return WordA;

	}
}