import java.util.List;

public class ReportSaveTask implements Runnable{

	private ReportService reportService;
	private List<ReportDTO> reportDTOList;
	
	public ReportService getReportService() {
		return reportService;
	}
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	public List<ReportDTO> getReportDTOList() {
		return reportDTOList;
	}
	public void setReportDTOList(List<ReportDTO> reportDTOList) {
		this.reportDTOList = reportDTOList;
	}
	public ReportSaveTask(ReportService reportService, List<ReportDTO> reportDTOList) {
		
		this.reportService = reportService;
		this.reportDTOList = reportDTOList;
	}
	@Override
	public void run() {

		reportService.saveReportsDataInBatch(reportDTOList);
	}

}
