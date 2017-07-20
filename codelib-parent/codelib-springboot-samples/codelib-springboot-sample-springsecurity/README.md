# codelib-springboot-sample-springsecurity
## Spring Security
安全框架有两个重要的概念：认证（Authentication）和授权（Authorization）<br>
常用类：

* AuthenticationManagerBuilder
* JdbcUserDetailsManagerConfigurer

### Spring Security 默认建表语句：

```SQL(H2)

create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    enabled boolean not null
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

create table groups (
    id bigint generated by default as identity(start with 0) primary key,
    group_name varchar_ignorecase(50) not null
);

create table group_authorities (
    group_id bigint not null,
    authority varchar(50) not null,
    constraint fk_group_authorities_group foreign key(group_id) references groups(id)
);

create table group_members (
    id bigint generated by default as identity(start with 0) primary key,
    username varchar(50) not null,
    group_id bigint not null,
    constraint fk_group_members_group foreign key(group_id) references groups(id)
);

````

## Spring Boot 对 Spring Security 的支持
Spring Boot 针对 Spring Security 的自动配置在 org.springframework.boot.autoconfigure.security包中<br>
主要通过 SecurityAutoConfiguration 和 SecurityProperties 来完成配置<br>
SecurityAutoConfiguration 导入了 SpringBootWebSecurityConfiguration 中的配置。<br>
在 SpringBootWebSecurityConfiguration 配置中，我们获得如下的自动配置：

1. 自动配置了一个内存中的用户，帐号为 user，密码在程序启动时出现
2. 忽略/css/\*\*、/js/\*\*、/images/\*\*和 /**/favicon.ico 等静态文件的拦截。
3. 自动配置的 securityFilterChainRegistration 的 Bean。

当我们需要自己扩展的配置时，只需配置类继承 WebSecurityConfigurerAdapter 类即可，无须使用 @EnableWebSecurity 注解。


## 参考
* Spring Boot中使用Spring Security进行安全控制：http://www.open-open.com/lib/view/open1464482054012.html
* Spring security 官方指南：http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/