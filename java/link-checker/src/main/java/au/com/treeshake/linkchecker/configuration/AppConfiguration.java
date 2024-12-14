package au.com.treeshake.linkchecker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@EnableAspectJAutoProxy
//@EnableCaching
public class AppConfiguration {
}
