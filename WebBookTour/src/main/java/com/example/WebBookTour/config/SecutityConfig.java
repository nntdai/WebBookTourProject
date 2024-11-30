package com.example.WebBookTour.config;


import com.example.WebBookTour.repository.TaikhoanadminRepository;
import com.example.WebBookTour.service.TaikhoanadminService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor

public class SecutityConfig {
    private final TaikhoanadminRepository repository;




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/img/**", "/css/**", "/js/**", "/vendor/**").permitAll()
                        .requestMatchers("/").permitAll() // cho qua mà không cần authenticate
                        .requestMatchers("/admin/**").authenticated() // với endpoint /customer/** sẽ yêu cầu authenticate
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL để logout
                        .logoutSuccessUrl("/admin") // Redirect về trang chủ sau khi logout
                        .invalidateHttpSession(true) // Vô hiệu hóa session
                        .clearAuthentication(true) // Xóa thông tin xác thực
                        .deleteCookies("JSESSIONID") // Xóa cookie session
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("hach")
//                .password(passwordEncoder().encode("hacheery"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder().encode("pwd1"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new TaikhoanadminService(repository);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
