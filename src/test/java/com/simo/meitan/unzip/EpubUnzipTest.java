package com.simo.meitan.unzip;

import cn.hutool.core.util.ZipUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EpubUnzipTest {

    @Test
    public void testUnZip(){
        File unzip = ZipUtil.unzip("C:\\Users\\simo\\Desktop\\深度成长.epub", "C:\\Users\\simo\\Desktop\\aaa");
    }
}
