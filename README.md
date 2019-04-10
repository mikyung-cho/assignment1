## 지자체 협약 지원 API

중소기업은행 지자체 협약 지원 정보 데이터를 활용한 API 개발. 데이터 저장, 조회 기능을 구현하였고, 데이터는 ',' 구분자로 저장되어 있는 CSV파일을 사용하였습니다.






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

미완성된 프로젝트로 각 기능은 App실행 후 url을 통해 확인 가능합니다.






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

**출력 데이터 (브라우저)**
```
[{"regionCd":"1","target":"강릉시 소재 중소기업으로서 강릉시장이 추천한 자","usage":"운전","limit":"추천금액 이내","rate":"3%","institute":"강릉시","mgmt":"강릉지점","reception":"강릉시 소재 영업점","regionNm":"강릉시"},{"regionCd":"2","target":"강원도 소재 중소기업으로서 강원도지사가 추천한 자","usage":"운전","limit":"8억원 이내","rate":"3%~5%","institute":"강원도","mgmt":"춘천지점","reception":"강원도 소재 영업점","regionNm":"강원도"},

...

{"regionCd":"98","target":"안양상공회의소에서 추천하는 자","usage":"운전","limit":"1억원 이내","rate":"1.00%","institute":"안양상공회의소","mgmt":"여신기획부","reception":"전영업점","regionNm":"안양상공회의소"}]
```




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


**입력 데이터 (postman)**
```
{
	"regionNm":"파주시"
}
```

**출력 데이터 (postman)**
```
{
    "regionCd": "82",
    "target": "파주시 소재 중소기업으로서 파주시장의 융자 추천을 받거나 파주시 소재 소상공인으로서 경기신용보증재단의 신용보증서를 발급 받은 자",
    "usage": "운전",
    "limit": "3억원 이내",
    "rate": "2.00%",
    "institute": "파주시, 경기신용보증재단",
    "mgmt": "파주지점",
    "reception": "전영업점",
    "regionNm": "파주시"
}
```




