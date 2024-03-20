-- 01 팀이름 오름차순 정렬
select team_name from team order by team_name;
-- 02 플레이어의 포지션 종류를 나열하시요. 단 중복을 제거하고, 포지션이 없으면 빈공간으로 두시오.
select distinct POSITION from player order by POSITION;
-- 3- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
select distinct POSITION from player;
-- 4- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
select player_name from player where team_id = 'K02' AND POSITION = 'GK';
-- 4-1 id모를경우
select player_name from player where POSITION = 'GK' AND team_id = (select team_id
                                                                    from team where region_name = '수원');
-- 5- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
select * from player where team_id = 'K02' AND  player_name LIKE '고%' AND height >= 170;
-- 5-1
select * from player where player_name LIKE '고%' AND height >= 170 AND team_id = (select team_id
                                                                                  from team where region_name = '수원');
-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
select * from team;
select player_name from player where POSITION = 'MF'AND  height between 170 AND 180  AND (team_id =(select team_id
                                                                                                    from team where team_name = '삼성블루윙즈')or team_id = (select team_id
                                                                                                                                                           from team where team_name = '드래곤즈'));
-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
select * from player where team_id= (select team_id
                                     from team where region_name = '수원') AND POSITION = 'GK';
-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name,team_id,if(weight='',0,weight)weight,if(height='',0,height)height from player where team_id  = (select team_id
                                       from team where team_name = 'FC서울') order by weight,height desc ;
select * from player;
-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오
select player_name,POSITION
       ,concat(ifnull(nullif(weight,''),0),'kg')weight
       ,concat(ifnull(nullif(height,''),0),'cm')hieght
       ,ifnull(nullif(round(weight/(height/100*height/100)),''),'none')bmi
       from player
       where team_id =(select team_id from team where region_name = '서울')
       order by  player_name desc ;
-- 4개의 테이블 모두 조인 full scan-
select * from player;
select * from team;
select * from stadium;
select * from schedule;

select count(*) count
from player p
join team t on t.team_id = p.team_id
join stadium s on t.stadium_id =s.stadium_id
join schedule sc on sc.stadium_id = s.stadium_id;

select count(*) count
from stadium
join schedule on stadium.stadium_id = schedule.stadium_id
join team on stadium.stadium_id = team.stadium_id
join player on team.team_id = player.team_id;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
select *  from player;
select POSITION,player_name,team_name
from player p
join team t on p.team_id =t.team_id
where POSITION = 'GK' AND (t.team_id = 'K10' or t.team_id = 'K02')
order by team_name,player_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select  * from team;
select  * from stadium;
select  * from player;
select  * from schedule;

select concat(t.region_name,'[]',team_name,s.stadium_name) answer
from stadium s
join team t on s.stadium_id = t.stadium_id;
-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순

select *
from team t
join player p on t.team_id = p.team_id
where  t.team_id in ('K02','K10')AND  p.height BETWEEN 180 AND 183
order by height,team_name,player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
select *
from team t
join player p on t.team_id = p.team_id
where p.POSITION = ''
order by team_name,player_name;

-- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
select t.team_name home_team,s.stadium_name,(select t.team_name
                                         from team t
                                         where sc.awayteam_id = t.team_id)away_team
from stadium s
join schedule sc on s.stadium_id = sc.stadium_id
join team t on s.stadium_id = t.stadium_id
where sc.sche_date = '20120317';




select team_name ,(select t.team_name
                   from stadium s
                   join  team t on s.stadium_id = t.stadium_id
                   where sc.awayteam_id = t.team_id)away
from team t
join schedule sc on t.stadium_id =sc.stadium_id
where sc.sche_date = '20210317';
-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
select p.player_name,p.POSITION,concat(t.team_name,' ',t.region_name)TEAM_REGION,s.stadium_name,sc.sche_date
from stadium s
JOIN team t on s.stadium_id = t.stadium_id
JOIN player p on t.team_id = p.team_id
JOIN schedule sc on s.stadium_id = sc.stadium_id
where sc.sche_date = '20120317' AND t.team_name = '스틸러스' AND p.POSITION = 'GK';
-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
select s.stadium_name,sc.sche_date,(SELECT t.team_name
                                    from team t
                                    where sc.hometeam_id =t.team_id) HOME_TEAM,(SELECT t.team_name
                                                                                from team t
                                                                                where sc.awayteam_id =t.team_id)AWAY_TEAM
from stadium s
JOIN schedule sc USING (stadium_id)
where (sc.home_score - sc.away_score) >=3;
-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름,홈팀
SELECT s.stadium_name,t.team_name HOME_TEAM
FROM stadium s
LEFT JOIN team t USING (stadium_id);

-- 문제 18 페이지네이션로직을 위한 플레이어 테이블에서 최상단 5개 로우를 출력
SELECT player_name
FROM player
order by 1
LIMIT 0,5;
-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
SELECT round(avg(height))AVG_height,team_id,(SELECT team.team_name
                                          FROM team
                                          WHERE team.team_id =player.team_id)TEAM_NAME
FROM player
where if(height = '',0,height) AND if(weight = '',0,weight)
group by player.team_id
having avg(height)<176.59;
-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT player_name,back_no,(SELECT t.team_name
                            FROM team t
                            WHERE t.team_id =player.team_id)TEAM_NAME
FROM player
where POSITION = 'MF';
-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
SELECT p.height,p.player_name,p.back_no,(SELECT t.team_name
                            FROM team t
                            WHERE t.team_id =p.team_id)TEAM_NAME
FROM player p
ORDER BY 1 desc
LIMIT 5;


-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SELECT *
FROM player p
join (SELECT team_id,round(AVG(height),2) avg
      FROM player
      where if(height = '',null,height)
      GROUP BY team_id)a_avg USING (team_id)
where height < avg AND if(height = '',null,height);





-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
SELECT s.stadium_name ,sche_date
FROM stadium s
JOIN schedule sc
where sc.sche_date BETWEEN '20120501' AND '20120531';