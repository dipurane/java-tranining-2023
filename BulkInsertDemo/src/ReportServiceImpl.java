import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ReportServiceImpl implements ReportService{

	@Override
	public void saveReportData(ReportDTO dto) {

			DBHelper helper = DBHelper.getInstance();
			Connection c = helper.getConnection();
			try {
			PreparedStatement ps = c.prepareStatement("insert into emp_db.report_table (variable_code, variable_name, category, value) values(?,?,?,?)");
			ps.setString(1, dto.getVariableCode());
			ps.setString(2, dto.getVariableName());
			ps.setString(3, dto.getCategory());
			ps.setString(4, dto.getValue());
			ps.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
				c.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public void saveReportsDataInBatch(List<ReportDTO> reportDTOList) {

		DBHelper helper = DBHelper.getInstance();
		Connection c = helper.getConnection();
		int batchSize = 30;
		int cnt =0;
		try {
		
			c.setAutoCommit(false);	
		PreparedStatement ps = c.prepareStatement("insert into emp_db.report_table (variable_code, variable_name, category, value) values(?,?,?,?)");
		
		for (ReportDTO dto : reportDTOList) {
		
		cnt++;	
		ps.setString(1, dto.getVariableCode());
		ps.setString(2, dto.getVariableName());
		ps.setString(3, dto.getCategory());
		ps.setString(4, dto.getValue());
		ps.addBatch();
		if(cnt%30==0) {
			
			ps.executeBatch();
			c.commit();
			
		}
			
		
		}
		ps.executeBatch();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			c.commit();
			c.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	

}
