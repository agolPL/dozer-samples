package pl.agol.dozer.test.entity;

import pl.agol.dozer.test.MegaAdvanceMappingTest.Mapper;

/**
 * 
 * @author Andrzej Goławski
 * 
 */
public class Mtu {

	@Mapper("name")
	private String jina;
	
	@Mapper("lastname")
	private String jinaLaMwisho;
	
	@Mapper("age")
	private Integer umri;

	public String getJina() {
		return jina;
	}

	public void setJina(String jina) {
		this.jina = jina;
	}

	public String getJinaLaMwisho() {
		return jinaLaMwisho;
	}

	public void setJinaLaMwisho(String jinaLaMwisho) {
		this.jinaLaMwisho = jinaLaMwisho;
	}

	public Integer getUmri() {
		return umri;
	}

	public void setUmri(Integer umri) {
		this.umri = umri;
	}

}
