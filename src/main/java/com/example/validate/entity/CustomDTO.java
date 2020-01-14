package com.example.validate.entity;


import com.example.validate.annotion.CaseMode;
import com.example.validate.annotion.CheckCase;

/**
 * @author Administrator
 */
public class CustomDTO {

    @CheckCase(value = CaseMode.UPPER, message = "属性值一定要是大写")
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
