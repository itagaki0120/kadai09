package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.BoardBean;

public class BoardDao {
	private static final String url = "jdbc:mysql://localhost:3306/thread?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "itagakidaiki";
	public static ArrayList<BoardBean> selectAll(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT id,name,message,createday,createtime,updateday,updatetime FROM Board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<BoardBean> list = new ArrayList<BoardBean>();
			while( rs.next() ){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String message = rs.getString("message");
				String createday = rs.getString("createday");
				String createtime = rs.getString("createtime");
				String updateday = rs.getString("updateday");
				String updatetime = rs.getString("updatetime");
				BoardBean result = new BoardBean(id,name, message,createday,createtime,updateday,updatetime);
				list.add(result);
			}

			if(list.size()!=0&&list.get(list.size()-1).getId()==999){
				insertFinal();
			}
			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void insertFinal(){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "insert into Board(id,name,message,mail,createday,createtime,updateday,updatetime) values(1000,?,?,now(),now(),now(),now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "管理者");
			pstmt.setString(2, "投稿数が999を超えました。これ以上打つことはできません。");
			int result = pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");
		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void insert(BoardBean s){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "insert into Board(name,message,mail,createday,createtime,updateday,updatetime) values(?,?,?,now(),now(),now(),now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMessage());
			pstmt.setString(3, s.getMail());
			int result = pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");
		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void delete(int no){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FROM Board WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			System.out.println(result + "件削除されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void update(BoardBean s){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "UPDATE Board SET name = ?,message = ?,updateday=now(),updatetime=now() WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMessage());
			pstmt.setInt(3, s.getId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "件更新されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}
