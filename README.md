# 지자체 협약 지원 API

중소기업은행 지자체 협약 지원 정보 데이터를 활용한 API 개발. 데이터 저장, 조회 기능을 구현하였고, 데이터는 ',' 구분자로 저장되어 있는 CSV파일을 사용한다.






# 개발환경

Tool : Spring Tool Suite 4, postman

Framework : Spring Framework, hibernate, Spring Data JPA

Library : opencsv

Database : h2

Server : sts embedded tomcat







# 기능

- csv파일을 이용한 데이터 저장.
- 지자체 목록 검색.
- 지자체명을 입력받아 해당 지원정보 출력.

미완성된 프로젝트로 각 기능테스트는 URL로 가능합니다.






# 테스트

**Spring Boot App 실행** 후 브라우저의 url과 postman을 이용한 테스트.

1. csv파일을 이용한 데이터 저장.

```
InputStreamReader is = new InputStreamReader(new FileInputStream("data/test.csv"), "EUC-KR");
```

파일경로를 받지 않아 프로젝트 내 **data/test.csv** 파일 저장 후 저장 테스트.

URL : http://localhost:8080/conventions/csvreader

브라우저 또는 postman으로 저장 테스트.
input, output이 없는 기능으로 h2 console에서 데이터 저장 확인.



2. 지자체 목록 검색.

```
@RequestMapping(value = "/list")
public List<Convention> getList() {
	return (List<Convention>) conventionRepository.findAll();
}
```

URL : http://localhost:8080/conventions/list


브라우저 또는 postman으로 조회 테스트.

출력 데이터 형식이 json이고, 저장된 전체 데이터가 조회되는지 확인.



3. 지자체명을 입력받아 해당 지원정보 출력.

```
@RequestMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public Optional<Convention> findByRegion(@RequestBody Convention convention) {
	return conventionRepository.findByRegionNm(convention.getRegionNm());
}
```
URL : (POST) localhost:8080/conventions/find

postman으로 테스트.

지자체명을 json형식으로 입력 후 해당 지자체 정보 조회 확인.

입력, 출력 데이터 형식이 json이고, 조건에 맞는 데이터가 조회되는지 확인.







