/**
 * Created by Kevin Gay on 27/02/2017.
 */

/**
 * Class Question
 */
public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int realAnswer;

    /**
     * Constructor of the class Question
     * @param str array who contains the question with everything
     */
    Question(String[] str){
        this.question = str[0];
        this.answer1 = str[1];
        this.answer2 = str[2];
        this.answer3 = str[3];
        this.answer4 = str[4];
        this.realAnswer = Integer.parseInt(str[5]);
    }

    /**
     * Override of the ToString to display the questions
     * @return str that should be display
     */
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


    /**
     * Get the question
     * @return the String question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * set the question
     * @param question set the question with a String
     */
    public void setQuestion(String question) {
        this.question = question;
    }


    /**
     * Get the answer1
     * @return the String question
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * set the answer1
     * @param answer1 set the answer1 with a String
     */
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    /**
     * Get the answer2
     * @return the String question
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * set the answer2
     * @param answer2 set the answer1 with a String
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    /**
     * Get the answer3
     * @return the String question
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * set the answer3
     * @param answer3 set the answer1 with a String
     */
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    /**
     * Get the answer4
     * @return the String question
     */
    public String getAnswer4() {
        return answer4;
    }

    /**
     * set the answer4
     * @param answer4 set the answer1 with a String
     */
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    /**
     * Get the real answer into a int
     * @return the int answer
     */
    public int getRealAnswer() {
        return realAnswer;
    }

    /**
     * set the real answer
     * @param realAnswer set the answer with a int
     */
    public void setRealAnswer(int realAnswer) {
        this.realAnswer = realAnswer;
    }
}
