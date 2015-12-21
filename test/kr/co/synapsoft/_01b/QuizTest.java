package kr.co.synapsoft._01b;

import kr.co.synapsoft._01b.support.ResultCode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by no_pain_no_code on 2015. 12. 18..
 */
public class QuizTest {

    @Test
    public void test_문자_삽입() throws Exception {

        // given
        Quiz quiz = new Quiz("synapsoft");

        // when
        ResultCode resultCode = quiz.runQuiz('s');

        // then
        Assert.assertEquals("s****s***", quiz.getWordWithStar());
        Assert.assertEquals(resultCode, ResultCode.FOUND);
    }

    @Test
    public void test_없는_문자_입력() throws Exception {

        //given
        Quiz quiz = new Quiz("synapsoft");

        // when
        ResultCode resultCode1 = quiz.runQuiz('d');
        ResultCode resultCode2 = quiz.runQuiz('d');
        ResultCode resultCode3 = quiz.runQuiz('d');
        ResultCode resultCode4 = quiz.runQuiz('d');
        ResultCode resultCode5 = quiz.runQuiz('d');
        ResultCode resultCode6 = quiz.runQuiz('d');
        ResultCode resultCode7 = quiz.runQuiz('d');

        // then
        Assert.assertEquals(resultCode1, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode2, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode3, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode4, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode5, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode6, ResultCode.NOT_FOUND);
        Assert.assertEquals(resultCode7, ResultCode.FAIL);
    }

    @Test
    public void test_모든_문자_맞춤() throws Exception {

        // given
        Quiz quiz = new Quiz("synapsoft");

        // when
        ResultCode resultCode1 = quiz.runQuiz('s');
        ResultCode resultCode2 = quiz.runQuiz('y');
        ResultCode resultCode3 = quiz.runQuiz('n');
        ResultCode resultCode4 = quiz.runQuiz('a');
        ResultCode resultCode5 = quiz.runQuiz('p');
        ResultCode resultCode6 = quiz.runQuiz('o');
        ResultCode resultCode7 = quiz.runQuiz('f');
        ResultCode resultCode8 = quiz.runQuiz('t');

        // then
        Assert.assertEquals(resultCode1, ResultCode.FOUND);
        Assert.assertEquals(resultCode2, ResultCode.FOUND);
        Assert.assertEquals(resultCode3, ResultCode.FOUND);
        Assert.assertEquals(resultCode4, ResultCode.FOUND);
        Assert.assertEquals(resultCode5, ResultCode.FOUND);
        Assert.assertEquals(resultCode6, ResultCode.FOUND);
        Assert.assertEquals(resultCode7, ResultCode.FOUND);
        Assert.assertEquals(resultCode8, ResultCode.SUCCESS);
    }

    @Test
    public void test_중복_문자_입력() throws Exception {

        // given
        Quiz quiz = new Quiz("synapsoft");

        // when
        ResultCode resultCode1 = quiz.runQuiz('s');
        ResultCode resultCode2 = quiz.runQuiz('s');

        // then
        Assert.assertEquals(resultCode1, ResultCode.FOUND);
        Assert.assertEquals(resultCode2, ResultCode.DUPLICATE);
    }
}