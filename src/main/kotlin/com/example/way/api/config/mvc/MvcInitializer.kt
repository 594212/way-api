//package com.example.apisecurity
//
//import com.example.way.api.config.HttpSessionConfig
//import org.apache.catalina.security.SecurityConfig
//import org.springframework.context.annotation.ComponentScan
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
//
//class MvcInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {
//    //     tag::config[]
//    override fun getRootConfigClasses(): Array<Class<*>> {
//        return arrayOf(SecurityConfig::class.java, HttpSessionConfig::class.java)
//    }
//
//    //     end::config[]
//    override fun getServletConfigClasses(): Array<Class<*>> {
//        return arrayOf(MvcConfig::class.java)
//    }
//
//    override fun getServletMappings(): Array<String> {
//        return arrayOf("/")
//    }
//
//}
//
//@Configuration
//@EnableWebMvc
//@ComponentScan
//class MvcConfig