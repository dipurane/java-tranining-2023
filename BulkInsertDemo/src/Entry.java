import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Entry {

	public static void main(String[] args) {
		FileUtil util = new FileUtil();
		
		ReportService reportService = new ReportServiceImpl();
		  List<ReportDTO> dtoList = util.readFromFile();
		 System.out.println("The records read from files are " + dtoList.size());
		System.out.println("Start time is "+ System.currentTimeMillis());
		/*for (ReportDTO reportDTO : dtoList) {
			 reportService.saveReportData(reportDTO);
		}*/
		
		//reportService.saveReportsDataInBatch(dtoList);
		
		int batchSize = 1000;
		List<ReportDTO> batchList = null;
		int recordCount =0;
		int mark =0;
		int cnt = 0;
		int startPoint = 0;
		List<ReportSaveTask> taskList = new ArrayList<ReportSaveTask>();
		while (recordCount<= dtoList.size()) {
			batchList = dtoList.subList(startPoint, mark);
			cnt++;
			startPoint = mark;
			mark=mark+batchSize;
			ReportSaveTask task = new ReportSaveTask(reportService, batchList);
			taskList.add(task);
			recordCount+=batchSize;
		}
		batchList = dtoList.subList((cnt-1)*batchSize,dtoList.size()-1 );
		ReportSaveTask task = new ReportSaveTask(reportService, batchList);
		taskList.add(task);
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (ReportSaveTask reportSaveTask : taskList) {
			service.submit(reportSaveTask);
		}
		
		 System.out.println("Finished Loading time is "+ System.currentTimeMillis());
	}
}
