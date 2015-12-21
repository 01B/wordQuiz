package kr.co.synapsoft._01b.support;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

import kr.co.synapsoft._01b.io.WordReader;
import kr.co.synapsoft._01b.util.RandomMath;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 입력된 단어들을 랜덤 변수를 이용해 퀴즈에 사용할 단어를 선별합니다.
 */
public class WordBuilder {

    private final static String INPUT_WORD = "words.csv";
    private final static int WORD_COUNT = 10;
    private final static String PATH = "";
    List<String> words;
    private List<String> selectedWords;

    public WordBuilder() {
        words = new WordReader().readWord(PATH + INPUT_WORD);
        selectWords();
    }

    private void selectWords() {
        Set<Integer> numbers = RandomMath.getRandomInteger(words.size() - 1, WORD_COUNT);
        selectedWords = words.stream()
                .filter(element -> numbers.contains(words.indexOf(element)))
                .collect(Collectors.toList());
    }


    /**
     * 선택된 단어 중에서 하나의 단어를 선택합니다.
     *
     * @return
     */
    public String selectOneWord() {
        return selectedWords.get(RandomMath.getRandomInteger(selectedWords.size() - 1));
    }

}
