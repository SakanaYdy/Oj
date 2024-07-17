package com.yupi.springbootinit.judge.codesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeRequest {

    /**
     * 所有的输入测试样例
     */
    private List<String> inputList;

    /**
     * 提交的代码
     */
    private String code;
    /**
     * 提交的代码语言
     */
    private String language;

}
