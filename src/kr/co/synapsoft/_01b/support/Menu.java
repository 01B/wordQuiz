package kr.co.synapsoft._01b.support;

import kr.co.synapsoft._01b.Quiz;

import java.util.Scanner;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

/**
 * Menu 출력 클래스입니다.
 */
public class Menu {

    private Scanner scanner;
    private WordBuilder wordBuilder;

    public Menu() {
        scanner = new Scanner(System.in);
        wordBuilder = new WordBuilder();
    }

    /**
     * 메뉴를 출력합니다.
     */
    public Menu printMenu(){
        System.out.println("=============");
        System.out.println("1. 퀴즈");
        System.out.println("2. 데이터 바꾸기");
        System.out.println("3. 설명");
        System.out.println("4. 나가기");
        System.out.println("=============");

        return this;
    }

    /**
     * 선택하고자 하는 메뉴 번호를 입력받습니다.
     * @return 선택된 메뉴 번호
     */
    public int selectMenu() {

        int inputNum = getInputNum();

        switch (inputNum){
            // 퀴즈.
            case 1:
                String selectedWord = wordBuilder.selectOneWord();
                Quiz quiz = new Quiz(selectedWord);
                finish(doQuiz(quiz));
                System.out.println("정답 : " + selectedWord);
                break;
            // 데이터 바꾸기.
            case 2:
                refreshData();
                break;

            // 설명
            case 3:
                printAboutQuiz();
                break;

            // 나가
            case 4:
                break;
        }

        return inputNum;
    }

    /**
     * 단어 퀴즈를 위한 문자를 입력받습니다.
     * @return
     */
    private char inputChar(String printStr) {
        System.out.println(printStr);
        char inputChar = 0;

        while(true) {
            inputChar = scanner.next().charAt(0);
            if(!Character.isLowerCase(inputChar)) {
                return inputChar("소문자를 입력해주세요.");
            }else
                break;

        }

        return inputChar;
    }

    /**
     * 퀴즈를 진행합니다.
     * @param quiz
     * @return
     */
    private ResultCode doQuiz(Quiz quiz) {

        ResultCode resultCode = quiz.runQuiz(inputChar("문자(소문자)를 입력하세요."));

        printInputResult(resultCode, quiz);

        if(resultCode == ResultCode.SUCCESS || resultCode == ResultCode.FAIL)
            return resultCode;

        return doQuiz(quiz);
    }

    /**
     * 입력한 문자의 결과에 따른 출력을 합니다.
     * @param resultCode
     * @param quiz
     */
    private void printInputResult(ResultCode resultCode, Quiz quiz) {

        switch (resultCode) {
            case FOUND :
                System.out.println("-------------");
                System.out.println(quiz.getWordWithStar());
                System.out.println("-------------");
                break;

            case NOT_FOUND:
                System.out.println("-----------------------------");
                System.out.println(String.format("입력한 문자는 없습니다. 틀린횟수(%d/%d)",quiz.getWrongInputCount(),quiz.wrongCount));
                System.out.println("-----------------------------");
                break;

            case DUPLICATE:
                System.out.println("---------------------------------");
                System.out.println("이미 입력한 문자열입니다. 다시 입력해주세요.");
                System.out.println("---------------------------------");
        }
    }

    /**
     * 퀴즈를 설명합니다.
     */
    private void printAboutQuiz() {
        System.out.println("문자를 입력하여 단어를 맞추는 영단어 맞추기 프로그램입니다.");
        System.out.println("입력한 문자가 존재하면 '*'문자가 입력한 문자로 바뀝니다.");
        System.out.println("모든 문자를 맞춰 단어를 완성시키면 성공입니다.");
        System.out.println("입력한 문자가 단어에 해당하지 않는 경우 틀린 회수가 늘어나 7번 이상이 되면 실패입니다.");
        System.out.println("2번 메뉴인 '데이터 바꾸기'는 단어를 재로드합니다.");
    }

    /**
     * 데이터를 새로 불러옵니다.
     */
    private void refreshData() {
        System.out.println("데이터를 재로드합니다.");
        wordBuilder = new WordBuilder();
    }

    /**
     * 단어 맞추기를 끝냈을 때 출력됩니다.
     * @param resultCode
     */
    private void finish(ResultCode resultCode) {
        if(resultCode == ResultCode.SUCCESS)
            System.out.println("단어 맞추기 성공!");

        if(resultCode == ResultCode.FAIL)
            System.out.println("단어 맞추기 실패 ㅠㅠ");
    }

    /**
     * Scanner 객체를 이용하여 숫자를 입력받습니다.
     * @return
     */
    private int getInputNum() {
        System.out.println("메뉴 번호를 입력하세요.");
        while(!scanner.hasNextInt()) {
            System.out.println("숫자를 입력하세요.");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
