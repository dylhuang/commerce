import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://47.108.117.127:3306/standard", "root", "Yuxiu!@#123")
                // 全局配置
                .globalConfig(builder -> builder
                        // 设置作者 todo
                        .author("zl")
                        // 注释日期
                        .commentDate("yyyy/MM/dd")
                        // 开启 swagger 模式
                        .enableSwagger()
                        // 禁止打开输出目录
                        .disableOpenDir()
                        // 指定输出目录 todo
                        .outputDir("/yuxiu"))
                // 包配置
                .packageConfig(builder -> builder
                        // 设置父包名
                        .parent("com.group.consult.commerce")
                        // 设置父包模块名
//                            .moduleName("system")
                        // Entity包名
                        .entity("dao.entity")
                        // Service包名
                        .service("persist")
                        // Service Impl包名
                        .serviceImpl("persist.impl")
                        // Mapper包名
                        .mapper("dao.mapper")
                        // 设置mapperXml生成路径
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "/yuxiu")))
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            // 设置需要生成的表名 todo
                            .addInclude("assign_form","back_form","customer","customer_profile","order","customer_rights", "report_form","service_pack","service_usage_log");
                    // Entity 策略配置
                    builder.entityBuilder()
                            .enableFileOverride()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .idType(IdType.AUTO);
                    // Controller 策略配置
                    builder.controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()
                            .formatFileName("%sController");
                    // Service 策略配置
                    builder.serviceBuilder()
                            .enableFileOverride()
                            .superServiceClass(IService.class)
                            .superServiceImplClass(ServiceImpl.class)
                            .formatServiceFileName("I%sService")
                            .formatServiceImplFileName("%sServiceImpl");
                    // Mapper 策略配置
                    builder.mapperBuilder()
                            .enableFileOverride()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper");
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .execute();
    }
}
