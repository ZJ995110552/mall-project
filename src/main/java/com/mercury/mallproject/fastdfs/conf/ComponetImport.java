package com.mercury.mallproject.fastdfs.conf;
 
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
 
/**
 * @author: Lucifer
 * @create: 2018-11-10 23:15
 * @description:导入FastDFS-Client组件
 **/
@Configuration
@Import(FdfsClientConfig.class)
/**
 *  解决jmx重复注册bean的问题
 */
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class ComponetImport {
    // 导入依赖组件
}