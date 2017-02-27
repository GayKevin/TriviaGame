/**
 * Created by thieg on 27/02/2017.
 */
public class Question {

    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    int realAnswer;

    Question(String[] str){
        this.question = str[0];
        this.answer1 = str[1];
        this.answer2 = str[2];
        this.answer3 = str[3];
        this.answer4 = str[4];
        this.realAnswer = Integer.parseInt(str[5]);
    }

    @Override
    public String toString() {
        String str;

        str = this.question + "\n";
        str += "1 - " + this.answer1 + "\n";
        str += "2 - " + this.answer2 + "\n";
        str += "3 - " + this.answer3 + "\n";
        str += "4 - " + this.answer4 + "\n";
        str += "Select your answer (1-4) : ";

        return str;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(int realAnswer) {
        this.realAnswer = realAnswer;
    }
}
