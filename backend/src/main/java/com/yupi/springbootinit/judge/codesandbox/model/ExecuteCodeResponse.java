package com.yupi.springbootinit.judge.codesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeResponse {

    /**
     * 代码输出结果
     */
    private List<String> outputList;

    /**
     * 代码沙箱的相关信息
     */
    private String message;

    /**
     * 判题状态
     */
    private Integer status;

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;

}
