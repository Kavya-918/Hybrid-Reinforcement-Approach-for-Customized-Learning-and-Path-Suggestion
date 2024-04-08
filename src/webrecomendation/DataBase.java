package webrecomendation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DataBase
{
	public Connection mCon;
	private static Properties mProps;

	/**
	 * @return the props
	 */
	public Properties getProperties()
	{
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps)
	{
		mProps = aProps;
	}

	public Connection getConnection()
	{
		try
		{
			//Properties aProps = getProperties();
			//System.out.println(aProps.getProperty("driver"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			mCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","topkp","topkp");
                        //			System.out.println(mCon);
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (SQLException  ex)
		{
			ex.printStackTrace();
		}
		return mCon;
	}

/*	public Connection getConnection(String cp)
	{
		try
		{
			Properties aProps = getProperties();
			Class.forName( aProps.getProperty("driver") );
			
			String JNDI = aProps.getProperty("JNDI_NAME");
			
			try
			{
				InitialContext ictx = new InitialContext();
				DataSource ds = (DataSource) ictx.lookup(JNDI);
				mCon = ds.getConnection();
			}
			catch (NamingException ne)
			{
				LoggerManager.writeLogWarning(ne);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			LoggerManager.writeLogWarning(cnfe);
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
		}
		return mCon;
	}*/
	
	public int getSequenceID(String tableName, String pkid)
	{
		int id = 0;
		try
		{
			mCon = getConnection();
			Statement st = mCon.createStatement();
			ResultSet rs = st.executeQuery("select max("+pkid+") from "+tableName); 
			if(rs.next())
				id=rs.getInt(1);
			id++;
		}
		catch(SQLException  ex)
		{
			ex.printStackTrace();
		}
		catch(Exception  ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				mCon.close();
			}
			catch(SQLException  ex)
		{
			ex.printStackTrace();
			}
			catch(Exception  ex)
		{
			ex.printStackTrace();
			}
		}
		return id;
	}
}
