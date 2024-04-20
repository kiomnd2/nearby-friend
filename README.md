# 주변 친구 찾기
> 가상면접 사례로 보는 대규모 설계 기초 2부 에 첨부된
> 주변친구찾기의 설계 기반으로 서버 코드를 짜본다

## 스펙
* java 17
* spring 3.1.11
* embedded redis
* redis client (lettuce)
* jpa
* websocket

## 목표
* 사용자 위치 이력 API
* 현재 위치 정보를 캐시 
  * key : 사용자 ID , value : 사용자 위치 정보
* 레디스 클라이언트 -> 임베디드 레디스에 연결
  * 주기적인 사용자 등록 요청에 따라 레디스 pub/sub 에 채널등록
    * 토픽 : userId, 값 : 위치정보를 담은 객체 pub
    * 본인 userId 로 sub 시, 따로 계산없이 바로 주변사용자 정보 리턴
    * 주변사용자의 ttl 은 30초로함

