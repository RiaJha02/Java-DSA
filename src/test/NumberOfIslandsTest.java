package src.test;

import src.main.Practice.NumberOfIslands;

import java.util.Arrays;

public class NumberOfIslandsTest {

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(Arrays.deepToString(grid));
        System.out.println("***************************");
        System.out.println("numOfIslands : " + islands.numIslandsDFS(grid));
        System.out.println(Arrays.deepToString(grid));
        System.out.println("***************************");
        System.out.println("numOfIslands : " + islands.numIslandsBFS(grid));
        System.out.println("***************************");
    }
}
