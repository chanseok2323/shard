# Sharding 
### 실무에서 처음으로 샤딩이 적용된 환경에서 개발을 하게 되었습니다. 다른 분들께서 공통 소스에서 샤딩 관련하여 처리하신 소스들을 보니 한번 샤딩 처리를 해보고 싶어서 해당 프로젝트를 시작
- [ ] 샤딩 이란?
  - 같은 테이블의 스키마를 가진 데이터를 다수의 데이터베이스에 분산하여 저장하는 방식
  - Vertical Partitioning 
    - 하나의 테이블을 컬럼의 기준으로 나눈다.
    - 자주 사용하는 컬럼과 자주 사용하지 않은 컬럼으로 나눠서 성능 향상
    - 해당 테이블에 자주 사용하지 않는 컬럼의 데이터가 없어지므로 테이블이 더 작은 사이즈를 차지 
  - Horizontal Partitioning  == 샤딩
    - 같은 테이블을 데이터 기준으로 나눈다
    - 데이터의 개수가 적어지므로 하나의 DB에서 처리하는 부하가 줄어든다
    - 여러 대의 DB와 연결 되어야 한다
    
  - 샤딩의 종류
  
    - Range Sharding : 특정 범위 대역으로 나누기 (PK의 범위)
      - 장점 
        - 새로운 Shard를 다른 방식보다 추가하기 쉽다 (증설 시 재정렬 비용이 들지 않는다)
      - 단점
        - Shard 간의 데이터가 균등하지 않을 가능성이 있다. (특정 DB에 데이터가 몰릴 수 있다)
        
    - Modular Sharding : PK를 모듈러 연산한 결과로 DB를 특정하는 방식
      - 장점 
        - 데이터의 분배가 균등한 편
      - 단점
        - DB 증설 시, 이미 적재된 데이터의 재정렬 필요
        
    - Indexed Sharding : 특정 데이터의 위치를 가르키는 서버가 존재하는 방식
      - 장점
        - 데이터의 분배를 원하는 형태로 하기 쉽다
      - 단점
        - Indexed 자체가 하나의 서비스가 된다. (관리 포인트 증가)
    
      
- [ ] 샤딩 키
    - 사용자의 고유 번호의 끝자리를 이용하여 샤딩키 지정
    - 사용자 고유번호의 맨 앞 자리 0 : main00, 1 : main01, 2 : main02 .... 9 : main09 이런 식으로 샤딩키를 생성

- [ ] AbstractRoutingDataSource
    - 특정 상황에 맞게 DataSource 동적으로 변경하는 기능 AbstractRoutingDataSource 상속 받아서 사용하면 쉽게 구현
    - 어떤 방식으로 데이터 베이스를 선택할 지 결정할 determineCurrentLookupKey 메서드 재정의

- [ ] ShardingAspect
    - Service 에서 샤딩 키를 통해서 쉽게 DB를 찾을 수 있도록 AOP 구현
    - 메소드의 인수로 맨 처음에는 userNo가 넘어오도록 해당 프로젝트의 규약, @Sharding annotation 필요
