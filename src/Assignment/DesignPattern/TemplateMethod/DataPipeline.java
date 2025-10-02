package Assignment.DesignPattern.TemplateMethod;

import javax.xml.crypto.Data;

abstract class DataPipeline {
    // runPipeline은 고정된 포맷
    public final void runPipeline(){
        extract();      // 포맷별 구현
        transform();    // 공통 변환
        load();         // 공통 로직
    }

    private void transform(){
        System.out.println("데이터 변환 : Record 리스트로 변환");
    }
    private void load(){
        System.out.println("데이터 적재 : DB에 저장 완료");
    }

    // 포맷별 다른 추상 메서드 -> 자식 클래스에서 구현
    abstract void extract();

}

class Csv extends DataPipeline {
    @Override
    void extract(){
        System.out.println("데이터 추출 : CSV 파일 읽기");
    }
}


class Json extends DataPipeline {
    @Override
    void extract(){
        System.out.println("데이터 추출 : JSON 파일 읽기");
    }
}
