package com.binkul.patterns.creative.builder.example;

public class Application {
    public static void main(String[] args) {
        Checkers checkers = new Checkers.CheckersBuilder()
                .PlayerOne("John")
                .PlayerTwo("Theresa")
                .Figure(FigureFactory.PAWN, Figure.WHITE, 0, 3)
                .Figure(FigureFactory.PAWN, Figure.BLACK, 9, 7)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 5, 6)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 0, 2)
                .build();
        System.out.println(checkers.getBoard());
    }
}
