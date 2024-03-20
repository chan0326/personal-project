package com.erichgamma.api.common;

public class UtilServiceImpl implements UtilService {

    private  static  UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl(){}

    public static UtilService getInstance(){
        return instance;
    }


    @Override
    public int createRandomInteger(int start, int gapBetweenEnd) {

        return start + (int)(Math.random()*gapBetweenEnd);
    }

    @Override
    public double createRandomDouble(int start, int gapBetweenEnd) {
       return Math.round((start + Math.random()* gapBetweenEnd)*10)/10.0;
    }

    public String CreatRandomUsername (){
        String username = "";
        for(; username.length() < 5;
            username += String.valueOf((char)('a' + this.createRandomInteger(0, 26)))); //a는 아스키 코드로 97이라 여기에 수를 더해서 b,c,d,e...로 변환
        return  username;
    }
    public String creatRadomName (){
        String[] names ={"이정재", "마동석", "송강호", "윤여정", "황정민",
                "정우성", "이병헌", "현 빈", "유해진", "손석구", "전도연",
                "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건",
                "원 빈", "박해일", "소지섭", "김혜"};

        return names[createRandomInteger(0,20)];
    }

    @Override
    public String creatRandomTitle() {
        String [] titles = {"혼인과 가족생활 ","사랑과 우정 ","믿음과 소망 ","국가유공자와 법률 ",
        "국민의 믿음 ","주거의 자유 ","보건과 국가 자유 ","정부의 회계 ","헌법재판소와 국회 ","국가의 평생교육 "};
        return titles[createRandomInteger(0,10)];
    }

    @Override
    public String creatRandomContnt() {
        String [] content = {"한 회계연도를 넘어 계속하여 지출할 필요가 있을 때에는 정부는 연한을 정하여 계속비로서 국회의 의결을 얻어야 한다."
                ,"모든 국민은 법률이 정하는 바에 의하여 공무담임권을 가진다."
                ,"모든 국민은 능력에 따라 균등하게 교육을 받을 권리를 가진다."
                ,"국가유공자·상이군경 및 전몰군경의 유가족은 법률이 정하는 바에 의하여 우선적으로 근로의 기회를 부여받는다."
                ,"국가는 평생교육을 진흥하여야 한다."
                ,"정당의 목적이나 활동이 민주적 기본질서에 위배될 때에는 정부는 헌법재판소에 그 해산을 제소할 수 있고, 정당은 헌법재판소의 심판에 의하여 해산된다."
                ,"모든 국민은 주거의 자유를 침해받지 아니한다."
                ,"모든 국민은 보건에 관하여 국가의 보호를 받는다."
                ,"헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다."
                ,"정부는 회계연도마다 예산안을 편성하여 회계연도 개시 90일전까지 국회에 제출하고, 국회는 회계연도 개시 30일전까지 이를 의결하여야 한다."};
        return content[createRandomInteger(0,10)];
    }

    @Override
    public String creatRandomCompany() {
        String [] companies = {"구글","삼성","엔디비아","현대","아마존","기아","LG","네이버","애플"};

        return companies[createRandomInteger(0,9)];
    }

    @Override
    public String creatRandomJob() {
        String[] job ={"교수","경찰","판사","소방관","의사","군인","택시운전사","배우","가수"};

        return job[createRandomInteger(0,8)];
    }
}
