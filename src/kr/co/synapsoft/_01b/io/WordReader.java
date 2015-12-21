package kr.co.synapsoft._01b.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by no_pain_no_code on 2015. 12. 17..
 */

/**
 * csv 파일에서 단어들을 읽어옵니다.
 */
public class WordReader {

    public WordReader() {
    }

    public List<String> readWord(String path) {

        List<String> words = new ArrayList<String>();
        StringBuilder inputWordBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String str;
            while((str = reader.readLine()) != null)
                for (String word : str.split(",")) {
                    if(!word.equals("")) words.add(word);
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}

