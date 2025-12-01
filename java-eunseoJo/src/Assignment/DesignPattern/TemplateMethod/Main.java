package Assignment.DesignPattern.TemplateMethod;

public class Main {
    public static void main(String[] args){

        Csv csv = new Csv();
        csv.runPipeline();

        Json json = new Json();
        json.runPipeline();
    }
}
