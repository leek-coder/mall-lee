package com.huatech.mall.persistence;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author like
 * @date 2020-12-31 3:41 下午
 **/
@Slf4j
public class RuleFileUtils {

    public static void mkdirIfNotExits(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public static void createFileIfNotExits(Map<String, String> ruleFileMap) throws IOException {

        Set<String> ruleFilePathSet = ruleFileMap.keySet();
        Iterator<String> ruleFilePathIter = ruleFilePathSet.iterator();
        while (ruleFilePathIter.hasNext()) {
            String ruleFilePathKey = ruleFilePathIter.next();
            String ruleFilePath = PersistenceRuleConstant.rulesMap.get(ruleFilePathKey).toString();
            File ruleFile = new File(ruleFilePath);
            if (ruleFile.exists()) {
                ruleFile.createNewFile();
            }
        }
    }

}