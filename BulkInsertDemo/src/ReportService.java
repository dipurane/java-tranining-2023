import java.util.List;

public interface ReportService {

	
	public void saveReportData(ReportDTO dto);
	
	public void saveReportsDataInBatch(List<ReportDTO> reportDTOList);
	
}
