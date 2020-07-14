package com.wonjin.effective.constructor;

import java.util.List;
import java.util.Objects;

/*
    클래스 내부에서 사용하는 자원이 있을 경우(SpellCheck에서는 dictionary)
    이 자원을 생성자에서 주입 받도록 한다면 유연성과 테스트 용이성을 높일 수 있다.
 */
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return true;
    }

    public List<String> suggestions(String typo) {
        return null;
    }

    class Lexicon {

    }
}
