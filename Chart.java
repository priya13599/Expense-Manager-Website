package Servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 * Servlet implementation class Chart
 */
public class Chart {
	

	  private static JDBCCategoryDataset dataset;
	   
	   public static void main(String[] args) throws IOException, SQLException{
		   
		   Connection con= null;
		   try
		   {
			   
			   
			   con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","priya","priya");
			   dataset= new JDBCCategoryDataset(con);
			   dataset.executeQuery("select amount,category from addexpense where EMAIL ='sanjeev.arya99@gmail.com'");
			   
		   }
		   finally
		   {
			   if(con!=null)
			   {
				   con.close();
			   }
		   }
		   
		   JFreeChart barchart = ChartFactory.createBarChart("Category-Amount Chart","", "Category", dataset,PlotOrientation.VERTICAL,false,true,false);
		   ChartUtilities.saveChartAsPNG(new File("image/png"), barchart, 450, 400);
	   }


}
