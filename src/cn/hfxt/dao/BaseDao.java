package cn.hfxt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.hfxt.entity.UserMenu;

public class BaseDao {
	public Connection conn=null;
	public PreparedStatement pre=null;
	public ResultSet rs=null;
	int num=0;
	
	//ʹ��DbUtils�������ݿ�
    private QueryRunner queryRunner = new QueryRunner();
	private ResourceBundle reb=ResourceBundle.getBundle("database");
	
	String driver=reb.getString("driver");
	String url=reb.getString("url");
	String user=reb.getString("user");
	String password=reb.getString("password");
	
	//�����������������ݿ�
	public Connection getConnection(){
		if(conn==null){
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	//�ر�����,���ú�أ������ȹ�
	public void CloseAll(Connection conn,PreparedStatement pre,ResultSet rs){
		try {
			if(rs!=null){rs.close();}
			if(pre!=null){pre.close();}
			if(conn!=null){conn.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ɾ�Ĳ���
	public int Operaction(String sql,Object... x){
		conn=getConnection();
		try {
			pre=conn.prepareStatement(sql);
			if(pre!=null){
				for (int i = 0; i < x.length; i++) {
					pre.setObject(i+1, x[i]);
				}
				num=pre.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	/**
     * ��ѯ����һ��javaBean��sql���
     *
     * @param type ���صĶ�������
     * @param sql  ִ�е�sql���
     * @param args sql��Ӧ�Ĳ���ֵ
     * @param <T>  ���ص����͵ķ���
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
	
	public int getTotalCount(String sql) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int num=0;
		
		try {
			connection=this.getConnection();
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//this.CloseAll(connection, pstmt, rs);
		}
		return num;
	}
	
	
	public boolean existColumn(ResultSet rs,String columnName){
		boolean result = false;
		try {
			if(rs.findColumn(columnName) > 0){
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}

	public int addFen(UserMenu menu) {
		// TODO Auto-generated method stub
		return 0;
	}
}
