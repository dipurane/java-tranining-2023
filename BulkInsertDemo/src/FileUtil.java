import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileUtil {

	
	public List<ReportDTO> readFromFile() {
		File f = new File("/Users/synerzip/Documents/bulkdata/report.csv");
		List<ReportDTO> dtoList = new ArrayList<ReportDTO>();
		try {
		FileReader reader = new FileReader(f);
		BufferedReader buff = new BufferedReader(reader);
		String line = buff.readLine();
		while(line!=null) {
			
			line = buff.readLine();
			if(line!=null) {
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			int cnt = 0;
			StringBuffer buffer = new StringBuffer();
			ReportDTO  dto = new ReportDTO();
			while(tokenizer.hasMoreElements()) {
				cnt++;
				String value = tokenizer.nextToken();
				if(cnt==6) {
					buffer.append(value);
					 dto.setVariableCode(value);
				}
				
				if(cnt==7) {
					buffer.append(value);
					dto.setVariableName(value);
				}
				if(cnt==8) {
					
					dto.setCategory(value);
					buffer.append(value);
				}
				if(cnt==9) {
					buffer.append(value);
					dto.setValue(value);
				}
				
				
			}
			dtoList.add(dto);
			System.out.println(buffer);
			}
		}
		
		//System.out.println(line);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
}
