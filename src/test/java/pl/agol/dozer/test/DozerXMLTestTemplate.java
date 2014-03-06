package pl.agol.dozer.test;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.testng.annotations.BeforeClass;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public abstract class DozerXMLTestTemplate {

	private String mappingFile;
	protected DozerBeanMapper mapper;

	public DozerXMLTestTemplate(String mappingFile) {
		this.mappingFile = mappingFile;
	}


	@BeforeClass
	public void setup() {
		List<String> files = new ArrayList<String>();
		files.add(mappingFile);
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(files);
	}

}
