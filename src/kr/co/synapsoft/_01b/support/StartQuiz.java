package kr.co.synapsoft._01b.support;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

/**
 * 퀴즈를 시작합니다.
 */
public class StartQuiz {

    private Menu menu;

    public StartQuiz() {
        this.menu = new Menu();
    }

    public void run() {
        while(true) {
            if(4 == menu.printMenu().selectMenu())
                break;
        }
    }

}
