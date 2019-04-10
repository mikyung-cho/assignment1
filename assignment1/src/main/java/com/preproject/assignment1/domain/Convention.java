
package com.preproject.assignment1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name = "convention")
@SecondaryTable(name = "region", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "regionCd"))
public class Convention{

	@Column(name = "regionCd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String regionCd;
	@Column
	@CsvBindByPosition(position = 2)
	private String target;
	@Column
	@CsvBindByPosition(position = 3)
	private String usage;
	@Column(name="slimit")
	@CsvBindByPosition(position = 4)
	private String limit;
	@Column
	@CsvBindByPosition(position = 5)
	private String rate;
	@Column
	@CsvBindByPosition(position = 6)
	private String institute;
	@Column
	@CsvBindByPosition(position = 7)
	private String mgmt;
	@Column
	@CsvBindByPosition(position = 8)
	private String reception;
	
	@Column(table = "region")
	@CsvBindByPosition(position = 1)
	private String regionNm;
	

	public Convention() {
	}

	public Convention(String regionCd, String target, String usage, String limit, String rate,
			String institute, String mgmt, String reception, String regionNm) {
		this.regionCd = regionCd;
		this.target = target;
		this.usage = usage;
		this.limit = limit;
		this.rate = rate;
		this.institute = institute;
		this.mgmt = mgmt;
		this.reception = reception;
		this.regionNm = regionNm;
	}

	public String getRegionCd() {
		return regionCd;
	}

	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}

	public String getRegionNm() {
		return regionNm;
	}

	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getMgmt() {
		return mgmt;
	}

	public void setMgmt(String mgmt) {
		this.mgmt = mgmt;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String reception) {
		this.reception = reception;
	}

}
