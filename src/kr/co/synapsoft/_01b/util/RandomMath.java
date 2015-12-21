package kr.co.synapsoft._01b.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

/**
 * 프로그램에서 사용될 랜덤 값들을 생성하는 클래스입니다.
 */
public class RandomMath {

    /**
     * 지정된 범위 내의 랜덤 숫자를 하나 가져옵니다.
     * @param randomMin
     * @param randomMax
     * @return
     */
    public static int getRandomInteger(int randomMax) {
//        return randomMin + (int)(Math.random()*randomMax);
        return new Random().nextInt(randomMax);
    }

    public static Set<Integer> getRandomInteger(int randomMax, int size) {

        Set<Integer> randomIntegerSet = new HashSet<>();
        while(randomIntegerSet.size() < size)
            randomIntegerSet.add(new Random().nextInt(randomMax));

        return randomIntegerSet;
    }
}
