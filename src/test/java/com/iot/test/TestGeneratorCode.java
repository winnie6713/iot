package com.iot.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.*;

/**
 * @author: weiyunyun
 * @date: 2020/3/19 10:37
 */
public class TestGeneratorCode {
    @Test
    public void testGen() {
        //1.全局配置
        GlobalConfig gConfig = new GlobalConfig();
        gConfig.setActiveRecord(true)//支持AR模式
                .setAuthor("weiyunyun") //设置作者
                .setBaseResultMap(true) //XML中的ResultMap标签
                .setBaseColumnList(true) //XML标签
                .setFileOverride(true) //文件覆盖设置
                .setIdType(IdType.AUTO) //主键策略
                .setOutputDir("E:\\projects\\iot\\src\\main\\java") //生成路径
                .setMapperName("%sMapper")  //%s会自动填充表实体属性
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");

        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://120.24.188.42:3306/test_iot?characterEncoding=utf8&serverTimezone=UTC&useSSL=false")
                .setUsername("root")
                .setPassword("zkds503");

        //3.策略配置
        StrategyConfig sConfig = new StrategyConfig();
        sConfig .setCapitalMode(true) //开启全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) //数据库映射到实体：下划线转驼峰
                .setTablePrefix("t_")
                .setEntityLombokModel(true)
                .setInclude("log_info"); //指定生成的表

        //4.包名策略配置
        PackageConfig pConfig = new PackageConfig();
        pConfig.setParent("com.iot")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");

        /**
         * 注入自定义配置
         */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "E:\\projects\\iot\\" + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("templates/1.java");
        // templateConfig.setService();
        templateConfig.setController(null);
        //此处设置为null，就不会再java下创建xml的文件夹了
        templateConfig.setXml(null);

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(gConfig)
                .setDataSource(dsConfig)
                .setStrategy(sConfig)
                .setPackageInfo(pConfig)
                .setCfg(abc)
                .setTemplate(templateConfig);


        autoGenerator.execute();
    }
}
