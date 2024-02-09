package com.techpalle.jdbc;

import java.sql.*;

public class DepartmentServices {
private static Connection cn=null;
private static Statement stm=null;
private static PreparedStatement ps=null;
private static ResultSet rs=null;
public static Connection myConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "angshuk123");
	  return cn;
}

/*public static void creating() {
	try {
		cn=myConnection();
		String qry="create table employee(eno int primary key auto_increment,ename varchar(40),email varchar(40))";
		stm=cn.createStatement();
		stm.executeUpdate(qry);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(stm!=null) {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}*/
/*public static void inserting(String name,String email) {
	try {
		cn=myConnection();
		String qry="insert into employee(ename,email)values(?,?)";
		ps=cn.prepareStatement(qry);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}*/
public static void reading(int no) {
	try {
		cn=myConnection();
		String qry="select * from employee where eno=?";
		ps=cn.prepareStatement(qry);
		ps.setInt(1, no);
		rs=ps.executeQuery();
		rs.next();
		System.out.println(rs.getInt("eno"));
		System.out.println(rs.getString("ename"));
		System.out.println(rs.getString("email"));
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
public static void updating(String name,String email,int eno) {
	try {
		cn=myConnection();
		String qry="update employee set ename=?,email=? where eno=?";
		ps=cn.prepareStatement(qry);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, eno);
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
public static void deleting(int no) {
	try {
		cn=myConnection();
		String qry="delete from employee where eno=?";
		ps=cn.prepareStatement(qry);
		ps.setInt(1, no);
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

}
