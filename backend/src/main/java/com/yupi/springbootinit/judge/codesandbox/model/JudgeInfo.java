package com.yupi.springbootinit.judge.codesandbox.model;


import lombok.Data;

/**
 * 题目判断信息
 */
@Data
public class JudgeInfo {

    //程序执行信息
    private String message;
    // 消耗内存 kb
    private Long memory;
    // 执行消耗时间 ms
    private Long time;

}
