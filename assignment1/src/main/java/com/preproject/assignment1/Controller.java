package com.preproject.assignment1;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.preproject.assignment1.domain.Convention;
import com.preproject.assignment1.repository.ConventionRepository;

@RestController
@RequestMapping(value = "/conventions")
public class Controller {
	@Autowired
	private ConventionRepository conventionRepository;

	@RequestMapping("/csvreader")
	public void readCsv() {
		List<Convention> data = null;

		try {
			InputStreamReader is = new InputStreamReader(new FileInputStream("data/test.csv"), "EUC-KR");
			CSVReader reader = new CSVReaderBuilder(is).withSkipLines(1).build();

			ColumnPositionMappingStrategy<Convention> strategy = new ColumnPositionMappingStrategy<Convention>();
			strategy.setType(Convention.class);

			CsvToBean<Convention> csvTobean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<Convention> myConvention = csvTobean.iterator();

			while (myConvention.hasNext()) {
				Convention convention = myConvention.next();
				conventionRepository.save(convention);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/list")
	public List<Convention> getList() {
		return (List<Convention>) conventionRepository.findAll();
	}

	@RequestMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Convention> findByRegion(@RequestBody Convention convention) {
		return conventionRepository.findByRegionNm(convention.getRegionNm());
	}

}
