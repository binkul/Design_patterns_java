package com.binkul.patterns.creative.builder.classic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * call it as:
 * SomeBuilder builder = SomeBuilder.Builder()
 *                              .stringA("text1")
 *                              .stringB("text2")
 *                              .stringC("text3")
 *                              .longA(1)
 *                              .longB(2)
 *                              .longC(3)
 *                              .addSome("text4")
 *                              .addSome("text5")
 *                              .addSome("text6")
 *                              .addSome("text7")
 *                              .build();
 */

public class SomeBuilder {
    private String stringA;
    private String stringB;
    private String stringC;
    private Long longA;
    private Long longB;
    private Long longC;
    private List<String> someList = new ArrayList<>();

    private SomeBuilder(String stringA, String stringB, String stringC, Long longA, Long longB, Long longC, List<String> someList) {
        this.stringA = stringA;
        this.stringB = stringB;
        this.stringC = stringC;
        this.longA = longA;
        this.longB = longB;
        this.longC = longC;
        this.someList = new ArrayList<>(someList);
    }

    public String getStringA() {
        return stringA;
    }

    public String getStringB() {
        return stringB;
    }

    public String getStringC() {
        return stringC;
    }

    public Long getLongA() {
        return longA;
    }

    public Long getLongB() {
        return longB;
    }

    public Long getLongC() {
        return longC;
    }

    public List<String> getSomeList() {
        return someList;
    }

    public static class Builder {
        private String stringA;
        private String stringB;
        private String stringC;
        private Long longA;
        private Long longB;
        private Long longC;
        private List<String> someList = new ArrayList<>();

        public Builder stringA(String stringA) {
            this.stringA = stringA;
            return this;
        }

        public Builder stringB(String stringB) {
            this.stringB = stringB;
            return this;
        }

        public Builder stringC(String stringC) {
            this.stringC = stringC;
            return this;
        }

        public Builder longA(Long longA) {
            this.longA = longA;
            return this;
        }

        public Builder longB(Long longB) {
            this.longB = longB;
            return this;
        }

        public Builder longC(Long longC) {
            this.longC = longC;
            return this;
        }

        public Builder addSome(String someData) {
            someList.add(someData);
            return this;
        }

        public SomeBuilder build() {
            return new SomeBuilder(stringA, stringB, stringC, longA, longB, longC, someList);
        }
    }
}
