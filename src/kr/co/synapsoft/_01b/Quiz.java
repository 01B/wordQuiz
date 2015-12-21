package kr.co.synapsoft._01b;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

import kr.co.synapsoft._01b.support.ResultCode;

/**
 * 퀴즈 클래스입니다.
 */
public class Quiz {

    private char[] wordArray;
    private char[] wordWithStarArray;
    private int wrongInputCount;
    public int wrongCount;

    public Quiz(String word) {

        this.wordArray = word.toCharArray();

        wordWithStarArray = new char[word.length()];
        for (int i = 0; i < word.length(); i++)
            wordWithStarArray[i] = '*';

        wrongInputCount = 0;
        wrongCount = 7;
    }

    /**
     * 문자를 입력하며 퀴즈를 풉니다.
     * @param inputChar
     * @return
     */
    public ResultCode runQuiz(char inputChar) {

        if (isInputCharAlreadyInput(inputChar))
            return ResultCode.DUPLICATE;

        if(!inputCharacter(inputChar)) {
            if(++wrongInputCount >= wrongCount)
                return ResultCode.FAIL;
            return ResultCode.NOT_FOUND;
        } else {
            return isSuccess() ? ResultCode.SUCCESS : ResultCode.FOUND;
        }
    }

    /**
     * 입력된 문자가 이미 입력됐던 문자인지 확인합니다.
     * @param inputChar
     * @return
     */
    private boolean isInputCharAlreadyInput(char inputChar) {

        for (char c : wordWithStarArray) {
            if(c == inputChar)
                return true;
        }

        return false;
    }

    /**
     * 입력된 문자를 적용합니다.
     * @param inputChar
     * @return
     */
    private boolean inputCharacter(char inputChar) {

        boolean isBelong = false;
        for (int i = 0; i < wordArray.length; i++)
            if (wordArray[i] == inputChar) {
                wordWithStarArray[i] = inputChar;
                isBelong = true;
            }

        return isBelong;
    }

    /**
     * 단어의 모든 글자들이 맞춰졌는지 확인합니다.
     * @return
     */
    private boolean isSuccess() {
        for (char c : wordWithStarArray) {
            if(c == '*')
                return false;
        }

        return true;
    }

    public String getWordWithStar() {
        return String.valueOf(this.wordWithStarArray);
    }

    public int getWrongInputCount() {
        return this.wrongInputCount;
    }
}
